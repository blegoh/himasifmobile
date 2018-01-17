package id.ilkom.himasif.himasifmobile;


import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

/**
 * Created by eldi on 16/01/2018.
 */

public class HimasifNotification extends FirebaseMessagingService {
    private static final String TAG ="myFirebaseServices";

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        Log.d(TAG,"From: "+remoteMessage.getFrom());

        if (remoteMessage.getData().size()>0){
            Log.d(TAG,"Message data: "+remoteMessage.getData());
        }

        if (remoteMessage.getNotification()!=null){
            Log.d(TAG,"Message body: "+remoteMessage.getNotification().getBody());
            sendNotification(remoteMessage.getNotification().getBody());
        }
    }

    private void sendNotification(String body) {
        Intent intent = new Intent(this,MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        PendingIntent pendingIntent = PendingIntent.getActivity(this,0,intent,PendingIntent.FLAG_ONE_SHOT);
        Uri notifSound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);

        NotificationCompat.Builder notifBuilder = new NotificationCompat.Builder(this)
                .setSmallIcon(R.mipmap.icon_himasif)
                .setContentTitle("Info HIMASIF")
                .setContentText(body)
                .setAutoCancel(true)
                .setSound(notifSound)
                .setContentIntent(pendingIntent);
        // .setContentTitle("Info HIMASIF")

        NotificationManager notificationManager = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(0,notifBuilder.build());
    }
}
