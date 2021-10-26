package com.musicfy.presenter;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.musicfy.model.Album;
import com.musicfy.model.utils.Utils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class AlbumPresenterImpl implements AlbumPresenterInterface.presenter, Response.ErrorListener{
    private List<Album> albums = new ArrayList<Album>();
    private Album singleAlbum;
    private AlbumPresenterInterface.view activity;
    private Utils utils = new Utils();

    public AlbumPresenterImpl(AlbumPresenterInterface.view activity){
        this.activity = activity;
    }

    @Override
    public void getAlbum(int idArtist, int idAlbum) {
        RequestQueue queue = Volley.newRequestQueue(activity.getContext());
        JsonObjectRequest request = new JsonObjectRequest(
                Request.Method.GET,
                utils.getBaseUrl() + "/artist/" + idArtist + "/albums/" + idAlbum + "?apikey=" + utils.getApiKey(),
                null,
                new Response.Listener<JSONObject>(){
                    @Override
                    public void onResponse(JSONObject response) {
                        onResponseGetAlbum(response);
                    }
                }, this);
        queue.add(request);
    }

    @Override
    public void getAllAlbumsFromArtist(int idArtist) {
        RequestQueue queue = Volley.newRequestQueue(activity.getContext());
        JsonObjectRequest request = new JsonObjectRequest(
                Request.Method.GET,
                utils.getBaseUrl() + "/artists/" + idArtist + "/albums?apikey=" + utils.getApiKey(),
                null,
                new Response.Listener<JSONObject>(){
                    @Override
                    public void onResponse(JSONObject response) {
                        onResponseGetAllAlbumsFromArtist(response);
                    }
                }, this);
    }

    @Override
    public void onErrorResponse(VolleyError error) {

    }

    public void onResponseGetAllAlbumsFromArtist(JSONObject response){
        albums.clear();
        try{
            JSONObject result = response.getJSONObject("result");
            JSONArray resultAlbums = result.getJSONArray("albums");
            for (int i = 0; i < resultAlbums.length(); i++){
                albums.add(new Album(resultAlbums.getJSONObject(i)));
            }
        }catch (JSONException exception){
            exception.printStackTrace();
        }
    }

    public void onResponseGetAlbum(JSONObject response){
        singleAlbum = null;
        try{
            JSONObject result = response.getJSONObject("result");
            singleAlbum = new Album(result);
            System.out.println(singleAlbum);
        }catch (JSONException exception){
            exception.printStackTrace();
        }
    }
}
