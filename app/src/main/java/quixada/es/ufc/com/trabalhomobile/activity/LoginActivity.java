package quixada.es.ufc.com.trabalhomobile.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import quixada.es.ufc.com.trabalhomobile.R;
import quixada.es.ufc.com.trabalhomobile.service.NotificationService;

public class LoginActivity extends AppCompatActivity {

    private EditText mEmailView;
    private EditText mPasswordView;
    private static final String[] credenciais = new String[]{
            "adm:123"
    };
    static boolean session = false;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    private boolean attempLogin() {
        mEmailView = (EditText) findViewById(R.id.email);
        mPasswordView = (EditText) findViewById(R.id.password);

        String email = mEmailView.getText().toString();
        String password = mPasswordView.getText().toString();

        for (String credencial : credenciais) {
            String[] parte = credencial.split(":");
            if (parte[0].equals(email)) {
                return parte[1].equals(password);
            }
        }

        return false;
    }

    public void onClick(View view) {
        if (attempLogin()) {
            Intent intent = new Intent(this, HomeActivity.class);
            session = true;
            startService(new Intent(this, NotificationService.class));
            startActivity(intent);
        } else {
            Context context = getApplicationContext();
            String text = "Error";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }
    }
    public void onClickRegistrarConta(View view){
        Intent intent = new Intent(this, RegistroContaActivity.class);
        startActivity(intent);
    }
}
