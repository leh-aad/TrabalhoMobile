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
import android.widget.TextView;

import quixada.es.ufc.com.trabalhomobile.dao.ProblemaDAO;
import quixada.es.ufc.com.trabalhomobile.R;
import quixada.es.ufc.com.trabalhomobile.model.Problema;

public class DetalhesActivity extends AppCompatActivity {
    Problema p;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent intent = getIntent();
        p = (Problema) intent.getSerializableExtra("obj");

        TextView nome= (TextView) findViewById(R.id.nome_item);
        TextView tipo = (TextView) findViewById(R.id.tipo_item);
        TextView descr = (TextView) findViewById(R.id.descricao_item);
        nome.setText(p.getNome());
        tipo.setText(p.getTipo());
        descr.setText(p.getDescricao());

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

    public void OnClickremove(View view){
        ProblemaDAO dao = new ProblemaDAO(this);
        dao.deletar(p);
        Intent intent = new Intent(this,LoginActivity.class);
        startActivity(intent);
    }

}
