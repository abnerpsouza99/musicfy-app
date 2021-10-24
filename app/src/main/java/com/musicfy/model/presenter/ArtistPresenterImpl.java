package com.musicfy.model.presenter;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.musicfy.model.Artist;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ArtistPresenterImpl implements ArtistPresenterInterface.presenter, Response.ErrorListener{

    private List<Artist> artists = new ArrayList<Artist>();
    private ArtistPresenterInterface.view activity;
    static final private String apiKey = "73221755SpueZZEnWOcKdYPAdWGEAYpBv4tRbnNkYoFZQX4a0a7Km7uC";
    static final private String baseUrl = "https://api.happi.dev/v1/music/artists";

    public ArtistPresenterImpl(ArtistPresenterInterface.view activity){
        this.activity = activity;
    }

    @Override
    public void getAllArtistsByPage(int page){
        RequestQueue queue = Volley.newRequestQueue(activity.getContext());
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET,
                baseUrl + "?page=" + page + "&apikey=" + apiKey,
                null,
                new Response.Listener<JSONObject>(){
                    @Override
                    public void onResponse(JSONObject response) {
                        onResponseGetAllArtistsByPage(response);
                    }
                }, this);

        queue.add(request);
    }

    @Override
    public void getArtistById(int id) {
        RequestQueue queue = Volley.newRequestQueue(activity.getContext());
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET,
                baseUrl + "/?id_artist=" + id + "&apikey=" + apiKey,
                null,
                new Response.Listener<JSONObject>(){
                    @Override
                    public void onResponse(JSONObject response) {
                        onResponseGetArtistById(response);
                    }
                }, this);

        queue.add(request);
    }

    @Override
    public void onErrorResponse(VolleyError error) {

    }

    public void onResponseGetAllArtistsByPage(JSONObject response){
        try{
            JSONArray result = response.getJSONArray("result");
            artists.clear();
            // Limitando em 10 registros vindos da API
            for(int i = 0; i < 2; i++){
                Artist artist = new Artist(result.getJSONObject(i));
                artists.add(artist);
            }
        }catch (JSONException exception){
            exception.printStackTrace();
        }
    }

    public void onResponseGetArtistById(JSONObject response){
        try{
            JSONObject result = response.getJSONObject("result");
            Artist artist = new Artist(result);
            System.out.println("Artist: " + artist.toString());

        }catch (JSONException exception){
            exception.printStackTrace();
        }
    }
}
