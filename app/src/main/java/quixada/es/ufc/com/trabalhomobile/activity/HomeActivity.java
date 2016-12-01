package quixada.es.ufc.com.trabalhomobile.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import quixada.es.ufc.com.trabalhomobile.R;
import quixada.es.ufc.com.trabalhomobile.network.BuscarProblemasRunnable;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

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
            Intent intent = new Intent(this, ListagemActivity.class);
            startActivity(intent);
            BuscarProblemasRunnable problemasRunnable = new BuscarProblemasRunnable();
            Thread thread = new Thread(problemasRunnable);
            thread.start();
        }
        return super.onOptionsItemSelected(item);
    }

}
