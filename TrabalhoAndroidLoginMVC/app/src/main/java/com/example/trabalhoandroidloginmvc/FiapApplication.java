package com.example.trabalhoandroidloginmvc;

import android.app.Application;

/**
 * Created by thaisandrade on 12/06/15.
 */
public class FiapApplication extends Application {
    public static final String TAG = "FIAP_ROUPAS";
    private static FiapRequestManager requestManager;
    @Override
    public void onCreate() {
        super.onCreate();

        MyVolley.init(this);
        requestManager = new FiapRequestManager(this);
    }

    public static FiapRequestManager getRequestManager() {
        return requestManager;
    }
}
