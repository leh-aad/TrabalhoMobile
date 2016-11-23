package quixada.es.ufc.com.trabalhomobile.service;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v4.content.WakefulBroadcastReceiver;
import android.util.Log;

import static android.content.Intent.*;


public class NotificationService extends Service{

    private Worker w = new Worker();
    @Override
    public void onCreate(){
        super.onCreate();
    }

    class Worker extends Thread{
        @Override
        public void run(){
            Log.i("SCRIPT","START_SERVICE");
            notificar();
        }
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int starId){
        w.start();
        return super.onStartCommand(intent, flags,starId);
    }

    public void onDestroy(){
        w.interrupt();
        Intent intent = new Intent();
        intent.putExtra("Status","STOP_SERVICE");
        sendBroadcast(intent);
    }

    public void notificar(){
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("NOTIFICACAO");

        Intent intent = new Intent(ACTION_VIEW, Uri.parse(""));
        PendingIntent pendingIntent;
        pendingIntent = PendingIntent.getActivity(getBaseContext(),0,intent, Intent.FLAG_ACTIVITY_NEW_TASK);
        Context context = getApplicationContext();

        Notification.Builder builder;
        builder = new Notification.Builder(context)
                .setContentTitle("Bem vindo")
                .setContentText("Você esta logado")
                .setContentIntent(pendingIntent)
                .setDefaults(Notification.DEFAULT_SOUND)
                .setAutoCancel(true)
                .setSmallIcon(android.support.design.R.drawable.notification_template_icon_bg);

        Notification notification =builder.build();
        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(1,notification);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
