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
import org.jmusixmatch.entity.track.TrackData;

public class Lyrics extends AppCompatActivity {

    public static Track track;
    private String theLyrics;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // basic initial onCreate stuff (api key, internet, etc.)
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lyrics);

        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy =
                    new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }

        // clicking submitLyrics button will move you to new screen with resulting lyrics
        Button submitLyrics = findViewById(R.id.submitLyrics);
        submitLyrics.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openLyricsOutput();
            }
        });
    }

    public void openLyricsOutput() {
        String apiKey = "3c39a8eee4ffc276f2553676ec83aeea";
        MusixMatch musixMatch = new MusixMatch(apiKey);
        EditText editArtist = findViewById(R.id.editArtist);
        EditText editSong = findViewById(R.id.editSong);
        String artist = editArtist.getText().toString();
        String song = editSong.getText().toString();

        // function to obtain lyrics
        try {
            if (song.length() == 0) {
                theLyrics = "Invalid Song Name";
            } else if (artist.length() == 0) {
                theLyrics = "Invalid Artist Name";
            } else {
                track = musixMatch.getMatchingTrack(song, artist);
                TrackData data = track.getTrack();
                int trackID = data.getTrackId();
                theLyrics = musixMatch.getLyrics(trackID).getLyricsBody();
                System.out.println(theLyrics);
            }
        } catch (Exception e) {
            theLyrics = "Incorrect Data";
            System.out.println("Incorrect Data");
        }

        Intent i = new Intent(this, LyricsOutput.class);
        i.putExtra("theLyrics", theLyrics);
        startActivity(i);
    }
}
