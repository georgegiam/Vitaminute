package com.example.vitaminute.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class HomeViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public HomeViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Founded in 2020 by George Giamouridis, tech freaks has come a long way from its " +
                "beginnings in Greece. When George Giamouridis first started out, his passion for" +
                "nutrition and physique drove him to do tons of research so that tech freaks can offer " +
                "you a completely nutrition information platform. We now serve customers all over the" +
                "world, and are thrilled that we're able to turn our passion into our own website.");
    }

    public LiveData<String> getText() {
        return mText;
    }
}