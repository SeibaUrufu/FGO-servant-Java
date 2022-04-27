package com.example.fgoressource.NA.Detailled.Traits;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fgoressource.R;

public class TraitsViewHolder extends RecyclerView.ViewHolder{

    private final TextView traitTV;

    public TraitsViewHolder(@NonNull View itemView) {
        super(itemView);
        traitTV = itemView.findViewById(R.id.traitValue);
    }

    public TextView getTrait() {return traitTV;}
}
