package com.example.fgoressource.NA.Detailled.Passives;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import org.json.JSONArray;

public class PassivesViewModel extends ViewModel {

    private final MutableLiveData<JSONArray> _passives;

    public PassivesViewModel(JSONArray passiveslist) {
        _passives = new MutableLiveData<>();
        _passives.setValue(passiveslist);
    }

    public LiveData<JSONArray> getPassives() { return _passives; }
}
