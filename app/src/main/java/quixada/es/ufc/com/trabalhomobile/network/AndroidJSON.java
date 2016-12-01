package quixada.es.ufc.com.trabalhomobile.network;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;
import quixada.es.ufc.com.trabalhomobile.model.Problema;


public class AndroidJSON {

    //BuscarProblemasRunnable problemasRunnable;
    private static final String TAG = "AndroidJSON";
    private List<Problema> problemas;

    public void populateListProblemas(String mensagemRecebida){
        Log.d( TAG, mensagemRecebida );
        Gson gson = new Gson();
        Type collectionType = new TypeToken<List<Problema>>(){}.getType();
        problemas = gson.fromJson(mensagemRecebida,collectionType);
    }

    public List<Problema> getProblemas(){
        return this.problemas;
    }
}
