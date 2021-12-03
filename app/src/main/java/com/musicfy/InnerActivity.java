package com.musicfy;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;
import com.musicfy.model.Track;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class InnerActivity extends AppCompatActivity {
    private Track track;
    private boolean isFavorite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.isFavorite = false;

        setContentView(R.layout.activity_inner);

        this.track = getIntent().getParcelableExtra("track");

        TextView textView = findViewById(R.id.musicTitle);
        textView.setText(this.track.getTrackName());

        textView = findViewById(R.id.artistNameTrack);
        textView.setText(this.track.getArtist());

        SharedPreferences sharedPref = getSharedPreferences("favoritePreferences",Context.MODE_PRIVATE);
        Set<String> defaultStringSet = new HashSet<String>();
        Set<String> favorites = sharedPref.getStringSet("favorites", defaultStringSet);

        Gson g = new Gson();

        ImageView favoriteBtn = findViewById(R.id.favoriteButton);

        favoriteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addToFavorites((ImageView) v);
            }
        });

        for (String fav : favorites) {
            Track fTrack = g.fromJson(fav, Track.class);

            if (track.equals(fTrack)) {
                this.isFavorite = true;

                favoriteBtn.setImageResource(R.drawable.icon_star);

                favoriteBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        removeFromFavorites((ImageView) v);
                    }
                });

                break;
            }
        }
    }

    public void addToFavorites(ImageView view) {
        SharedPreferences sharedPref = getSharedPreferences("favoritePreferences", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();

        Set<String> defaultStringSet = new HashSet<String>();

        try {
            Set<String> favorites = sharedPref.getStringSet("favorites", defaultStringSet);

            Gson g = new Gson();

            favorites.add(g.toJson(this.track));

            editor.putStringSet("favorites", favorites);
            editor.commit();

            view.setImageResource(R.drawable.icon_star);
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void removeFromFavorites(ImageView view) {
        SharedPreferences sharedPref = getSharedPreferences("favoritePreferences", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();

        Set<String> defaultStringSet = new HashSet<String>();

        try {
            Set<String> favorites = sharedPref.getStringSet("favorites", defaultStringSet);

            Gson g = new Gson();

            favorites.remove(g.toJson(this.track));

            editor.putStringSet("favorites", favorites);

            editor.commit();

            view.setImageResource(R.drawable.icon_star_border);
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void goBack(View view) {
        finish();
    }
}