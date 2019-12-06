package com.example.musicmatchmaker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;

import org.jmusixmatch.MusixMatch;
import org.jmusixmatch.MusixMatchException;
import org.jmusixmatch.entity.track.Track;
import org.jmusixmatch.entity.track.TrackData;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (android.os.Build.VERSION.SDK_INT > 9)
        {
            StrictMode.ThreadPolicy policy = new
                    StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }

        String apiKey = "3c39a8eee4ffc276f2553676ec83aeea";
        MusixMatch musixMatch = new MusixMatch(apiKey);
        try {
            Track track = musixMatch.getMatchingTrack("Money Longer", "Lil Uzi Vert");
            System.out.println(track.getTrack().getAlbumName());
        } catch (Exception e) {
            System.out.println("Not good");
        }

//        try {
//            List<Track> tracks = musixMatch.searchTracks("", "Eminem", "", 10, 10, true);
//            for (Track trk : tracks) {
//                TrackData trkData = trk.getTrack();
//
//                System.out.println("AlbumID : "     + trkData.getAlbumId());
//                System.out.println("Album Name : "  + trkData.getAlbumName());
//                System.out.println("Artist ID : "   + trkData.getArtistId());
//                System.out.println("Artist Name : " + trkData.getArtistName());
//                System.out.println("Track ID : "    + trkData.getTrackId());
//                System.out.println();
//            }
//        } catch (MusixMatchException e) {
//            System.out.println("Exception");
//        }

        try {
            String trackName = "God's Plan";
            String artistName = "Drake";

            Track track = musixMatch.getMatchingTrack(trackName, artistName);
            TrackData data = track.getTrack();

            System.out.println("AlbumID : "    + data.getAlbumId());
            System.out.println("Album Name : " + data.getAlbumName());
            System.out.println("Artist ID : "  + data.getArtistId());
            System.out.println("Artist Name : " + data.getArtistName());
            System.out.println("Track ID : "   + data.getTrackId());
        } catch (MusixMatchException e) {
            System.out.println("Exception");
        }
        Button album = findViewById(R.id.album);
        album.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openAlbum();
            }
        });
    }
    public void openAlbum() {
        Intent i = new Intent(this, Album.class);
        startActivity(i);
    }
}
