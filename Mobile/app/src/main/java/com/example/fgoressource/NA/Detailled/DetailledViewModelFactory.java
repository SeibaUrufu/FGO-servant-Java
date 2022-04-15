package com.example.fgoressource.NA.Detailled;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

public class DetailledViewModelFactory implements ViewModelProvider.Factory {

    private String factID;

    public DetailledViewModelFactory(String id) {
        factID = id;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new DetailledViewModel(factID);
    }
}
