package com.alejo_zr.exceldb;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.alejo_zr.exceldb.entidades.Carretera;
import com.alejo_zr.exceldb.utilidades.Utilidades;

import java.util.ArrayList;

public class ConsultarCarreteraActivity extends AppCompatActivity {

    ListView listViewPersonas;
    ArrayList<String> listaInformacion;
    ArrayList<Carretera> listaUsuarios;

    ConexionSQLiteHelper conn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultar_carretera);


        conn=new ConexionSQLiteHelper(getApplicationContext(),"bd_carreteras",null,1);

        listViewPersonas= (ListView) findViewById(R.id.listViewPersonas);

        consultarListaPersonas();

        ArrayAdapter adaptador=new ArrayAdapter(this,android.R.layout.simple_list_item_1,listaInformacion);
        listViewPersonas.setAdapter(adaptador);

    }
    private void consultarListaPersonas() {
        SQLiteDatabase db=conn.getReadableDatabase();

        Carretera carretera=null;
        listaUsuarios= new ArrayList<Carretera>();
        //select * from usuarios
        Cursor cursor=db.rawQuery("SELECT * FROM "+ Utilidades.TABLA_CARRETERA,null);

        while (cursor.moveToNext()){
            carretera=new Carretera();
            carretera.setId(cursor.getInt(0));
            carretera.setNombre(cursor.getString(1));
            carretera.setCodigo(cursor.getString(2));
            //usuario.setTerri(cursor.getString(3));

            listaUsuarios.add(carretera);
        }
        obtenerLista();
    }

    private void obtenerLista() {
        listaInformacion=new ArrayList<String>();

        for (int i=0; i<listaUsuarios.size();i++){
            listaInformacion.add(listaUsuarios.get(i).getId()+" - "
                    +listaUsuarios.get(i).getNombre()+"-"+listaUsuarios.get(i).getCodigo());
        }

    }

}



