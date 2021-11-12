package com.musicfy;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.musicfy.model.Track;

public class InnerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inner);

        Track track = getIntent().getParcelableExtra("track");
        TextView textView = findViewById(R.id.musicTitle);
        textView.setText(track.getTrackName());
        textView = findViewById(R.id.artistNameTrack);
        textView.setText(track.getArtist());
    }
}