package com.example.root.mymusicplayerapp;

public class Song {
    private String mSongTitle;
    private String mSongArtist;
    private int mSongDuration;
    private int min;
    private int sec;
    private String secString;
    private String mSongDurationString;


    public Song(String songTitle, String songArtist, int songDuration){
        mSongTitle = songTitle;
        mSongArtist = songArtist;
        mSongDuration = songDuration;
    }

    public String getSongTitle() {
        return mSongTitle;
    }

    public String getSongArtist() {
        return mSongArtist;
    }

    public String getSongDuration() {
        min = mSongDuration / 60;
        sec = mSongDuration - (min * 60);

        if (sec < 10){secString = "0" + sec;} else {secString = Integer.toString(sec);}

        mSongDurationString = (min + ":" + secString);
        return mSongDurationString;
    }
}
