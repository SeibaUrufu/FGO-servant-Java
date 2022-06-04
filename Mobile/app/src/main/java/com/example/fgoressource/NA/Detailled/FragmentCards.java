package com.example.fgoressource.NA.Detailled;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.Gravity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fgoressource.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class FragmentCards extends Fragment {

    private final JSONArray _cardsList;
    private final JSONObject _hitList;

    public FragmentCards(JSONArray cards, JSONObject hitList) {
        super(R.layout.fragment_cards);
        _cardsList = cards;
        _hitList = hitList;
    }

    @Override
    public void onViewCreated(@NonNull View container, Bundle savedInstanceState) {

        TextView cardView1 = (TextView) container.findViewById(R.id.card1);
        TextView cardView2 = (TextView) container.findViewById(R.id.card2);
        TextView cardView3 = (TextView) container.findViewById(R.id.card3);
        TextView cardView4 = (TextView) container.findViewById(R.id.card4);
        TextView cardView5 = (TextView) container.findViewById(R.id.card5);
        TextView cardViewExtras = (TextView) container.findViewById(R.id.cardExtra);

        try {
            setCardsColor(cardView1, _hitList, 0);
            setCardsColor(cardView2, _hitList, 1);
            setCardsColor(cardView3, _hitList, 2);
            setCardsColor(cardView4, _hitList, 3);
            setCardsColor(cardView5, _hitList, 4);
            setCardsColor(cardViewExtras, _hitList, 5);
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    public void setCardsColor(TextView card, JSONObject hitDistribution, int position) throws JSONException {
        if(position == 5) {
            card.setBackgroundResource(R.drawable.extra);
            card.setText(String.format("Number of hit:\n %s", hitDistribution.getJSONArray("extra").length()));
            card.setTextColor(Color.parseColor("#000000"));
            card.setGravity(Gravity.CENTER);
            card.setTypeface(null, Typeface.BOLD);
            return;
        }
        switch(_cardsList.getString(position)) {
            case "buster":
                card.setBackgroundResource(R.drawable.buster);
                card.setText(String.format("Number of hit:\n %s", hitDistribution.getJSONArray("buster").length()));
                card.setTextColor(Color.parseColor("#000000"));
                card.setGravity(Gravity.CENTER);
                card.setTypeface(null, Typeface.BOLD);
                break;
            case "quick":
                card.setBackgroundResource(R.drawable.quick);
                card.setText(String.format("Number of hit:\n %s", hitDistribution.getJSONArray("quick").length()));
                card.setTextColor(Color.parseColor("#000000"));
                card.setGravity(Gravity.CENTER);
                card.setTypeface(null, Typeface.BOLD);
                break;
            case "arts":
                card.setBackgroundResource(R.drawable.arts);
                card.setText(String.format("Number of hit:\n %s", hitDistribution.getJSONArray("arts").length()));
                card.setTextColor(Color.parseColor("#000000"));
                card.setGravity(Gravity.CENTER);
                card.setTypeface(null, Typeface.BOLD);
                break;
            default:
                Toast.makeText(getActivity(), "Error cards loading", Toast.LENGTH_SHORT).show();
        }
    }
}