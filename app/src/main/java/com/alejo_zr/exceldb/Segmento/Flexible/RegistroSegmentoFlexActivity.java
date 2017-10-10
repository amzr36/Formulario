package com.alejo_zr.exceldb.Segmento.Flexible;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.alejo_zr.exceldb.BaseDatos;
import com.alejo_zr.exceldb.R;
import com.alejo_zr.exceldb.utilidades.Utilidades;

public class RegistroSegmentoFlexActivity extends AppCompatActivity {


    private EditText campoNCalzadas, campoNCarriles, campoAnchoCarril, campoAnchoBerma, campoPRI, campoPRF, campoComentarios;
    private TextView tvId_Carretera_Segmento,tvNombre_Carretera_Segmento,campotipoPav;
    private TextInputLayout input_camponCalzadas,input_campoNCarriles,input_campoAnchoCarril,input_campoAnchoBerma,input_campoPRI;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_segmento_flex);


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

        input_camponCalzadas = (TextInputLayout) findViewById(R.id.input_camponCalzadas);
        input_campoNCarriles= (TextInputLayout) findViewById(R.id.input_campoNCarriles );
        input_campoAnchoCarril= (TextInputLayout) findViewById(R.id.input_campoAnchoCarril );
        input_campoAnchoBerma= (TextInputLayout) findViewById(R.id.input_campoAnchoBerma);
        input_campoPRI= (TextInputLayout) findViewById(R.id.input_campoPRI);


        Bundle bundle = getIntent().getExtras();
        String dato_nom = bundle.getString("nom_carretera").toString();
        tvNombre_Carretera_Segmento.setText(dato_nom);


    }

    public void onClick(View view) {
        verificarDatos();

    }

    /**Se verifica que los datos minimos sean diligenciados**/

    private void verificarDatos() {
        boolean isValid = true;
        if(campoNCalzadas.getText().toString().trim().isEmpty()){
            input_camponCalzadas.setError("Ingrese el número de calzadas");
            isValid=false;
        }else{
            input_camponCalzadas.setErrorEnabled(false);
        }
        if(campoNCarriles.getText().toString().trim().isEmpty()){
            input_campoNCarriles.setError("Ingrese el número de carriles");
            isValid=false;
        }else{
            input_campoNCarriles.setErrorEnabled(false);
        }
        if(campoAnchoCarril.getText().toString().trim().isEmpty()){
            input_campoAnchoCarril.setError("Ingrese el ancho de el carril");
            isValid=false;
        }else{
            input_campoAnchoCarril.setErrorEnabled(false);
        }
        if(campoAnchoBerma.getText().toString().trim().isEmpty()){
            input_campoAnchoBerma.setError("Ingrese el ancho de la berma");
            isValid=false;
        }else{
            input_campoAnchoBerma.setErrorEnabled(false);
        }
        if(campoPRI.getText().toString().trim().isEmpty()){
            input_campoPRI.setError("Ingrese el PRI");
            isValid=false;
        }else{
            input_campoPRI.setErrorEnabled(false);
        }


        if(isValid){
            registrarSegmento();
        }
    }

    private void registrarSegmento() {

        BaseDatos bd=new BaseDatos(this);

        SQLiteDatabase db=bd.getWritableDatabase();

        String insert="INSERT INTO "+ Utilidades.SEGMENTOFLEX.TABLA_SEGMENTO
                +" ( "+Utilidades.SEGMENTOFLEX.CAMPO_NOMBRE_CARRETERA_SEGMENTO+","+Utilidades.SEGMENTOFLEX.CAMPO_CALZADAS_SEGMENTO+","
                +Utilidades.SEGMENTOFLEX.CAMPO_CARRILES_SEGMENTO+","+Utilidades.SEGMENTOFLEX.CAMPO_ANCHO_CARRIL+","+Utilidades.SEGMENTOFLEX.CAMPO_ANCHO_BERMA+","+Utilidades.SEGMENTOFLEX.CAMPO_PRI_SEGMENTO+","
                +Utilidades.SEGMENTOFLEX.CAMPO_PRF_SEGMENTO+","+Utilidades.SEGMENTOFLEX.CAMPO_COMENTARIOS+")" +
                " VALUES ('"+tvNombre_Carretera_Segmento.getText().toString()+"' , '"+campotipoPav.getText().toString()+"' , '"
                +campoNCalzadas.getText().toString()+"' , '"+campoNCarriles.getText().toString()+"' , '"+campoAnchoCarril.getText().toString()+"' , '"
                +campoAnchoBerma.getText().toString()+"' , '"+campoPRI.getText().toString()+"' , '"+campoPRF.getText().toString()+"' , '"
                +campoComentarios.getText().toString()+"')";

        db.execSQL(insert);
        Toast.makeText(getApplicationContext(),R.string.regisSeg,Toast.LENGTH_SHORT).show();

        db.close();

    }
}
