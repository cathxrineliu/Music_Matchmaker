package com.example.musicmatchmaker;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class AlbumOutput extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.output_album);

        String albumName = getIntent().getStringExtra("theAlbumName");
        TextView albumNameOutput = findViewById(R.id.lyricsOutput);
        albumNameOutput.setText(albumName);
    }
}
