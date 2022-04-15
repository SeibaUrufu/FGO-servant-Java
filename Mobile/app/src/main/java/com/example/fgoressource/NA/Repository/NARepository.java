package com.example.fgoressource.NA.Repository;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.fgoressource.VolleyRequestQueue;

import org.json.JSONArray;
import org.json.JSONObject;

public class NARepository {

    private final String _url = "https://api.atlasacademy.io/export/NA/basic_servant.json";
    private final String _urlDetailled = "https://api.atlasacademy.io/nice/NA/servant/";

    public NARepository() {}

    public void searchServants(MutableLiveData<JSONArray> servMLD) {
        JsonArrayRequest request = new JsonArrayRequest(
                _url,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        servMLD.setValue(response);
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("Request", "Volley error: "+error.getMessage());
                    }
                }
        );
        request.setRetryPolicy(new DefaultRetryPolicy(DefaultRetryPolicy.DEFAULT_TIMEOUT_MS * 48,
                0, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        VolleyRequestQueue.getInstance().add(request);
    }

    public void searchServantData(String id, MutableLiveData<JSONObject> servMLD) {
        JsonObjectRequest request = new JsonObjectRequest(
                _urlDetailled+id,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.d("Response", String.valueOf(response));
                        servMLD.setValue(response);
                    }
                }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Log.d("Request", "Volley error: "+error.getMessage());
                }
            }
        );
        VolleyRequestQueue.getInstance().add(request);
    }
}
