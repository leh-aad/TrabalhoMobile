package quixada.es.ufc.com.trabalhomobile.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import quixada.es.ufc.com.trabalhomobile.BD.BDCore;
import quixada.es.ufc.com.trabalhomobile.model.Usuario;

/**
 * Created by Leh on 09/11/2016.
 */

public class UsuarioDAO {

    private SQLiteDatabase database;

    public UsuarioDAO(Context context){
        BDCore bd = new BDCore(context);
        database = bd.getWritableDatabase();
    }

    public void inserir(Usuario usuario){
        ContentValues values = new ContentValues();
        values.put("nome",usuario.getNome());
        values.put("email",usuario.getEmail());
        values.put("senha",usuario.getSenha());
        values.put("tipo",usuario.getTipo());

        database.insert("usuario",null,values);
    }
}
