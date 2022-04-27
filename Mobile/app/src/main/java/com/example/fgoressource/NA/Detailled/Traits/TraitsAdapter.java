package com.example.fgoressource.NA.Detailled.Traits;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fgoressource.NA.Detailled.DetailledViewHolder;
import com.example.fgoressource.R;

import org.apache.commons.lang3.StringUtils;
import org.json.JSONArray;
import org.json.JSONException;

public class TraitsAdapter extends RecyclerView.Adapter<TraitsViewHolder>{

    JSONArray _traitsList;

    @NonNull
    @Override
    public TraitsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.traits_view_holder, parent, false);
        return new TraitsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TraitsViewHolder holder, int position) {
        try {
            String _traits = _traitsList.getJSONObject(position).getString("name");
            switch (position){
                case 0:
                    holder.getTrait().setText(String.format("\u2022 %s", _traits.substring(6)));
                    break;
                case 1:
                    holder.getTrait().setText(String.format("\u2022 %s", _traits.substring(5)));
                    break;
                case 2:
                case 3:
                case 4:
                    holder.getTrait().setText(String.format("\u2022 %s", _traits.substring(9)));
                    break;
                default:
                    holder.getTrait().setText(String.format("\u2022 %s", StringUtils.capitalize(_traits.replaceAll("(\\p{Ll})(\\p{Lu})","$1 $2"))));
                    break;
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getItemCount() {
        return _traitsList.length();
    }

    public TraitsAdapter(JSONArray arrayList) {
        this._traitsList=arrayList;
    }
}
