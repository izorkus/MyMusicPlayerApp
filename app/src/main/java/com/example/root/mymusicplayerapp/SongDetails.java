package com.example.root.mymusicplayerapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class SongDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song_details);

        //Extra data with Intend for sync between activites
        Intent intMsg= getIntent();
        Bundle b = intMsg.getExtras();
        int index = (int) b.get("name");

        //Same data
        ArrayList<Song> songs = new ArrayList<Song>();

        songs.add(new Song("One", "Metallica", 444));
        songs.add(new Song("Back In Black", "ACDC", 255));
        songs.add(new Song("Shake a Leg", "ACDC", 245));
        songs.add(new Song("Fade to Black", "Metallica", 417));
        songs.add(new Song("Black", "Pearl Jam", 348));
        songs.add(new Song("Wish You Were Here", "Pink Floyd", 334));
        songs.add(new Song("Money", "Pink Floyd", 413));
        songs.add(new Song("Moonloop", "Porcupine Tree", 1024));
        songs.add(new Song("Wojenka", "Lao Che", 210));
        songs.add(new Song("Fuel", "Metallica", 269));

        Song nowPlayingSong = (Song) songs.get(index);

        //TextViews for data presentation
        TextView artistDetail = (TextView) findViewById(R.id.artistDetail);
        artistDetail.setText(nowPlayingSong.getSongArtist());

        TextView titleDetail = (TextView) findViewById(R.id.titleDetail);
        titleDetail.setText(nowPlayingSong.getSongTitle());

        TextView timeDetail = (TextView) findViewById(R.id.durationsDetail);
        timeDetail.setText(nowPlayingSong.getSongDuration());

        TextView songDetails = (TextView) findViewById(R.id.backButton);

        //Back button
        songDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent playerIntent = new Intent(SongDetails.this, MainActivity.class);
                startActivity(playerIntent);
            }
        });


    }
}
