package com.example.fgoressource.NA.Detailled;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.fgoressource.NA.Repository.NARepository;

import org.json.JSONArray;
import org.json.JSONObject;

public class DetailledViewModel extends ViewModel {

    private final NARepository _repository;
    private final MutableLiveData<JSONObject> servMLD;

    public DetailledViewModel(String id) {
        _repository = new NARepository();
        servMLD = new MutableLiveData<>();
        _repository.searchServantData(id, servMLD);
    }

    public LiveData<JSONObject> getList() {return servMLD;}
}
