package com.musicfy.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.musicfy.InnerActivity;
import com.musicfy.R;
import com.musicfy.databinding.TrackLayoutBinding;
import com.musicfy.model.Track;
import com.squareup.picasso.Picasso;

import java.util.List;

public class TrackAdapter extends RecyclerView.Adapter<TrackAdapter.ViewHolder> {

    private List<Track> data;
    private Context context;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TrackLayoutBinding binding;

        public ViewHolder(@NonNull TrackLayoutBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

    public TrackAdapter(List<Track> tracks, Context context) {
        this.data = tracks;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ViewGroup viewGroup;
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        TrackLayoutBinding binding = DataBindingUtil.inflate(layoutInflater, R.layout.track_layout, parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Track track = data.get(position);
        holder.binding.setTrack(track);
        ImageView imageView = holder.itemView.findViewById(R.id.trackImgView);
        Picasso.get().load(track.getCover()).into(imageView);

        CardView cv = holder.itemView.findViewById(R.id.cardView);
        cv.setTag(track);
        cv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, InnerActivity.class);
                intent.putExtra("track", (Track) v.getTag());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
