package com.alejo_zr.exceldb;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.alejo_zr.exceldb.utilidades.Utilidades;

public class RegistroCarreteraActivity extends AppCompatActivity {

    EditText campoId,campoNombre,campoCodigo,campoTerrito,campoLevantado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_carretera);

        campoId = (EditText) findViewById(R.id.campoId);
        campoNombre = (EditText) findViewById(R.id.campoNombre);
        campoCodigo = (EditText) findViewById(R.id.campoCodigo);
        campoTerrito = (EditText) findViewById(R.id.campoTerritorial);
        campoLevantado = (EditText) findViewById(R.id.campoLevantado);
    }

    public void onClick(View view) {
        //registrarCarretera();
        registrarCarreteraSql();
    }

    private void registrarCarreteraSql() {
        ConexionSQLiteHelper conn=new ConexionSQLiteHelper(this,"bd_carreteras",null,1);

        SQLiteDatabase db=conn.getWritableDatabase();

        //insert into usuario (id,nombre,telefono) values (123,'Cristian','85665223')

        String insert="INSERT INTO "+Utilidades.TABLA_CARRETERA
                +" ( " +Utilidades.CAMPO_ID+","+Utilidades.CAMPO_NOMBRE+","+Utilidades.CAMPO_NOMBRE+")" +
                " VALUES ("+campoId.getText().toString()+", '"+campoNombre.getText().toString()+"','"
                +campoCodigo.getText().toString()+"')";

        db.execSQL(insert);
        Toast.makeText(getApplicationContext(),"Id Resultante : "+campoId.getText().toString(),Toast.LENGTH_SHORT).show();

        db.close();
    }


    private void registrarCarretera() {
        ConexionSQLiteHelper conn = new ConexionSQLiteHelper(this,"bd_carreteras",null,1);
        SQLiteDatabase db = conn.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(Utilidades.CAMPO_ID,campoId.getText().toString());
        values.put(Utilidades.CAMPO_NOMBRE,campoNombre.getText().toString());
        values.put(Utilidades.CAMPO_CODIGO,campoCodigo.getText().toString());
        values.put(Utilidades.CAMPO_TERRITO,campoTerrito.getText().toString());

        Long idResultante = db.insert(Utilidades.TABLA_CARRETERA,Utilidades.CAMPO_ID,values);

        Toast.makeText(getApplicationContext(),"Id Registro: "+idResultante,Toast.LENGTH_SHORT).show();
        db.close();
    }
}
