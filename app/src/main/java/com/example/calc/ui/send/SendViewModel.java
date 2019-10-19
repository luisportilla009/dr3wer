package com.example.calc.ui.send;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SendViewModel extends ViewModel {

    private MutableLiveData<String> mText, version;

    public SendViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Created by: Luis David Portilla Barco");
        version = new MutableLiveData<>();
        version.setValue(("Version 1.1.0"));
    }

    public LiveData<String> getText() {
        return mText;
    }
}