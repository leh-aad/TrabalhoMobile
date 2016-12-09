package quixada.es.ufc.com.trabalhomobile.network;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

import quixada.es.ufc.com.trabalhomobile.activity.HomeActivity;
import quixada.es.ufc.com.trabalhomobile.model.Problema;

/**
 * Created by Leh on 07/12/2016.
 */

public class HandlerJSON extends Handler {

    HomeActivity activity;
    public HandlerJSON(HomeActivity activity ){
        this.activity = activity;
    }

    public void handleMessage( Message msg ) {
        String mensagemRecebida = ( String )msg.obj;
        populateListProblemas( mensagemRecebida );

    }

    public void populateListProblemas(String mensagemRecebida){
        Log.d( "AndroidJSON", mensagemRecebida );
        Gson gson = new Gson();
        Type collectionType = new TypeToken<List<Problema>>(){}.getType();
        HomeActivity.problemas = gson.fromJson(mensagemRecebida,collectionType);
    }

}
