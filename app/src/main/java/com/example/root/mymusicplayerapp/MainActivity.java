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

        songs.add(new Song("One","Metallica", 214));
        songs.add(new Song("Back In Black", "ACDC", 320));
        songs.add(new Song("three", "tolookosu", 190));
        songs.add(new Song("four","oyyisa", 270));
        songs.add(new Song("five", "massokka",234));
        songs.add(new Song("six", "temmokka",432));
        songs.add(new Song("seven", "kenekkaku",232));
        songs.add(new Song("eight","kawinta",343));
        songs.add(new Song("nine", "wo'e",345));
        songs.add(new Song("ten","na'aacha",350));

        final SongPlayer player = new SongPlayer(songs.size(), songs);

        SongAdapter itemsAdapter = new SongAdapter(this, songs);

        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(itemsAdapter);

        final TextView nowPlayingMsg = (TextView) findViewById(R.id.nowPlaying);
        nowPlayingMsg.setText(player.upDateMessage());

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> adapter, View v, int position, long arg3) {
                Toast.makeText(v.getContext(),"Listner Test" + position, Toast.LENGTH_SHORT).show();
                player.setIndex(position);
                nowPlayingMsg.setText(player.upDateMessage());
                //String value = (String)adapter.getItemAtPosition(position);
                // assuming string and if you want to get the value on click of list item
                // do what you intend to do on click of listview row
            }
        });

        TextView prevButton = (TextView) findViewById(R.id.prevButton);
        prevButton.setText(" Prev ");
        prevButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                player.Prev();
                nowPlayingMsg.setText(player.upDateMessage());
            }
        });

        TextView nextButton = (TextView) findViewById(R.id.nextButton);
        nextButton.setText(" Next ");
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                player.Next();
                nowPlayingMsg.setText(player.upDateMessage());
            }
        });

        final TextView playButton = (TextView) findViewById(R.id.playButton);
        playButton.setText(" Play ");
        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (!(player.isPlaying())){player.Play();playButton.setText("Pause");
                    nowPlayingMsg.setText(player.upDateMessage());
                }

                else{player.Stop();playButton.setText(" Play ");
                    nowPlayingMsg.setText(player.upDateMessage());}

            }
        });


        TextView stopButton = (TextView) findViewById(R.id.stopButton);
        stopButton.setText(" Stop ");
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
