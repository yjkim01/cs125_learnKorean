package com.example.learnkorean;

import android.app.Application;
import android.content.Context;

public class LearnKorean extends Application {
    private static LearnKorean instance;
    public void onCreate() {
        super.onCreate();
        instance = this;
    }
    public static Context getContext() {
        return instance.getApplicationContext();
    }
}
