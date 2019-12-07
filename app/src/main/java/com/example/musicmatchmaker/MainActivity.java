package com.example.musicmatchmaker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // gets us the Internet connection
        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy =
                    new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }

        // clicking the album button
        Button album = findViewById(R.id.album);
        album.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openAlbum();
            }
        });

        // clicking the lyrics button
        Button lyrics = findViewById(R.id.lyrics);
        lyrics.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openLyrics();
            }
        });
    }

    // helper function to open album page
    public void openAlbum() {
        Intent i = new Intent(this, Album.class);
        startActivity(i);
    }

    // helper function to open lyrics page
    public void openLyrics() {
        Intent i = new Intent(this, Lyrics.class);
        startActivity(i);
    }
}
