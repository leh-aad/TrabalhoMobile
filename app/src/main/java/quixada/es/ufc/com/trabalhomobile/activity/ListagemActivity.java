package quixada.es.ufc.com.trabalhomobile.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.List;

import quixada.es.ufc.com.trabalhomobile.dao.ProblemaDAO;
import quixada.es.ufc.com.trabalhomobile.R;
import quixada.es.ufc.com.trabalhomobile.adapter.ListaProblemasAdpter;
import quixada.es.ufc.com.trabalhomobile.model.Problema;

public class ListagemActivity extends AppCompatActivity {

    ListaProblemasAdpter adpter;
    List<Problema> problemas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listagem);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        problemas = HomeActivity.problemas;
        final ListView lista = (ListView) findViewById(R.id.lista_pro);
        adpter = new ListaProblemasAdpter(getApplicationContext(),problemas);
        lista.setAdapter(adpter);
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(view.getContext(), DetalhesActivity.class);
                Problema p = problemas.get(position);
                intent.putExtra("obj", p);
                startActivity(intent);
            }
        });



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater  = getMenuInflater();
        getMenuInflater().inflate(R.menu.menu_geral, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
            case R.id.action_logout:
                Intent intent = new Intent(this,LoginActivity.class);
                startActivity(intent);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }


}
