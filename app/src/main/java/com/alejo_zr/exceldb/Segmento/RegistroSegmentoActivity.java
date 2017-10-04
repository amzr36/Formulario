package com.alejo_zr.exceldb.Segmento;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.alejo_zr.exceldb.BaseDatos;
import com.alejo_zr.exceldb.R;
import com.alejo_zr.exceldb.utilidades.Utilidades;

public class RegistroSegmentoActivity extends AppCompatActivity {


    Spinner spinnerTipoPav;
    String[] tipoPAV = {"Tipo de pavimento", "Pavimento Flexible", "Pavimento Rigído"};
    EditText campoNCalzadas, campoNCarriles, campoAnchoCarril, campoAnchoBerma, campoPRI, campoPRF, campoComentarios;
    TextView tvId_Carretera_Segmento,tvNombre_Carretera_Segmento,campotipoPav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_segmento);

        spinnerTipoPav = (Spinner) findViewById(R.id.spinnerTipoPav);

        campoNCalzadas = (EditText) findViewById(R.id.campoNCalzadas);
        campoNCarriles = (EditText) findViewById(R.id.campoNCarriles);
        campoAnchoCarril = (EditText) findViewById(R.id.campoAnchoCarril);
        campoAnchoBerma = (EditText) findViewById(R.id.campoAnchoBerma);
        campoPRI = (EditText) findViewById(R.id.campoPRI);
        campoPRF = (EditText) findViewById(R.id.campoPRF);
        campoComentarios = (EditText) findViewById(R.id.campoComentarios);
        campotipoPav = (TextView) findViewById(R.id.tvTipoPav);
        tvId_Carretera_Segmento = (TextView) findViewById(R.id.tvId_Carretera_Segmento);
        tvNombre_Carretera_Segmento = (TextView) findViewById(R.id.tvNombre_Carretera_Segmento);


        Bundle bundle = getIntent().getExtras();
        String dato_id = bundle.getString("id_carretera").toString();
        String dato_nom = bundle.getString("nom_carretera").toString();
        tvNombre_Carretera_Segmento.setText(dato_nom);

        //(Vista donde se muestra, como se mostraran los datos, los datos que se van a ver)
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, tipoPAV);
        spinnerTipoPav.setAdapter(adaptador);

        spinnerTipoPav.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                switch (position){

                    case 0:
                        //No se ha seleccionado el Spinner
                        break;
                    case 1:
                        campotipoPav.setText("Pavimento Flexible");
                        break;
                    case 2:
                        campotipoPav.setText("Pavimento Rigído");
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


    }

    public void onClick(View view) {
        registrarSegmento();
    }

    private void registrarSegmento() {

        BaseDatos bd=new BaseDatos(this);

        SQLiteDatabase db=bd.getWritableDatabase();

        String insert="INSERT INTO "+ Utilidades.TABLA_SEGMENTO
                +" ( "+Utilidades.CAMPO_NOMBRE_CARRETERA_SEGMENTO+"," +Utilidades.CAMPO_TIPO_PAV_SEGMENTO+","+Utilidades.CAMPO_CALZADAS_SEGMENTO+","
                +Utilidades.CAMPO_CARRILES_SEGMENTO+","+Utilidades.CAMPO_ANCHO_CARRIL+","+Utilidades.CAMPO_ANCHO_BERMA+","
                +Utilidades.CAMPO_PRI_SEGMENTO+","+Utilidades.CAMPO_PRF_SEGMENTO+","+Utilidades.CAMPO_COMENTARIOS+")" +
                " VALUES ('"+tvNombre_Carretera_Segmento.getText().toString()+"' , '"+campotipoPav.getText().toString()+"' , '"+campoNCalzadas.getText().toString()+"' , '"
                +campoNCarriles.getText().toString()+"' , '"+campoAnchoCarril.getText().toString()+"' , '"
                +campoAnchoBerma.getText().toString()+"' , '"+campoPRI.getText().toString()+"' , '"
                +campoPRF.getText().toString()+"' , '"+campoComentarios.getText().toString()+"')";

        db.execSQL(insert);
        Toast.makeText(getApplicationContext(),R.string.regisSeg,Toast.LENGTH_SHORT).show();

        db.close();

    }
}
