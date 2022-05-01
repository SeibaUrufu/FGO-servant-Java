package com.example.fgoressource.NA.Detailled.Passives;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.fgoressource.R;

public class PassivesViewHolder extends RecyclerView.ViewHolder {

    private  final TextView _passiveName;
    private final TextView _passivesDescription;
    private final TextView _passiveValue;
    private final ImageView _icon;

    public PassivesViewHolder(View view) {
        super(view);
        _passiveName =(TextView) view.findViewById(R.id.passiveName);
        _passivesDescription = (TextView) view.findViewById(R.id.passiveDescription);
        _passiveValue = (TextView) view.findViewById(R.id.passiveValue);
        _icon = (ImageView) view.findViewById(R.id.passiveIcon);
    }

    public ImageView getPassiveIcon() {return _icon;}

    public TextView getPassive() {return _passivesDescription;}

    public TextView getPassiveValue() {return _passiveValue;}

    public TextView getPassiveName() {return _passiveName;}

}
