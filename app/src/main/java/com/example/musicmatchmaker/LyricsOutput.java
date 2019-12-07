package com.example.musicmatchmaker;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class LyricsOutput extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.output_lyrics);

        String lyrics = getIntent().getStringExtra("theLyrics");
        TextView albumNameOutput = findViewById(R.id.lyricsOutput);
        albumNameOutput.setText(lyrics);
    }
}
