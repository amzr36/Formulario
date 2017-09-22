package com.alejo_zr.exceldb;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.alejo_zr.exceldb.utilidades.Utilidades;

/**
 * Created by Alejo on 21/09/2017.
 */

public class ConexionSQLiteHelper extends SQLiteOpenHelper{
    public ConexionSQLiteHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Utilidades.CREAR_TABLA_CARRETERA);
    }



    @Override
    public void onUpgrade(SQLiteDatabase db, int versionAntigua, int versionNueva) {
        db.execSQL("DROP TABLE IF EXITS carreteras"+Utilidades.TABLA_CARRETERA);
        onCreate(db);

    }
    public void insertData(){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        // contentValues.put("id integer primary key","1");
        contentValues.put("id", "id");
        contentValues.put("road_name", "probando");
        contentValues.put("code_number", "123456");
        db.insert(Utilidades.TABLA_CARRETERA,null,contentValues);
    }

    public Cursor getroad() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("select * from " + Utilidades.TABLA_CARRETERA + " ",
                null);
        return res;
    }
}
