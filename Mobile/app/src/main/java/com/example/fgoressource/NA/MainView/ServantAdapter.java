package com.example.fgoressource.NA.MainView;

import android.graphics.Bitmap;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;
import com.example.fgoressource.R;
import com.example.fgoressource.VolleyRequestQueue;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

public class ServantAdapter extends RecyclerView.Adapter<ServantViewHolder> {

    private final JSONArray _servantList;
    private IServant clickListener;


    @NonNull
    @Override
    public ServantViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.servant_view_holder, parent, false);
        return new ServantViewHolder(view, clickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ServantViewHolder holder, int position) {

        try {
            JSONObject _servantData = _servantList.getJSONObject(position);
            String _urlFace = _servantData.getString("face");
            holder.getName().setText(_servantData.getString("name"));
            holder.getID().setText(_servantData.getString("collectionNo"));

            ImageRequest _request = new ImageRequest(_urlFace, new Response.Listener<Bitmap>() {

                @Override
                public void onResponse(Bitmap response) {
                    holder.getFace().setImageBitmap(response);
                }
            }, 0, 0, ImageView.ScaleType.CENTER, Bitmap.Config.RGB_565, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Log.e("ICON_LOADING", error.getMessage());
                }
            });
            VolleyRequestQueue.getInstance().add(_request);
        } catch (JSONException e) {
            e.printStackTrace();
        }


    }

    @Override
    public int getItemCount() {
        return _servantList.length();
    }

    public ServantAdapter(@NonNull JSONArray servList) {
        _servantList = servList;
    }

    public void setOnItemClickListener(IServant itemClickListener) {
        this.clickListener = itemClickListener;
    }
}
