package com.example.fgoressource.NA.Detailled.Passives;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fgoressource.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PassivesAdapter extends RecyclerView.Adapter<PassivesViewHolder> {

    JSONArray _passivesList;

    @NonNull
    @Override
    public PassivesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.passives_view_holder, parent, false);
        return new PassivesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PassivesViewHolder holder, int position) {
        try {
            String _passiveName = _passivesList.getJSONObject(position).getString("name");
            String _passivesDescription = _passivesList.getJSONObject(position).getString("detail");
            holder.getPassiveName().setText(_passiveName);
            holder.getPassive().setText(String.format("\u2022 %s", _passivesDescription));
            effectFormat(_passivesList.getJSONObject(position).getJSONArray("functions").length(),_passivesList.getJSONObject(position),holder);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getItemCount() {
        return _passivesList.length();
    }

    public PassivesAdapter(JSONArray passives) {this._passivesList = passives;}

    public void effectFormat(int size, JSONObject list, PassivesViewHolder holder) {
        try {
            if(1 == size) {
                //Log.d("Passive1", String.valueOf(list.getJSONArray("functions")));
                holder.getPassiveValue().setText(String.format(" %s", formatValue(list.getJSONArray("functions").getJSONObject(0))));
            } else if(2 == size) {
                holder.getPassiveValue().setText(String.format(" %s and %s", formatValue(list.getJSONArray("functions").getJSONObject(0)), formatValue(list.getJSONArray("functions").getJSONObject(1))));
            } else if(3 <= size) {
                holder.getPassiveValue().setText(String.format(" %s, %s and %s", formatValue(list.getJSONArray("functions").getJSONObject(0)), formatValue(list.getJSONArray("functions").getJSONObject(1)), formatValue(list.getJSONArray("functions").getJSONObject(2))));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public String formatValue(JSONObject json) {
        String result = "";
        try {
            /*Log.d("Passive", String.valueOf(json));
            if(json.getString("funcPopupText").matches("(?i)(.*)Immune|Nega-Saver(.*)")) {
                result = "Infinite";
                return result;
            } else if (json.getString("funcPopupText").matches("(?i)(.*)None(.*)")) {
                result = "No effect";
                return result;
            } else if (json.getString("funcPopupText").matches("(?i)(.*)Bonus Effect(.*)")) {
                result = String.format("%s%%", json.getJSONArray("svals").getJSONObject(0).getInt("UseRate")/10);
                return result;
            } else if (json.getString("funcPopupText").matches("(?i)(.*)Down|(.*)Up|(.*)Resist|(.*)Corroding|(.*)NP Gain(.*)")) {
                result = String.format("%s%%", json.getJSONArray("svals").getJSONObject(0).getInt("Value")/10);
                return result;
            } else if (json.getString("funcPopupText").matches("(?i)(.*)Debuff(.*)")) {
                result = String.format("%s%%", json.getJSONArray("svals").getJSONObject(0).getInt("Value")/10);
                return result;
            } else {
                result = String.valueOf(json.getJSONArray("svals").getJSONObject(0).getInt("Value"));
                return result;
            }*/
            String type = json.getString("funcPopupText");

            Pattern _percentage = Pattern.compile("(?i)(.*)Down|(.*)Up|(.*)Resist|(.*)Corroding|(.*)NP Gain|(.*)C\\. Star\nDrop Rate|(.*)Critical(.*)");
            Pattern _avenger = Pattern.compile("(?i)NP Gain\nPer Turn");
            Pattern _alwaysOn = Pattern.compile("(?i)(.*)Immune|Nega-Saver(.*)");
            Pattern _bonus = Pattern.compile("(?i)(.*)Bonus Effect(.*)");
            Pattern _none = Pattern.compile("(?i)(.*)None(.*)");

            Matcher _percentageM = _percentage.matcher(type);
            Matcher _avengerM = _avenger.matcher(type);
            Matcher _alwaysOnM = _alwaysOn.matcher(type);
            Matcher _bonusM = _bonus.matcher(type);
            Matcher _noneM = _none.matcher(type);

            if(_alwaysOnM.lookingAt()||type.isEmpty()) {
                result = "Infinite";
                return result;
            } else if(_noneM.lookingAt()) {
                result = "No effect";
                return result;
            } else if(_bonusM.lookingAt()) {
                result = String.format("%s%%", json.getJSONArray("svals").getJSONObject(0).getDouble("UseRate") / 10);
                return result;
            } else if(_avengerM.lookingAt()) {
                result = String.format("%s%%", json.getJSONArray("svals").getJSONObject(0).getDouble("Value") / 100);
                return result;
            } else if(_percentageM.lookingAt()) {
                Log.d("PassiveTarget3", String.valueOf(json));
                Log.d("PassiveTarget", json.getString("funcTargetTeam")+ " is enemy ? " +String.valueOf(json.getString("funcTargetTeam")=="enemy"));
                if(json.getString("funcTargetTeam").equals("enemy")) {
                    Log.d("PassiveTarget2", "As enemy");
                    result = String.format("%s%% (Enemy)", json.getJSONArray("svals").getJSONObject(0).getDouble("Value")/10);
                    return result;
                }
                result = String.format("%s%%", json.getJSONArray("svals").getJSONObject(0).getDouble("Value")/10);
                return result;
            } else {
                result = String.valueOf(json.getJSONArray("svals").getJSONObject(0).getInt("Value"));
                return result;
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return result;
    }
}
