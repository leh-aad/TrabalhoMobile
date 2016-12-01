package quixada.es.ufc.com.trabalhomobile.network;

import android.app.Activity;
import android.os.Handler;
import android.os.Message;

import java.util.logging.LogRecord;

/**
 * Created by Leh on 01/12/2016.
 */

public class HandlerJSON extends Handler {
    AndroidJSON androidJSON;
    BuscarProblemasRunnable problemasRunnable;

    //Na sua aplicação, alterar essa classe HandlerJSON para tratar a resposta do servidor web

    public HandlerJSON( AndroidJSON activity ){
        this.androidJSON = activity;
    }

    @Override
    public void handleMessage( Message msg ) {
        String mensagemRecebida = ( String )msg.obj;
        androidJSON.populateListProblemas(mensagemRecebida);

    }
}
