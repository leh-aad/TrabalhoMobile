package quixada.es.ufc.com.trabalhomobile.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by Leh on 11/11/2016.
 */

public class NotificationServiceReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i("SCRIPT","STOP_SERVICE");
        context.startService(new Intent(context,NotificationService.class));
    }
}
