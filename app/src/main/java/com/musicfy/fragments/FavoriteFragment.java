package com.musicfy.fragments;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.google.gson.Gson;
import com.musicfy.R;
import com.musicfy.model.Track;
import com.musicfy.presenter.TrackPresenterImpl;
import com.musicfy.presenter.TrackPresenterInterface;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FavoriteFragment extends Fragment implements TrackPresenterInterface.view{
    TrackPresenterInterface.presenter presenter;
    private RecyclerView recyclerView;

    private ArrayList<Track> favoriteTracks;

    public FavoriteFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.favoriteTracks = new ArrayList<>();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_favorite, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.rvHome);
        presenter = new TrackPresenterImpl(this);

        SharedPreferences sharedPref = getActivity().getSharedPreferences("favoritePreferences",Context.MODE_PRIVATE);
        Set<String> defaultStringSet = new HashSet<String>();
        Set<String> favorites = sharedPref.getStringSet("favorites", defaultStringSet);

        Gson g = new Gson();

        for (String fav : favorites) {
            Track fTrack = g.fromJson(fav, Track.class);
            favoriteTracks.add(fTrack);
        }

        if (! favoriteTracks.isEmpty()) {
            presenter.setAndShowTracks(favoriteTracks);
        }
        else {
            TextView title = view.findViewById(R.id.favoriteTitle);
            title.setText("Nenhum favorito salvo.");
        }

        return view;
    }

    @Override
    public void buildRecycler(RecyclerView.Adapter adapter) {
        LinearLayoutManager llm = new LinearLayoutManager(getActivity().getApplicationContext());
        recyclerView.setLayoutManager(llm);
        recyclerView.setAdapter(adapter);

    }

    private TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
        }

        @Override
        public void afterTextChanged(Editable s) {
            presenter.searchTrack(s.toString());
        }
    };
}