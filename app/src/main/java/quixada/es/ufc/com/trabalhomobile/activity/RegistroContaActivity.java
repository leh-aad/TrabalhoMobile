package quixada.es.ufc.com.trabalhomobile.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import quixada.es.ufc.com.trabalhomobile.dao.UsuarioDAO;
import quixada.es.ufc.com.trabalhomobile.R;
import quixada.es.ufc.com.trabalhomobile.model.Usuario;

public class RegistroContaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_conta);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

    }

    public void onClick(View view){
        EditText vEmail = (EditText) findViewById(R.id.email_registro);
        EditText vSenha = (EditText) findViewById(R.id.senha_registro);

        Usuario u = new Usuario();
        UsuarioDAO dao  = new UsuarioDAO();

        u.setEmail(vEmail.getText().toString());
        u.setSenha(vSenha.getText().toString());

        if (((RadioButton) findViewById(R.id.radio_ele)).isChecked()){
            u.setTipo("Eletricista");
        }
        if (((RadioButton) findViewById(R.id.radio_enc)).isChecked()){
            u.setTipo("Encanador");
        }

        dao.adicionar(u);

        Context context = getApplicationContext();
        String text = "Cadastrado com sucesso!";
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();

        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
     }

}
