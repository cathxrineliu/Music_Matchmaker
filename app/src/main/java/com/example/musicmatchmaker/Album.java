package com.example.musicmatchmaker;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import org.jmusixmatch.MusixMatch;
import org.jmusixmatch.entity.track.Track;

public class Album extends AppCompatActivity {

    public static Track track;
    private String theAlbumName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // basic initial onCreate stuff (api key, internet, etc.)
        super.onCreate(savedInstanceState);
        setContentView(R.layout.album);

        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy =
                    new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }

        // clicking submitAlbum button will move you to new screen with resulting album
        Button submitAlbum = findViewById(R.id.submitLyrics);
        submitAlbum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openAlbumOutput();
            }
        });
    }

    // helper function when clicking "Submit" button
    public void openAlbumOutput() {
        String apiKey = "3c39a8eee4ffc276f2553676ec83aeea";
        MusixMatch musixMatch = new MusixMatch(apiKey);
        EditText editArtist = findViewById(R.id.editArtist);
        EditText editSong = findViewById(R.id.editSong);
        String artist = editArtist.getText().toString();
        String song = editSong.getText().toString();

        // function to obtain album name
        try {
            if (song.length() == 0) {
                theAlbumName = "Invalid Song Name";
            } else if (artist.length() == 0) {
                theAlbumName = "Invalid Artist Name";
            } else {
                track = musixMatch.getMatchingTrack(song, artist);
                theAlbumName = track.getTrack().getAlbumName();
                System.out.println(theAlbumName);
            }
        } catch (Exception e) {
            theAlbumName = "Incorrect Data";
            System.out.println(theAlbumName);
        }

        Intent i = new Intent(this, AlbumOutput.class);
        i.putExtra("theAlbumName", "Album Name: " + theAlbumName);
        startActivity(i);
    }
}
