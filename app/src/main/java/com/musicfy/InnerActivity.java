package com.musicfy;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.musicfy.databinding.ActivityInnerBinding;
import com.musicfy.model.Lyric;
import com.musicfy.model.Track;
import com.musicfy.presenter.LyricPresenterImpl;
import com.musicfy.presenter.LyricPresenterInterface;
import com.musicfy.presenter.TrackPresenterImpl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class InnerActivity extends AppCompatActivity implements LyricPresenterInterface.view{
    LyricPresenterInterface.presenter presenter;
    private Track track;
    private boolean isFavorite;
    ActivityInnerBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = new LyricPresenterImpl(this);

        this.isFavorite = false;
        this.track = getIntent().getParcelableExtra("track");
        presenter.getLyricsFromTrack(track.getIdArtist(), track.getIdAlbum(), track.getId());

        // DataBinding
        binding = DataBindingUtil.setContentView(this, R.layout.activity_inner);
        binding.setTrack(this.track);

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

    @Override
    public Context getContext() {
        return this.getApplicationContext();
    }

    @Override
    public void setLyric(Lyric lyric) {
        binding.setLyric(lyric);
    }
}