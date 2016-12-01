package quixada.es.ufc.com.trabalhomobile.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import quixada.es.ufc.com.trabalhomobile.BD.BDCore;
import quixada.es.ufc.com.trabalhomobile.model.Problema;

/**
 * Created by Leh on 04/11/2016.
 */

public class ProblemaDAO {

    private SQLiteDatabase database;

    public ProblemaDAO(Context context){
        BDCore bd = new BDCore(context);
        database = bd.getWritableDatabase();
    }

    public void inserir(Problema problema) {
        ContentValues value = new ContentValues();
        value.put("nome", problema.getNome());
        value.put("descricao", problema.getDescricao());
        value.put("tipo", problema.getTipo());
        value.put("status", problema.getStatus());
        try {
            database.insert("problema", null, value);
        } catch (Exception e){
            throw e;
        }
    }
    public void atualizar(Problema problema){
        ContentValues value = new ContentValues();
        value.put("nome",problema.getNome());
        value.put("descricao",problema.getDescricao());
        value.put("tipo",problema.getTipo());
        value.put("status",problema.getStatus());

        database.update("problema",value, "_id = ?", new String[]{""+problema.getId()});
    }

    public void deletar(Problema problema){
        try {
            database.delete("problema","_id = "+problema.getId(),null);
        }catch (Exception e){
            throw e;
        }

    }

    public List<Problema> buscar(){
        List<Problema> lista = new ArrayList<Problema>();
        String[] column = new String[]{"_id", "nome", "descricao","tipo"};
        Cursor cursor = database.query("problema", column, null,null,null,null,"_id DESC");

        if(cursor.getCount() > 0){
            cursor.moveToFirst();
            do {
                Problema problema = new Problema();
                problema.setId(cursor.getInt(0));
                problema.setNome(cursor.getString(1));
                problema.setDescricao(cursor.getString(2));
                problema.setTipo(cursor.getString(3));
                lista.add(problema);
            }while(cursor.moveToNext());
        }
        return lista;
    }

}
