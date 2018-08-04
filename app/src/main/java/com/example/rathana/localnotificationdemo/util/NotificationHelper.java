package com.example.rathana.localnotificationdemo.util;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;

import com.example.rathana.localnotificationdemo.MainActivity;
import com.example.rathana.localnotificationdemo.NotificationDetailActivity;
import com.example.rathana.localnotificationdemo.R;

public class NotificationHelper {
    private Context context;

    public NotificationHelper(Context context) {
        this.context = context;
    }

    public void createChannel(String id,String name){
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){
            NotificationChannel channel=new NotificationChannel(
                    id,name, NotificationCompat.PRIORITY_DEFAULT
            );

            channel.setDescription("test");
            channel.setLightColor(Color.RED);
            channel.enableLights(true);

            NotificationManager manager= (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
            manager.createNotificationChannel(channel);
        }
    }


    public void createSimpleNotification(String title,String content){
        NotificationCompat.Builder builder =new NotificationCompat.Builder(context,context.getString(R.string.channel_id_1));
        builder.setContentTitle(title)
                .setContentText(content)
                .setSmallIcon(R.drawable.ka_1_new_edition_icon)
                .setContentInfo("message")
                .setNumber(9)
                .setLargeIcon(BitmapFactory.decodeResource(context.getResources(),R.drawable.ka_1_new_edition_icon));
        NotificationManagerCompat managerCompat=NotificationManagerCompat.from(context);
        int id= (int) (System.currentTimeMillis()/1000);
        managerCompat.notify(id,builder.build());

    }

    public void createBigTextStyleNotification(String title,String content){
        NotificationCompat.Builder builder =new NotificationCompat.Builder(context,context.getString(R.string.channel_id_1));
        NotificationCompat.BigTextStyle bigTextStyle=new NotificationCompat.BigTextStyle();
        bigTextStyle.bigText("By default, the notification's text content is truncated to fit one line. If you want your notification to be ");
        builder.setContentTitle(title)
                .setContentText(content)
                .setSmallIcon(R.drawable.ka_1_new_edition_icon)
                .setNumber(9)
                .setStyle(bigTextStyle)
                .setLargeIcon(BitmapFactory.decodeResource(context.getResources(),R.drawable.ka_1_new_edition_icon));
        NotificationManagerCompat managerCompat=NotificationManagerCompat.from(context);
        int id= (int) (System.currentTimeMillis()/1000);
        managerCompat.notify(id,builder.build());

    }

    public void createBigPictureStyleNotification(String title,String content){
        NotificationCompat.Builder builder =new NotificationCompat.Builder(context,context.getString(R.string.channel_id_1));
        NotificationCompat.BigPictureStyle bigPictureStyle=new NotificationCompat.BigPictureStyle();
        bigPictureStyle.bigPicture(BitmapFactory.decodeResource(context.getResources(),R.drawable.landscape));


        //penddingIntent
        //Intent intent =new Intent(Intent.ACTION_VIEW, Uri.parse("https://developer.android.com"));
        Intent intent =new Intent(context, NotificationDetailActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        PendingIntent pendingIntent=PendingIntent.getActivity(context,0,intent,PendingIntent.FLAG_CANCEL_CURRENT);

        builder.setContentTitle(title)
                .setContentText(content)
                .setSmallIcon(R.drawable.ka_1_new_edition_icon)
                .setNumber(9)
                .setStyle(bigPictureStyle)
                .setContentIntent(pendingIntent)
                .setAutoCancel(true)
                .setLargeIcon(BitmapFactory.decodeResource(context.getResources(),R.drawable.ka_1_new_edition_icon));
        NotificationManagerCompat managerCompat=NotificationManagerCompat.from(context);
        int id= (int) (System.currentTimeMillis()/1000);
        managerCompat.notify(id,builder.build());

    }

}
