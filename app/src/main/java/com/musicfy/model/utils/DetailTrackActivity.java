package com.musicfy.model.utils;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.musicfy.R;
import com.musicfy.model.Track;

public class DetailTrackActivity extends AppCompatActivity {

    @Override
    protected void onCreate (Bundle savedInstaceState){
        super.onCreate(savedInstaceState);
        setContentView(R.layout.activity_detalhe_track);
//        Intent intent = getIntent();
//        TextView tv = findViewById(R.id.tvTrackName);
//        int i = intent.getIntExtra("id" , -1);
//        Track track = intent.getParcelableExtra("obj");
//        tv.setText(track.trackName);
//        tv = findViewById(R.id.artist);
//        tv.setText(track.toString());
    }

}
