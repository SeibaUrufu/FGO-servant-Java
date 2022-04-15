package com.example.fgoressource.NA.MainView;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.fgoressource.NA.Repository.NARepository;

import org.json.JSONArray;

public class ServantViewModel extends AndroidViewModel {

    private final NARepository _repository;
    private final MutableLiveData<JSONArray> servMLD;

    public ServantViewModel(@NonNull Application application) {
        super(application);
        _repository = new NARepository();
        servMLD = new MutableLiveData<>();
        _repository.searchServants(servMLD);
    }

    public LiveData<JSONArray> getList() {return servMLD;}

}
