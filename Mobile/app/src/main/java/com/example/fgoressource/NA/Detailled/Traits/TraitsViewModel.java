package com.example.fgoressource.NA.Detailled.Traits;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import org.json.JSONArray;

public class TraitsViewModel extends ViewModel {

    private final MutableLiveData<JSONArray> _traits;

    public TraitsViewModel(JSONArray traitslist) {
        _traits = new MutableLiveData<>();
        _traits.setValue(traitslist);
    }

    public LiveData<JSONArray> getTraits() { return _traits; }
}
