package com.musicfy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;

import com.musicfy.presenter.TrackPresenterImpl;
import com.musicfy.presenter.TrackPresenterInterface;

public class HomeActivity extends AppCompatActivity implements TrackPresenterInterface.view {

    TrackPresenterInterface.presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        presenter = new TrackPresenterImpl(this);
        presenter.searchTrack();
    }

    @Override
    public void buildRecycler(RecyclerView.Adapter adapter) {
        RecyclerView rv = findViewById(R.id.rvHome);
        LinearLayoutManager llm = new LinearLayoutManager(getApplicationContext());
        rv.setLayoutManager(llm);
        rv.setAdapter(adapter);
    }

    @Override
    public Context getContext() {
        return this.getApplicationContext();
    }
}