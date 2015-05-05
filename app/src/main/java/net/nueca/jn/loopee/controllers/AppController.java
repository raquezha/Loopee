package net.nueca.jn.loopee.controllers;


import android.app.Application;

public class AppController extends Application {

    @Override
    public void onCreate(){
        super.onCreate();

        // Request Manager initialization
        RequestManager.getInstance(getApplicationContext());
    }

}
