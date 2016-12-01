package quixada.es.ufc.com.trabalhomobile.network;

import android.os.Message;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

//Requisição HTTP
public class BuscarProblemasRunnable implements Runnable {

    private static final String TAG = "AndroidJSON";
    HandlerJSON handler;

    @Override
    public void run() {
        HttpURLConnection urlConnection = null;
        BufferedReader in = null;

        try {
            //Tratar toda a parte da requisição http
            //Aqui vocês precisam passar os parametros necessários
            URL url = new URL( "http://200.129.39.162:9000/problemas" );

            //Vocês nem precisam alterar esse código até o final da requisição http
            urlConnection = (HttpURLConnection) url.openConnection();

            urlConnection.setDoOutput(true);

            in = new BufferedReader(new InputStreamReader(
                    urlConnection.getInputStream()));

            String response = "";

            String inputLine;
            while ((inputLine = in.readLine()) != null)
                response += inputLine;

            //Final da requisição http

            //Passando a resposta http para o Handler
            //Vocês não precisam alterar esse código
            Message msg = handler.obtainMessage();
            msg.obj = response;
            handler.sendMessage(msg);

            //populateAgenda( response );

        } catch ( MalformedURLException ex ){
            Log.e( TAG, ex.getMessage() );
            Log.e( TAG, ex.toString() );
        } catch ( IOException ex ){
            Log.e( TAG, ex.getMessage() );
            Log.e( TAG, ex.toString() );
        } finally {

            urlConnection.disconnect();
            try {
                in.close();
            } catch ( IOException ex ) {
                Log.e( TAG, ex.getMessage() );
                Log.e( TAG, ex.toString() );
            }

        }

    }
}
