package com.alejo_zr.exceldb.Patologia;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.alejo_zr.exceldb.R;

public class RegistroPatoFlexActivity extends AppCompatActivity {

    /*
    Spinner spinnerPatoFlex;
    TextView tv_nombre_carretera_patologia,tv_id_segmento_patologia;
    EditText campoCarrilPato, campoDanioPato, campoLargoDanio, campoAnchoDanio, campoLargoRepa, campoAnchoRepa, campoAclaracion;
    String[] tipoDanio = {"Seleccione el tipo de Daño", "Fisuras longitudinales y transversales", "Fisura longitudinal en junta de construcción",
            "Fisuras por reflexión de juntas o grietas en placas de concreto", "Fisuras en medialuna", "Fisuras de borde", "Fisuras en bloque", "Piel de cocotrilo",
            "Fisuración por desplazamiento de capas", "Fisuración incipiente", "Ondulación", "Abultamiento", "Hundimiento", "Ahuellamiento", "Descascaramiento",
            "Baches", "Parche", "Desgaste superficial", "Perdida de agregado", "Pulimento del agregado", "Cabezas duras", "Exudación", "Surcos",
            "Corrimiento vertical de la berma", "Separación de la berma", "Afloramiento de finos", "Afloramiento de agua"};
            */


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_pato_flex);
        /*

        spinnerPatoFlex = (Spinner) findViewById(R.id.spinnerPatoFlex);
        campoCarrilPato = (EditText) findViewById(R.id.campoCarrilPato);
        campoDanioPato = (EditText) findViewById(R.id.campoDanioPato);
        campoLargoDanio = (EditText) findViewById(R.id.campoLargoDanio);
        campoAnchoDanio = (EditText) findViewById(R.id.campoAnchoDanio);
        campoLargoRepa = (EditText) findViewById(R.id.campoLargoRepa);
        campoAnchoRepa = (EditText) findViewById(R.id.campoAnchoRepa);
        campoAclaracion = (EditText) findViewById(R.id.campoAclaraciones);
        tv_nombre_carretera_patologia = (TextView) findViewById(R.id.tv_nombre_carretera_patologia);
        tv_id_segmento_patologia = (TextView) findViewById(R.id.tv_id_segmento_patologia);

        */

/*
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, tipoDanio);
        spinnerPatoFlex.setAdapter(adaptador);


        spinnerPatoFlex.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                switch (position){

                    case 0:
                        //No se ha seleccionado el Spinner
                        break;
                    case 1:
                        campoDanioPato.setText(R.string.fisuras_fl_lt);
                        break;
                    case 2:
                        campoDanioPato.setText(R.string.fisura_fcl);
                        break;
                    case 3:
                        campoDanioPato.setText(R.string.fisura_fjl);
                        break;
                    case 4:
                        campoDanioPato.setText(R.string.fisura_fml);
                        break;
                    case 5:
                        campoDanioPato.setText(R.string.fbd);
                        break;
                    case 6:
                        campoDanioPato.setText(R.string.fisura_fb);
                        break;
                    case 7:
                        campoDanioPato.setText(R.string.pc);
                        break;
                    case 8:
                        campoDanioPato.setText(R.string.fdc);
                        break;
                    case 9:
                        campoDanioPato.setText(R.string.fin);
                        break;
                    case 10:
                        campoDanioPato.setText(R.string.ond);
                        break;
                    case 11:
                        campoDanioPato.setText(R.string.ab);
                        break;
                    case 12:
                        campoDanioPato.setText(R.string.hun);
                        break;
                    case 13:
                        campoDanioPato.setText(R.string.ahu);
                        break;
                    case 14:
                        campoDanioPato.setText(R.string.dcf);
                        break;
                    case 15:
                        campoDanioPato.setText(R.string.bchf);
                        break;
                    case 16:
                        campoDanioPato.setText(R.string.pch);
                        break;
                    case 17:
                        campoDanioPato.setText(R.string.dsu);
                        break;
                    case 18:
                        campoDanioPato.setText(R.string.pa);
                        break;
                    case 19:
                        campoDanioPato.setText(R.string.puf);
                        break;
                    case 20:
                        campoDanioPato.setText(R.string.cd);
                        break;
                    case 21:
                        campoDanioPato.setText(R.string.ex);
                        break;
                    case 22:
                        campoDanioPato.setText(R.string.su);
                        break;
                    case 23:
                        campoDanioPato.setText(R.string.cvb);
                        break;
                    case 24:
                        campoDanioPato.setText(R.string.sbf);
                        break;
                    case 25:
                        campoDanioPato.setText(R.string.afi);
                        break;
                    case 26:
                        campoDanioPato.setText(R.string.afa);
                        break;

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        */

    }

   /*
    public void onClick(View view) {
        registrarSegmento();
    }

    private void registrarSegmento() {

        BaseDatos bd=new BaseDatos(this);

        SQLiteDatabase db=bd.getWritableDatabase();


        String insert="INSERT INTO "+ Utilidades.TABLA_PATOLOGIA
                +" ( " +Utilidades.CAMPO_CARRIL_PATOLOGIA+","+Utilidades.CAMPO_DANIO_PATOLOGIA+","+Utilidades.CAMPO_LARGO_PATOLOGIA+","+Utilidades.CAMPO_ANCHO_PATOLOGIA+
                ","+Utilidades.CAMPO_LARGO_REPARACION+","+Utilidades.CAMPO_ANCHO_REPARACION+","+Utilidades.CAMPO_ACLARACIONES+")" +
                " VALUES ('"+campoCarrilPato.getText().toString()+"' , '"+campoDanioPato.getText().toString()+"' , '"+campoLargoDanio.getText().toString()+"' , '"
                +campoAnchoDanio.getText().toString()+"' , '"+campoLargoRepa.getText().toString()+"' , '"+campoAnchoRepa.getText().toString()+"' , '"
                +campoAclaracion.getText().toString()+"')";

        db.execSQL(insert);
        Toast.makeText(getApplicationContext(),R.string.regisPatologias,Toast.LENGTH_SHORT).show();

        db.close();

    }
    */
}
