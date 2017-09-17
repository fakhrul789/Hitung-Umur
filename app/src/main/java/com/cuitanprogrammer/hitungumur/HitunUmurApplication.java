package com.cuitanprogrammer.hitungumur;

import android.app.Application;
import android.content.Context;

/**
 * Created by islam on 16/09/17.
 */

public class HitunUmurApplication extends Application {
    private static Context context;

    public static Context getContext() {
        return context;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
    }
}
