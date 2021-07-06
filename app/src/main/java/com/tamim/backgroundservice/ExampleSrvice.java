package com.tamim.backgroundservice;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import androidx.core.app.NotificationCompat;

import static com.tamim.backgroundservice.App.Chennel_ID;

public class ExampleSrvice extends Service {
    public ExampleSrvice() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        String input = intent.getStringExtra("inputExtra");

        Intent notificationintent = new Intent(this, MainActivity.class);

        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, notificationintent, 0);

        Notification notification = new NotificationCompat.Builder(this, Chennel_ID)
                .setContentTitle("Example Service")
                .setContentText(input).setSmallIcon(R.drawable.ic_notification)
                .setContentIntent(pendingIntent).build();

        startForeground(1,notification);


        return  START_NOT_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}