package com.alejo_zr.exceldb.Carretera;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.alejo_zr.exceldb.BaseDatos;
import com.alejo_zr.exceldb.R;
import com.alejo_zr.exceldb.utilidades.Utilidades;

public class RegistroCarreteraActivity extends AppCompatActivity {

    private EditText campoNombre,campoCodigo,campoTerrito,campoLevantado,campoAdmon;
    private TextInputLayout inputLayoutNombre;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_carretera);


        campoNombre = (EditText) findViewById(R.id.campoNombre);
        campoCodigo = (EditText) findViewById(R.id.campoCodigo);
        campoTerrito = (EditText) findViewById(R.id.campoTerritorial);
        campoAdmon = (EditText) findViewById(R.id.campoAdmon);
        campoLevantado = (EditText) findViewById(R.id.campoLevantado);

        inputLayoutNombre= (TextInputLayout) findViewById(R.id.input_layout_nombre);

    }

    public void onClick(View view) {
        verficarCampo();
    }

    private void verficarCampo() {
        boolean isValid = true;
        if(campoNombre.getText().toString().trim().isEmpty()){
            inputLayoutNombre.setError("Ingrese el nombre");
            isValid = false;
        }else{
            inputLayoutNombre.setErrorEnabled(false);
        }
        if(isValid){
            registrarCarretera();
        }
    }

    //Metodo con el cual se registran los datos en la base de datos correspondientes a la tabla 'Carretera'
    private void registrarCarretera() {
        BaseDatos baseDatos=new BaseDatos(this);

        SQLiteDatabase db=baseDatos.getWritableDatabase();


        String insert="INSERT INTO "+Utilidades.CARRETERA.TABLA_CARRETERA
                +" ( " +Utilidades.CARRETERA.CAMPO_NOMBRE_CARRETERA+","+Utilidades.CARRETERA.CAMPO_CODIGO_CARRETERA+","+Utilidades.CARRETERA.CAMPO_TERRITO_CARRETERA+","
                +Utilidades.CARRETERA.CAMPO_ADMON_CARRETERA+","+Utilidades.CARRETERA.CAMPO_LEVANTADO_CARRETERA+")" +
                " VALUES ('"+campoNombre.getText().toString()+"' , '"+campoCodigo.getText().toString()+"' , '"
                +campoTerrito.getText().toString()+"' , '"+campoAdmon.getText().toString()+"' , '"+campoLevantado.getText().toString()+"')";

        db.execSQL(insert);
        Toast.makeText(getApplicationContext(),"Se registro la vía : "+campoNombre.getText().toString(),Toast.LENGTH_SHORT).show();

        db.close();
    }



}
