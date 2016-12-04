package quixada.es.ufc.com.trabalhomobile.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import quixada.es.ufc.com.trabalhomobile.dao.ProblemaDAO;
import quixada.es.ufc.com.trabalhomobile.R;
import quixada.es.ufc.com.trabalhomobile.model.Problema;

public class CadastroActivity extends AppCompatActivity {
    TextView vNome;
    TextView vDescricao;
    Problema p;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
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

    public void onClickCancelar(View view) {
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
    }
    public void onClickCadastrar(View view) {
        vNome = (TextView) findViewById(R.id.nome_problema);
        vDescricao = (TextView) findViewById(R.id.descricao_problema);
        p = new Problema();
        ProblemaDAO dao = new ProblemaDAO(this);
        p.setNome(vNome.getText().toString());
        p.setDescricao(vDescricao.getText().toString());

        if (((RadioButton) findViewById(R.id.tipo_eletrico)).isChecked()){
            p.setTipo("Eletrico");
        }
        if (((RadioButton) findViewById(R.id.tipo_encanamento)).isChecked()){
            p.setTipo("Encanamento");
        }

        dao.inserir(p);

        Context context = getApplicationContext();
        String text = "Cadastrado com sucesso!";
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();

        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
    }
}
