package com.musicfy.fragments;

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

import com.musicfy.R;
import com.musicfy.presenter.TrackPresenterImpl;
import com.musicfy.presenter.TrackPresenterInterface;

public class FavoriteFragment extends Fragment implements TrackPresenterInterface.view{
    TrackPresenterInterface.presenter presenter;
    private RecyclerView recyclerView;

    public FavoriteFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_favorite, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.rvHome);
        presenter = new TrackPresenterImpl(this);
        presenter.searchTrack("nirvana");

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