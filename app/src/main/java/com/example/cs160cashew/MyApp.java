package com.example.cs160cashew;

import android.app.Application;

import java.util.Timer;
import java.util.TimerTask;

public class MyApp extends Application {

    private LogoutListener listener;
    private Timer timer;
    //private int seconds_logout = 60000;
    private int seconds_logout = 600000;

    public void startUserSession() {
        cancelTimer();
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                listener.onSessionLogout();
            }
        }, seconds_logout);
    }

    private void cancelTimer() {
        if(timer != null) timer.cancel();
    }

    public void registerSessionListener(LogoutListener listener) {
        this.listener = listener;
    }

    public void onUserInteracted() {
        startUserSession();
    }
}
