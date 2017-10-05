package com.alejo_zr.exceldb.Segmento;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
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
    TextView tvId_Carretera_Segmento_Editar,tvNombre_Carretera_Segmento_Editar,campotipoPav_Editar,tvPavInt_Editar,tv_id_segmento_editar;

    BaseDatos baseDatos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_segmento);

        baseDatos = new BaseDatos(this);

        spinnerTipoPavEditar = (Spinner) findViewById(R.id.spinnerTipoPav_Editar);

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
        String comentarios = bundle.getString("vComentarios").toString();

/*
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
        */

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
        Intent intent = new Intent(EditarSegmentoActivity.this,ConsultarSegmentoActivity.class);
        startActivity(intent);
        db.close();
    }

    private void editarSegmento() {
    }
}
