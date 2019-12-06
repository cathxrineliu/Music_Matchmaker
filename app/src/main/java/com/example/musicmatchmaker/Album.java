package com.example.musicmatchmaker;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class Album extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.album);
        Button submitAlbum = findViewById(R.id.submitAlbum);
        submitAlbum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openAlbumOutput();
            }
        });
        EditText editArtist = findViewById(R.id.editArtist);
        EditText editTrack = findViewById(R.id.editTrack);
        String artist = editArtist.getText().toString();
        String track = editTrack.getText().toString();
    }

    public void openAlbumOutput() {
        Intent i = new Intent(this, AlbumOutput.class);
        startActivity(i);
    }

    EditText editArtist = findViewById(R.id.editArtist);
    EditText editTrack = findViewById(R.id.editTrack);
    String artist = editArtist.getText().toString();
    String track = editTrack.getText().toString();

    public String getArtist() {
        return artist;
    }
    public void setArtist(String enteredArtist) {
        this.artist = enteredArtist;
    }

    public String getTrack() {
        return track;
    }
    public void setTrack(String enteredTrack) {
        this.track = enteredTrack;
    }
}
