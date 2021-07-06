package com.tamim.backgroundservice;

import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;

public class App extends Application {

    public static final String Chennel_ID = "exampleServiceChannel";

    @Override
    public void onCreate() {
        super.onCreate();

        createChannelNotification();
    }

    private void createChannelNotification() {
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            NotificationChannel notificationChannel = new NotificationChannel(Chennel_ID, "Example Service Channel ",
                    NotificationManager.IMPORTANCE_DEFAULT

            );

            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(notificationChannel);
        }
    }
}
