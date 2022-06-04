package com.example.fgoressource.NA.MainView;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fgoressource.R;

public class ServantViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    private final IServant clickListener;
    private final TextView servName;
    private final TextView servID;
    private final ImageView servFace;

    public ServantViewHolder(@NonNull View itemView, IServant clickListener) {
        super(itemView);
        servName = itemView.findViewById(R.id.servantName);
        servID = itemView.findViewById(R.id.servantID);
        servFace = itemView.findViewById(R.id.servantSprite);
        itemView.setOnClickListener(this);
        this.clickListener=clickListener;
    }

    public TextView getName() {
        return servName;
    }

    public TextView getID(){return servID;}

    public ImageView getFace() {
        return servFace;
    }

    @Override
    public void onClick(View view) {
        if ( clickListener != null ) {
            clickListener.onClick(this, getAdapterPosition());
        }
    }

}
