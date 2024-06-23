package com.httt1.vietnamtravel.ui.view;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class FavoriteViewModel extends ViewModel {
    private final MutableLiveData<String> mText;

    public FavoriteViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is history fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}