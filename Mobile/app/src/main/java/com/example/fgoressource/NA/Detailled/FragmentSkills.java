package com.example.fgoressource.NA.Detailled;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.fgoressource.R;

import org.json.JSONArray;

public class FragmentSkills extends Fragment {

    private JSONArray _skills;

    public FragmentSkills(JSONArray skills) {
        super(R.layout.fragment_skills);
        this._skills=skills;
    }

    @Override
    public void onViewCreated(@NonNull View container, Bundle savedInstanceState) {

    }
}