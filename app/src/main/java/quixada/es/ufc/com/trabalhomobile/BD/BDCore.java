package quixada.es.ufc.com.trabalhomobile.BD;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Leh on 28/11/2016.
 */

public class BDCore extends SQLiteOpenHelper {

    private static final String NAME_DB ="mobile_db";
    private static final int VERSION_DB = 1;
    private static final String TABLE_USER = "create table usuario(_id integer primary key autoincrement, nome text not null, email text not null, senha text not null, tipo text null)";
    private static final String TABLE_PROBLEM = "create table problema(_id integer primary key autoincrement, nome text not null, descricao text not null, tipo text not null ,status text)";

    public BDCore(Context context){
        super(context, NAME_DB,null,VERSION_DB);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_USER);
        db.execSQL(TABLE_PROBLEM);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
