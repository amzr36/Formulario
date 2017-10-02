package com.alejo_zr.exceldb.Carretera;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.alejo_zr.exceldb.BaseDatos;
import com.alejo_zr.exceldb.R;
import com.alejo_zr.exceldb.utilidades.Utilidades;

public class RegistroCarreteraActivity extends AppCompatActivity {

    EditText campoNombre,campoCodigo,campoTerrito,campoLevantado,campoAdmon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_carretera);


        campoNombre = (EditText) findViewById(R.id.campoNombre);
        campoCodigo = (EditText) findViewById(R.id.campoCodigo);
        campoTerrito = (EditText) findViewById(R.id.campoTerritorial);
        campoAdmon = (EditText) findViewById(R.id.campoAdmon);
        campoLevantado = (EditText) findViewById(R.id.campoLevantado);
    }

    public void onClick(View view) {
        registrarCarretera();
    }

    //Metodo con el cual se registran los datos en la base de datos correspondientes a la tabla 'Carretera'
    private void registrarCarretera() {
        BaseDatos baseDatos=new BaseDatos(this);

        SQLiteDatabase db=baseDatos.getWritableDatabase();


        String insert="INSERT INTO "+Utilidades.TABLA_CARRETERA
                +" ( " +Utilidades.CAMPO_NOMBRE_CARRETERA+","+Utilidades.CAMPO_CODIGO_CARRETERA+","+Utilidades.CAMPO_TERRITO_CARRETERA+","
                +Utilidades.CAMPO_ADMON_CARRETERA+","+Utilidades.CAMPO_LEVANTADO_CARRETERA+")" +
                " VALUES ('"+campoNombre.getText().toString()+"' , '"+campoCodigo.getText().toString()+"' , '"
                +campoTerrito.getText().toString()+"' , '"+campoAdmon.getText().toString()+"' , '"+campoLevantado.getText().toString()+"')";

        db.execSQL(insert);
        Toast.makeText(getApplicationContext(),"Se registro la vía : "+campoNombre.getText().toString(),Toast.LENGTH_SHORT).show();

        db.close();
    }



}
