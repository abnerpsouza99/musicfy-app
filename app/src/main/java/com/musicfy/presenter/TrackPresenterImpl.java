package com.musicfy.presenter;

import android.widget.Adapter;

import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.musicfy.adapter.TrackAdapter;
import com.musicfy.model.Track;
import com.musicfy.model.utils.Utils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class TrackPresenterImpl implements TrackPresenterInterface.presenter, Response.ErrorListener{
    private List<Track> tracks = new ArrayList<Track>();
    private TrackPresenterInterface.view activity;
    private Utils utils = new Utils();

    public TrackPresenterImpl(TrackPresenterInterface.view activity){
        this.activity = activity;
    }

    @Override
    public void getTrack(int idArtist, int idAlbum, int idTrack) {
        RequestQueue queue = Volley.newRequestQueue(activity.getContext());
        JsonObjectRequest request = new JsonObjectRequest(
                Request.Method.GET,
                utils.getBaseUrl() + "/artists/" + idArtist + "/albums/" + idAlbum + "/tracks/" + idTrack + "?apikey=" + utils.getApiKey(),
                null,
                new Response.Listener<JSONObject>(){
                    @Override
                    public void onResponse(JSONObject response) {
                        onResponseGetTrack(response);
                    }
                }, this);
        queue.add(request);
    }

    @Override
    public void getAllTracksFromAAlbum(int idArtist, int idAlbum) {
        RequestQueue queue = Volley.newRequestQueue(activity.getContext());
        JsonObjectRequest request = new JsonObjectRequest(
                Request.Method.GET,
                utils.getBaseUrl() + "/artists/" + idArtist + "/albums/" + idAlbum + "/tracks?apikey=" + utils.getApiKey(),
                null,
                new Response.Listener<JSONObject>(){
                    @Override
                    public void onResponse(JSONObject response) {
                        onResponseGetAllTracksFromAAlbum(response);
                    }
                }, this);
        queue.add(request);
    }

    @Override
    public void searchTrack(String inputText) {
        int limit = 10;
        boolean lyrics = true;
        String type = "track";

        RequestQueue queue = Volley.newRequestQueue(activity.getContext());
        JsonObjectRequest request = new JsonObjectRequest(
                Request.Method.GET,
                utils.getBaseUrl() + "?q=" + inputText + "&limit=" + limit + "&apikey=" + utils.getApiKey() + "&type=" + type + "&lyrics=" + lyrics,
                null,
                new Response.Listener<JSONObject>(){
                    @Override
                    public void onResponse(JSONObject response) {
                        onResponseSearch(response);
                    }
                }, this);
        queue.add(request);
    }

    public void onResponseGetTrack(JSONObject response){
        try{
            JSONObject result = response.getJSONObject("result");
            System.out.println(result);
        }catch (JSONException exception){
            exception.printStackTrace();
        }

    }

    public void onResponseGetAllTracksFromAAlbum(JSONObject response){
        tracks.clear();
        try{
            JSONObject result = response.getJSONObject("result");
            JSONArray resultTracks = result.getJSONArray("tracks");
            for (int i = 0; i < resultTracks.length(); i++){
                Track track = new Track(resultTracks.getJSONObject(i));
                tracks.add(track);
            }
            RecyclerView.Adapter adapter = new TrackAdapter(tracks, activity.getContext());
            activity.buildRecycler(adapter);
        }catch (JSONException exception){
            exception.printStackTrace();
        }
    }

    public void onResponseSearch(JSONObject response){
        tracks.clear();
        try{
            JSONArray result = response.getJSONArray("result");
            for (int i = 0; i < result.length(); i++){
                Track track = new Track(result.getJSONObject(i));
                tracks.add(track);
            }

            RecyclerView.Adapter adapter = new TrackAdapter(tracks, activity.getContext());
            activity.buildRecycler(adapter);
        }catch (JSONException exception){
            exception.printStackTrace();
        }
    }

    public void setAndShowTracks(List<Track> newTracks) {
        this.tracks = newTracks;
        RecyclerView.Adapter adapter = new TrackAdapter(tracks, activity.getContext());
        activity.buildRecycler(adapter);
    }

    @Override
    public void onErrorResponse(VolleyError error) {

    }
}
