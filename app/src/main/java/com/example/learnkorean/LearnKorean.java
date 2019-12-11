package com.example.learnkorean;

import android.app.Application;
import android.content.Context;

public class LearnKorean extends Application {
    /** Current instance. */
    private static LearnKorean instance;
    public void onCreate() {
        super.onCreate();
        instance = this;
    }

    /**
     * Gets the context.
     * @return context
     */
    public static Context getContext() {
        return instance.getApplicationContext();
    }
}
