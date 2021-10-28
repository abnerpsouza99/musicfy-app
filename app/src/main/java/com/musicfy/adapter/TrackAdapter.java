package com.musicfy.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.musicfy.R;
import com.musicfy.model.Track;

import java.util.List;

public class TrackAdapter extends RecyclerView.Adapter<TrackAdapter.ViewHolder> {

    private List<Track> dados;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public View view;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.view = itemView;
        }
    }

    public TrackAdapter(List<Track> tracks) { this.dados = tracks; }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ViewGroup viewGroup;
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.track_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Track track = dados.get(position);
        TextView tv = holder.view.findViewById(R.id.tvTrackName);
        System.out.println(track.toString());
        tv.setText(track.getTrackName());
        tv = holder.view.findViewById(R.id.tvAlbumTrack);
        tv.setText(track.getAlbum());
    }

    @Override
    public int getItemCount() {
        return dados.size();
    }

}
