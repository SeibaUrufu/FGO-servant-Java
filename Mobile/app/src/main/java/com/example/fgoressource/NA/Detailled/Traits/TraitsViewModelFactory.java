package com.example.fgoressource.NA.Detailled.Traits;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import org.json.JSONArray;

public class TraitsViewModelFactory implements ViewModelProvider.Factory{

    private JSONArray _traitslist;

    public TraitsViewModelFactory(JSONArray traitslist) {_traitslist = traitslist;}

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new TraitsViewModel(_traitslist);
    }
}
