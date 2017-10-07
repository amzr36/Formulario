package com.alejo_zr.exceldb.Segmento.Flexible;

import android.content.ContentValues;
import android.content.Intent;
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

public class EditarSegmentoActivity extends AppCompatActivity {

    Spinner spinnerTipoPavEditar;
    String[] tipoPAVEditar = {"Tipo de pavimento", "Pavimento Flexible", "Pavimento Rigído"};

    EditText campoNCalzadas_Editar, campoNCarriles_Editar, campoAnchoCarril_Editar, campoAnchoBerma_Editar, campoPRI_Editar, campoPRF_Editar, campoComentarios_Editar;
    TextView tvId_Carretera_Segmento_Editar,tvNombre_Carretera_Segmento_Editar,campotipoPav_Editar,tv_id_segmento_editar;

    BaseDatos baseDatos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_segmento);

        baseDatos = new BaseDatos(this);

        spinnerTipoPavEditar = (Spinner) findViewById(R.id.spinnerTipoPavEditar);

        tv_id_segmento_editar = (TextView) findViewById(R.id.tv_id_segmento_editar);
        campoNCalzadas_Editar = (EditText) findViewById(R.id.campoNCalzadas_Editar);
        campoNCarriles_Editar = (EditText) findViewById(R.id.campoNCarriles_Editar);
        campoAnchoCarril_Editar = (EditText) findViewById(R.id.campoAnchoCarril_Editar);
        campoAnchoBerma_Editar = (EditText) findViewById(R.id.campoAnchoBerma_Editar);
        campoPRI_Editar = (EditText) findViewById(R.id.campoPRI_Editar);
        campoPRF_Editar = (EditText) findViewById(R.id.campoPRF_Editar);
        campoComentarios_Editar = (EditText) findViewById(R.id.campoComentarios_Editar);
        campotipoPav_Editar = (TextView) findViewById(R.id.tvTipoPav_Editar);
        tvId_Carretera_Segmento_Editar = (TextView) findViewById(R.id.tvId_Carretera_Segmento_Editar);
        tvNombre_Carretera_Segmento_Editar = (TextView) findViewById(R.id.tvNombre_Carretera_Segmento_Editar);


        //Se toman los datos del segmento
        Bundle bundle = getIntent().getExtras();
        String id_segmento = bundle.getString("tv_id_segmento").toString();
        String nom_carretera_seg= bundle.getString("tv_nombre_carretera_segmento").toString();
        String tv_pav = bundle.getString("tvPav").toString();
        String nCalzadas = bundle.getString("tvnCalzadas").toString();
        String nCarriles = bundle.getString("tvnCarriles").toString();
        String anchoCarril = bundle.getString("tvanchoCarril".toString());
        String anchoBerma = bundle.getString("tvanchoBerma".toString());
        String pri = bundle.getString("tvPRI").toString();
        String prf = bundle.getString("tvPRF").toString();
        String comentarios = bundle.getString("tvComentarios").toString();


        //Se asignan los datos de la carretera a cada EditText
        tv_id_segmento_editar.setText(id_segmento);
        tvNombre_Carretera_Segmento_Editar.setText(nom_carretera_seg);
        campotipoPav_Editar.setText(tv_pav);
        campoNCalzadas_Editar.setText(nCalzadas);
        campoNCarriles_Editar.setText(nCarriles);
        campoAnchoCarril_Editar.setText(anchoCarril);
        campoAnchoBerma_Editar.setText(anchoBerma);
        campoPRI_Editar.setText(pri);
        campoPRF_Editar.setText(prf);
        campoComentarios_Editar.setText(comentarios);


        //(Vista donde se muestra, como se mostraran los datos, los datos que se van a ver)
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, tipoPAVEditar);
        spinnerTipoPavEditar.setAdapter(adaptador);

        spinnerTipoPavEditar.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                switch (position){
                    case 0:
                        //No se ha seleccionado el Spinner
                        break;
                    case 1:
                        campotipoPav_Editar.setText("Pavimento Flexible");
                        break;
                    case 2:
                        campotipoPav_Editar.setText("Pavimento Rigído");
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }

    public void onClick(View view) {

        switch (view.getId()){

            case R.id.btnEditarSegmentoActivity:
                editarSegmento();
                break;
            case R.id.btnEliminarSegmento:
                eliminarSegmento();
                break;
        }
    }

    private void eliminarSegmento() {
        SQLiteDatabase db=baseDatos.getWritableDatabase();
        String[] parametros={tv_id_segmento_editar.getText().toString()};
        db.delete(Utilidades.TABLA_SEGMENTO,Utilidades.CAMPO_ID_SEGMENTO+"=?",parametros);
        Toast.makeText(getApplicationContext(),"Ya se Eliminó la carretera",Toast.LENGTH_LONG).show();
        tv_id_segmento_editar.setText("");
        Intent intent = new Intent(EditarSegmentoActivity.this,ConsultarSegmentoFlexActivity.class);
        startActivity(intent);
        db.close();
    }

    private void editarSegmento() {

        SQLiteDatabase db = baseDatos.getWritableDatabase();
        String[] parametros={tv_id_segmento_editar.getText().toString()};

        ContentValues values = new ContentValues();
        values.put(Utilidades.CAMPO_TIPO_PAV_SEGMENTO,campotipoPav_Editar.getText().toString());
        values.put(Utilidades.CAMPO_CALZADAS_SEGMENTO , campoNCalzadas_Editar.getText().toString());
        values.put(Utilidades.CAMPO_CARRILES_SEGMENTO  , campoNCarriles_Editar.getText().toString());
        values.put(Utilidades.CAMPO_ANCHO_CARRIL , campoAnchoCarril_Editar.getText().toString());
        values.put(Utilidades.CAMPO_ANCHO_BERMA  , campoAnchoBerma_Editar.getText().toString());
        values.put(Utilidades.CAMPO_PRI_SEGMENTO, campoPRI_Editar.getText().toString());
        values.put(Utilidades.CAMPO_PRF_SEGMENTO, campoPRF_Editar.getText().toString());
        values.put(Utilidades.CAMPO_COMENTARIOS  , campoComentarios_Editar.getText().toString());


        db.update(Utilidades.TABLA_SEGMENTO,values,Utilidades.CAMPO_ID_SEGMENTO+"=?",parametros);
        Toast.makeText(getApplicationContext(),"Se edito el segmento",Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(EditarSegmentoActivity.this,ConsultarSegmentoFlexActivity.class);
        startActivity(intent);
        db.close();

    }


}