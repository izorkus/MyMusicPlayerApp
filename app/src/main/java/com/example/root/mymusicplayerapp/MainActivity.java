package com.example.root.mymusicplayerapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.AdapterView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //ArrayList for songs
        final ArrayList<Song> songs = new ArrayList<Song>();

        //Data to fill ArrayList
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

        final SongPlayer player = new SongPlayer(songs.size(), songs);
        SongAdapter itemsAdapter = new SongAdapter(this, songs);

        //Buttons and message objects
        TextView prevButton = (TextView) findViewById(R.id.prevButton);
        prevButton.setText(" Prev ");
        TextView nextButton = (TextView) findViewById(R.id.nextButton);
        nextButton.setText(" Next ");
        final TextView playButton = (TextView) findViewById(R.id.playButton);
        playButton.setText(" Play ");
        TextView stopButton = (TextView) findViewById(R.id.stopButton);
        stopButton.setText(" Stop ");

        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(itemsAdapter);

        final TextView nowPlayingMsg = (TextView) findViewById(R.id.nowPlaying);
        nowPlayingMsg.setText(player.upDateMessage());

        //On Click listeners for list and buttons
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapter, View v, int position, long arg3) {
                player.setIndex(position);
                if (!(player.isPlaying())) {
                    player.Play();
                    playButton.setText("Pause");
                    nowPlayingMsg.setText(player.upDateMessage());
                } else {
                    nowPlayingMsg.setText(player.upDateMessage());
                }
            }
        });

        prevButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                player.Prev();
                nowPlayingMsg.setText(player.upDateMessage());
            }
        });

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                player.Next();
                nowPlayingMsg.setText(player.upDateMessage());
            }
        });

        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (!(player.isPlaying())) {
                    player.Play();
                    playButton.setText("Pause");
                    nowPlayingMsg.setText(player.upDateMessage());
                } else {
                    player.Stop();
                    playButton.setText(" Play ");
                    nowPlayingMsg.setText(player.upDateMessage());
                }

            }
        });

        stopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                player.Stop();
                playButton.setText(" Play ");
                nowPlayingMsg.setText(player.upDateMessage());

            }
        });

        // OnClickListener for song details activity
        TextView songDetails = (TextView) findViewById(R.id.infoButton);

        songDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent detailsIntent = new Intent(MainActivity.this, SongDetails.class);
                detailsIntent.putExtra("name", player.getIndex());
                startActivity(detailsIntent);
            }
        });
    }
}
