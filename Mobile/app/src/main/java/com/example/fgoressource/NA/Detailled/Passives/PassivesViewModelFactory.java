package com.example.fgoressource.NA.Detailled.Passives;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import org.json.JSONArray;

public class PassivesViewModelFactory implements ViewModelProvider.Factory {

    private JSONArray _passiveslist;

    public PassivesViewModelFactory(JSONArray passiveslist) {_passiveslist = passiveslist;}

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new PassivesViewModel(_passiveslist);
    }
}
