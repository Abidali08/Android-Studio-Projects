package com.example.notificationapp;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private static final String Channel_ID = "Abid Ali";
    private static final int notification_id = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        Drawable drawable = ResourcesCompat.getDrawable(getResources(),R.drawable.baseline_notifications_24,null);
        BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;

         Bitmap icon = bitmapDrawable.getBitmap();
        Notification notification;
        NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
             notification = new Notification.Builder(this)
                    .setLargeIcon(icon)
                    .setSmallIcon(R.drawable.baseline_notifications_24)
                    .setContentText("My Notification")
                    .setSubText("Kya ho rha hai")
                    .setChannelId(Channel_ID)
                    .build();
             nm.createNotificationChannel(new NotificationChannel(Channel_ID,"Hello",NotificationManager.IMPORTANCE_HIGH));
        }
//        else
//        {
//            notification = new Notification.Builder(this)
//                    .setLargeIcon(icon)
//                    .setSmallIcon(R.drawable.baseline_notifications_24)
//                    .setContentText("My Notification")
//                    .setSubText("Kya ho rha hai")
//                    .build();
//        }
//        nm.notify(notification_id,notification);
    }
}