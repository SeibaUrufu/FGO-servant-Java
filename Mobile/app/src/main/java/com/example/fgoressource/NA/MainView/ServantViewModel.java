package com.example.fgoressource.NA.MainView;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.fgoressource.NA.Repository.NARepository;

import org.json.JSONArray;

public class ServantViewModel extends AndroidViewModel {

    private final MutableLiveData<JSONArray> servMLD;

    public ServantViewModel(@NonNull Application application) {
        super(application);
        NARepository _repository = new NARepository();
        servMLD = new MutableLiveData<>();
        _repository.searchServants(servMLD); //We call the function searchServants from the repository., it will fill the LiveData with small info on all the servant
    }

    public LiveData<JSONArray> getList() {return servMLD;} //Will return to the activity a JSONArray with all the servant in it

}
