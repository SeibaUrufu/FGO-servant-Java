package com.example.fgoressource.NA.Detailled;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.View;

import com.example.fgoressource.NA.Detailled.Traits.*;
import com.example.fgoressource.R;

import org.json.JSONArray;


public class FragmentTraits extends Fragment {
    private JSONArray array = new JSONArray();

    public FragmentTraits(JSONArray traits) {
        super(R.layout.fragment_traits);
        array = traits;
        Log.d("TraitsList", String.valueOf(array));
    }

    @Override
    public void onViewCreated(@NonNull View container, Bundle savedInstanceState) {
        TraitsViewModel model = new ViewModelProvider(getActivity(), new TraitsViewModelFactory(array)).get(TraitsViewModel.class);
        model.getTraits().observe(getViewLifecycleOwner(), _traits -> {
            RecyclerView recycle =(RecyclerView) container.findViewById(R.id.recyclerTraits);
            LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
            TraitsAdapter _adapter = new TraitsAdapter(_traits);
            recycle.setLayoutManager(layoutManager);
            recycle.setAdapter(_adapter);
        });
    }

}