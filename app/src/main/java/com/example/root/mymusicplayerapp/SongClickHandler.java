package com.example.root.mymusicplayerapp;

import android.app.Activity;
import android.widget.AdapterView;
import android.view.View;
import android.widget.Toast;
import android.view.ViewGroup;
import android.widget.AdapterView.OnItemClickListener;

public class SongClickHandler implements AdapterView.OnItemClickListener{

    @Override
    public void onItemClick(AdapterView<?> adapter, View view, int position, long arg3) {
        // TODO Auto-generated method stub
        Toast.makeText(view.getContext(),"Listner Test" + position, Toast.LENGTH_SHORT).show();

    }


}
