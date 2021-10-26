package com.musicfy.presenter;

import android.content.Context;

import androidx.recyclerview.widget.RecyclerView;

public interface ArtistPresenterInterface {
    interface view {
        void buildRecycler(RecyclerView.Adapter adapter);
        Context getContext();
    }

    interface presenter {
        void getAllArtistsByPage(int page);
        void getArtistById(int id);
    }
}
