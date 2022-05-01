package com.example.fgoressource.NA.Detailled;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.fgoressource.NA.Detailled.Passives.PassivesAdapter;
import com.example.fgoressource.NA.Detailled.Passives.PassivesViewModel;
import com.example.fgoressource.NA.Detailled.Passives.PassivesViewModelFactory;
import com.example.fgoressource.R;

import org.json.JSONArray;

public class FragmentPassive extends Fragment {

    private JSONArray array = new JSONArray();

    public FragmentPassive(JSONArray passivesList) {
        super(R.layout.fragment_passive);
        array = passivesList;
    }

    @Override
    public void onViewCreated(@NonNull View container, Bundle savedInstanceState) {
        PassivesViewModel model = new ViewModelProvider(getActivity(),new PassivesViewModelFactory(array)).get(PassivesViewModel.class);

        model.getPassives().observe(getViewLifecycleOwner(), _passives -> {
           RecyclerView recycle = (RecyclerView) container.findViewById(R.id.recyclerPassive);
           LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
            PassivesAdapter _adapter = new PassivesAdapter(_passives);
            recycle.setAdapter(_adapter);
            recycle.setLayoutManager(layoutManager);
        });
    }
}