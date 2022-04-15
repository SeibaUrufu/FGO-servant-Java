package com.example.fgoressource.NA.Detailled;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.view.menu.MenuView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fgoressource.R;

public class DetailledViewHolder extends RecyclerView.ViewHolder {

    private final TextView servantName;
    private final TextView servAtkMin;
    private final TextView servAtkMax;
    private final TextView servHPMin;
    private final TextView servHPMax;
    private final TextView servStarA;
    private final TextView servStarG;
    private final TextView servNPD;
    private final TextView servNPG;
    private final TextView servAttribut;
    private final TextView servAlignement;
    private final TextView servDeathRate;
    private ImageView servGraph;

    public DetailledViewHolder(@NonNull View itemView) {
        super(itemView);
        servantName = (TextView) itemView.findViewById(R.id.servName);
        servAtkMin = (TextView) itemView.findViewById(R.id.atkMin);
        servAtkMax = (TextView) itemView.findViewById(R.id.atkMax);
        servHPMin = (TextView) itemView.findViewById(R.id.hpMin);
        servHPMax = (TextView) itemView.findViewById(R.id.hpMax);
        servStarA = (TextView) itemView.findViewById(R.id.starAbs);
        servStarG = (TextView) itemView.findViewById(R.id.starGen);
        servNPD = (TextView) itemView.findViewById(R.id.npDef);
        servNPG = (TextView) itemView.findViewById(R.id.npGen);
        servAttribut = (TextView) itemView.findViewById(R.id.attribut);
        servAlignement = (TextView) itemView.findViewById(R.id.alignement);
        servDeathRate = (TextView) itemView.findViewById(R.id.death);
        servGraph = (ImageView) itemView.findViewById(R.id.servantGraph);
    }

    public TextView getServantName() {return servantName;}

    public TextView getServAtkMin() {return servAtkMin;}

    public TextView getServAtkMax() {return servAtkMax;}

    public TextView getServHPMin() {return servHPMin;}

    public TextView getServHPMax() {return servHPMax;}

    public TextView getServStarAbs() {return servStarA;}

    public TextView getServStarGen() {return servStarG;}

    public TextView getServNPD() {return servNPD;}

    public TextView getServNPG() {return servNPG;}

    public TextView getServAttribut() {return servAttribut;}

    public TextView getServAli() {return servAlignement;}

    public TextView getServDeath() {return servDeathRate;}

    public ImageView getGraph() {return servGraph;}
}
