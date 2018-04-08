package com.example.root.mymusicplayerapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.AdapterView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ArrayList<Song> songs = new ArrayList<Song>();

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


        // OnClickListener for song details
        // Find the View that shows the numbers category
        //       TextView numbers = (TextView) findViewById(R.id.numbers);

        // Set a click listener on that View
        //       numbers.setOnClickListener(new OnClickListener() {
        // The code in this method will be executed when the numbers category is clicked on.
        //           @Override
        //           public void onClick(View view) {
        // Create a new intent to open the {@link NumbersActivity}
//                Intent numbersIntent = new Intent(MainActivity.this, NumbersActivity.class);

        // Start the new activity
//                startActivity(numbersIntent);
        //           }
        //       });

    }
}
