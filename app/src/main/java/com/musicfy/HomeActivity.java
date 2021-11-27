package com.musicfy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.musicfy.presenter.TrackPresenterImpl;
import com.musicfy.presenter.TrackPresenterInterface;

public class HomeActivity extends AppCompatActivity implements TrackPresenterInterface.view {

    TrackPresenterInterface.presenter presenter;
    private EditText searchInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        presenter = new TrackPresenterImpl(this);
        presenter.searchTrack("nirvana");

        searchInput = (EditText) findViewById(R.id.searchInput);
        searchInput.addTextChangedListener(textWatcher);
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