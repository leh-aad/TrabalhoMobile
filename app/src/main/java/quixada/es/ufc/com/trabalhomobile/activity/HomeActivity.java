package quixada.es.ufc.com.trabalhomobile.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import quixada.es.ufc.com.trabalhomobile.R;
import quixada.es.ufc.com.trabalhomobile.model.Problema;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        handler = new HandlerJSON( this );
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater  = getMenuInflater();
        getMenuInflater().inflate(R.menu.menu_home, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_logout) {
            Intent intent = new Intent(this,LoginActivity.class);
            startActivity(intent);
            return true;
        }
        if(id == R.id.action_cadastrar ){
            Intent intent = new Intent(this, CadastroActivity.class);
            startActivity(intent);
        }
        if(id == R.id.action_listar){
            problemaRunnable = new BuscarProblemaHttpRunnable();
            Thread thread = new Thread(problemaRunnable);
            thread.start();
            Intent intent = new Intent(this, ListagemActivity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
//---------------------- Conexao -----------------------
    private BuscarProblemaHttpRunnable problemaRunnable;
    private static final String TAG = "AndroidJSON";
    private static final String URL = "http://192.168.1.8:9000/problemas";
    private HandlerJSON handler;
    static List<Problema> problemas;
    class HandlerJSON  extends Handler {

        HomeActivity activity;

        //Na sua aplicação, alterar essa classe HandlerJSON para tratar a resposta do servidor web
        public HandlerJSON( HomeActivity activity ){
            this.activity = activity;
        }

        public void handleMessage( Message msg ) {
            String mensagemRecebida = ( String )msg.obj;
            populateListProblemas( mensagemRecebida );

        }
    }

    public void populateListProblemas(String mensagemRecebida){

        Log.d( TAG, mensagemRecebida );
        //mensagemRecebida = "[{\"nome\":\"pro1\",\"descricao\":null,\"tipo\":null,\"id\":1,\"status\":\"em andamento\"},{\"nome\":\"pro2\",\"descricao\":null,\"tipo\":null,\"id\":2,\"status\":\"resolvido\"}]";
        Gson gson = new Gson();
        Type collectionType = new TypeToken<List<Problema>>(){}.getType();
        problemas = gson.fromJson(mensagemRecebida,collectionType);
    }

    //Thread que faz a requisição via http
    class BuscarProblemaHttpRunnable implements Runnable {

        public void run(){

            HttpURLConnection urlConnection = null;
            BufferedReader in = null;

            try {

                //Tratar toda a parte da requisição http
                //Aqui vocês precisam passar os parametros necessários
                URL url = new URL(URL);

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



}
