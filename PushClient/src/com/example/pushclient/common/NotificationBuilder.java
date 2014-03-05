package com.example.pushclient.common;

import com.example.pushclient.MainActivity;
import com.example.pushclient.R;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.TaskStackBuilder;

public class NotificationBuilder {
	private final static String TAG="NotificationManager";
	private Context mContext;
    private NotificationManager mNotificationManager;
    private boolean isNeedSound;
    private boolean  isNeedVibrabe;
    public NotificationBuilder(Context context){
    	this.mContext=context;
    }
    public void showDefaultNotification(String title,String message){
      NotificationCompat.Builder mBuilder=
    		  new NotificationCompat.Builder(mContext)
              .setSmallIcon(R.drawable.ic_launcher)
              .setContentTitle(title)
              .setContentText(message);
      Intent resIntent=new Intent();
      TaskStackBuilder stackBuilder=TaskStackBuilder.create(mContext);
      stackBuilder.addParentStack(MainActivity.class);
      stackBuilder.addNextIntent(resIntent);
      PendingIntent resultPendingIntent=stackBuilder.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);
      mBuilder.setContentIntent(resultPendingIntent);
      if(mNotificationManager==null){
    	  mNotificationManager=(NotificationManager) mContext.getSystemService(Context.NOTIFICATION_SERVICE);
      }
      Notification notification=mBuilder.build();
      notification.flags=Notification.FLAG_AUTO_CANCEL;
      notification.defaults=Notification.DEFAULT_ALL;  
      // audioStreamType的值必须AudioManager中的值，代表着响铃的模式  
      notification.audioStreamType= android.media.AudioManager.ADJUST_LOWER;
      long[] vibrate={0,100,200,300};
      notification.vibrate=vibrate;
      notification.ledARGB=0xFF00FF00;
      notification.ledOnMS=300;
      notification.ledOffMS=1000;
      notification.flags=Notification.FLAG_SHOW_LIGHTS;
       mNotificationManager.notify(0, notification);
    }
}
