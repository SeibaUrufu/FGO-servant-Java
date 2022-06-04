package com.example.fgoressource;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

//Singleton format
public class VolleyRequestQueue {

    private static VolleyRequestQueue instance = null;
    private RequestQueue requestQueue;


    private VolleyRequestQueue(Context context) {
        requestQueue = Volley.newRequestQueue(context.getApplicationContext());
    }

    public static synchronized VolleyRequestQueue getInstance(Context context) {
        if (instance == null)
            instance = new VolleyRequestQueue(context);
        return instance;
    }

    public static synchronized VolleyRequestQueue getInstance() {
        return instance;
    }
    public <T> void add(Request<T> req) {
        requestQueue.add(req);
    }

}
