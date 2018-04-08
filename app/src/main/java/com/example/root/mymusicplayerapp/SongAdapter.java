package com.example.root.mymusicplayerapp;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class SongAdapter extends ArrayAdapter<Song> {


    public SongAdapter(Activity context, ArrayList<Song> songs) {
        super(context, 0, songs);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        Song currentSong = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID songname
        TextView songnameTextView = (TextView) listItemView.findViewById(R.id.songname_text_view);
        // Get the song name from the current Song object and
        // set this text on the name TextView
        songnameTextView.setText(currentSong.getSongTitle());

        // Find the TextView in the list_item.xml layout with the ID artist_text
        TextView artistTextView = (TextView) listItemView.findViewById(R.id.artist_text_view);
        // Get the Artist from the current Song object and
        // set this text on the number TextView
        artistTextView.setText(currentSong.getSongArtist());

        // Find the TextView in the list_item.xml layout with the ID songduration
        TextView durationTextView = (TextView) listItemView.findViewById(R.id.songduration_text_view);
        // Get the song duration from the current Song object and
        // set this text on the number TextView
        durationTextView.setText(currentSong.getSongDuration());

        // Return the whole list item layout (containing 2 TextViews and an ImageView)
        // so that it can be shown in the ListView
        return listItemView;


    }

}
