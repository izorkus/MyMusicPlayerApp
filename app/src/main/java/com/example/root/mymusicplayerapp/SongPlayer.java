package com.example.root.mymusicplayerapp;

import java.util.ArrayList;

public class SongPlayer {
    private boolean mIsPlaying;
    private int mArraySize;
    private int mIndexSong;
    private String mMessage;
    private ArrayList<Song> mSongs;

    public SongPlayer(int ArraySize, ArrayList<Song> songs){
        mIsPlaying = false;
        mIndexSong = 0;
        mArraySize = ArraySize;
        mMessage = "Player stopped.";
        mSongs = songs;

    }

    public final void Play(){
        mIsPlaying = true;
    }

    public final void Stop(){
        mIsPlaying = false;
    }

    public final void Next(){
        mIndexSong++;
        if (mIndexSong > mArraySize -1){ mIndexSong = 0;}

    }
    public final void Prev(){
        mIndexSong--;
        if (mIndexSong < 0){ mIndexSong = mArraySize - 1;}
    }

    public void setIndex(int index){
        mIndexSong = index;
    }

    public int getIndex(){
        return mIndexSong;
    }

    public boolean isPlaying(){
        return mIsPlaying;
    }

    public String upDateMessage(){
        if(!(isPlaying())){mMessage = "Player stopped.";}

        if(isPlaying()){
            Song nowPlayingTitle = (Song) mSongs.get(mIndexSong);
            Song nowPlayingArtist = (Song) mSongs.get(mIndexSong);
            mMessage = "Now playing: " + nowPlayingTitle.getSongTitle() + " by " + nowPlayingArtist.getSongArtist();
        }
        return mMessage;
    }



}


