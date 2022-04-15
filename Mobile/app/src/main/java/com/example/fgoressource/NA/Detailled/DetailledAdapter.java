package com.example.fgoressource.NA.Detailled;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fgoressource.R;

import org.json.JSONException;
import org.json.JSONObject;

public class DetailledAdapter extends RecyclerView.Adapter<DetailledViewHolder>{

    private final JSONObject _dataList;


    @NonNull
    @Override
    public DetailledViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.servant_detailled_na, parent, false);
        return new DetailledViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DetailledViewHolder holder, int position) {
        try {
            holder.getServantName().setText(_dataList.getString("name"));
            holder.getServAtkMin().setText(String.format("Atk min: %s", _dataList.getString("atkBase")));
            holder.getServAtkMax().setText(String.format("Atk max: %s", _dataList.getString("atkMax")));
            holder.getServHPMin().setText(String.format("HP min: %s", _dataList.getString("hpBase")));
            holder.getServHPMax().setText(String.format("HP max: %s", _dataList.getString("hpMax")));
            holder.getServStarAbs().setText(String.format("Star abs: %s", _dataList.getString("starAbsorb")));
            holder.getServStarGen().setText(String.format("Star gen: %s%%", _dataList.getString("starGen")));
            //holder.getServNPG().setText(String.format("Atk min: %s", _servantData.getJSONArray("noblePhantasms").get));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public DetailledAdapter(JSONObject dataList) {
        _dataList = dataList;
    }
}
