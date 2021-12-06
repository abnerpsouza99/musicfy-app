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
import android.widget.TextView;

import com.musicfy.R;
import com.musicfy.presenter.TrackPresenterImpl;
import com.musicfy.presenter.TrackPresenterInterface;

public class HomeFragment extends Fragment implements TrackPresenterInterface.view{
    TrackPresenterInterface.presenter presenter;
    private EditText searchInput;
    private  RecyclerView recyclerView;
    private View view;

    public HomeFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        this.view =  inflater.inflate(R.layout.fragment_home, container, false);

        searchInput = (EditText) view.findViewById(R.id.searchInput);
        recyclerView = (RecyclerView) view.findViewById(R.id.rvHome);
        presenter = new TrackPresenterImpl(this);

        searchInput.addTextChangedListener(textWatcher);



        return view;
    }

    @Override
    public void buildRecycler(RecyclerView.Adapter adapter) {
        LinearLayoutManager llm = new LinearLayoutManager(getActivity().getApplicationContext());
        recyclerView.setLayoutManager(llm);
        recyclerView.setAdapter(adapter);
        TextView textView = view.findViewById(R.id.textInformation);
        if(adapter.getItemCount() <= 0){
            textView.setText("Nenhuma música encontrada.");
        } else{
            textView.setText("");
        }
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
            if (s.toString().length() > 3)
                presenter.searchTrack(s.toString());
        }
    };
}