package com.alejo_zr.exceldb.Patologia.Flexible;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.alejo_zr.exceldb.BaseDatos;
import com.alejo_zr.exceldb.R;
import com.alejo_zr.exceldb.entidades.PatoFlex;
import com.alejo_zr.exceldb.utilidades.Utilidades;

import java.util.ArrayList;

public class ConsultaPatologiaFlexActivity extends AppCompatActivity {

    ListView listViewPatologiasFlex;
    ArrayList<String> listaInformacionPatologiasFlex;
    ArrayList<PatoFlex> listaPatologiasFlex;

    BaseDatos baseDatos;
    TextView tvnomCarretera_consultar_patoFlex,tvIdSegmento_consultar_patoflex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consulta_patologia_flex);

        baseDatos=new BaseDatos(this);
        listViewPatologiasFlex = (ListView) findViewById(R.id.listViewPatologiaFlex);
        tvnomCarretera_consultar_patoFlex = (TextView) findViewById(R.id.tvnomCarretera_consultar_patoFlex);
        tvIdSegmento_consultar_patoflex = (TextView) findViewById(R.id.tvIdSegmento_consultar_patoflex);

        Bundle bundle = getIntent().getExtras();
        String dato_nom = bundle.getString("tv_nombre_carretera_segmento").toString();
        String id_segmento = bundle.getString("tv_id_segmento").toString();
        tvnomCarretera_consultar_patoFlex.setText(dato_nom);
        tvIdSegmento_consultar_patoflex.setText(id_segmento);


        consultarListaPatologias();

        ArrayAdapter adaptador = new ArrayAdapter(this,android.R.layout.simple_list_item_1,listaInformacionPatologiasFlex);
        listViewPatologiasFlex.setAdapter(adaptador);

        listViewPatologiasFlex.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int posS, long l) {


                PatoFlex patologia=listaPatologiasFlex.get(posS);
                Intent intent=new Intent(ConsultaPatologiaFlexActivity.this, PatologiaFlexActivity.class);

                Bundle bundle=new Bundle();
                bundle.putSerializable("patologia",patologia);

                intent.putExtras(bundle);

                startActivity(intent);

            }
        });
    }

    private void consultarListaPatologias() {

        SQLiteDatabase db=baseDatos.getReadableDatabase();

        PatoFlex patoFlex=null;
        listaPatologiasFlex= new ArrayList<PatoFlex>();
        //select * from carretera
        Cursor cursor=db.rawQuery("SELECT * FROM "+ Utilidades.TABLA_PATOLOGIA,null);

        while(cursor.moveToNext()){
            patoFlex = new PatoFlex();
            patoFlex.setId_patoFlex(cursor.getInt(0));
            patoFlex.setNombre_carretera_patoFlex(cursor.getString(1));
            patoFlex.setId_segmento_patoFlex(cursor.getString(2));
            patoFlex.setCarril(cursor.getString(3));
            patoFlex.setDanio(cursor.getString(4));
            patoFlex.setLargoDanio(cursor.getString(5));
            patoFlex.setAnchoDanio(cursor.getString(6));
            patoFlex.setLargoRepa(cursor.getString(7));
            patoFlex.setAnchoRepa(cursor.getString(8));
            patoFlex.setAclaraciones(cursor.getString(9));
            patoFlex.setFoto(cursor.getString(10));

            listaPatologiasFlex.add(patoFlex);

        }
        obtenerLista();

    }

    private void obtenerLista() {

        listaInformacionPatologiasFlex = new ArrayList<String>();

        for (int i = 0; i < listaPatologiasFlex.size(); i++) {
            boolean nomCarretera = tvnomCarretera_consultar_patoFlex.getText().toString().equals(listaPatologiasFlex.get(i).getNombre_carretera_patoFlex());
            if (nomCarretera == true) {
                boolean idSeg = tvIdSegmento_consultar_patoflex.getText().toString().equals(listaPatologiasFlex.get(i).getId_segmento_patoFlex());
                if (idSeg== true){
                    listaInformacionPatologiasFlex.add("Carretera: " + listaPatologiasFlex.get(i).getNombre_carretera_patoFlex() + "- Daño: " + listaPatologiasFlex.get(i).getCarril());
                    /**Corregir que el ´getDanio´efectivamente muestre el daño
                     que se registro**/
                }else{
                    listaInformacionPatologiasFlex.add("No es de el segmento de la carretera");
                }

            }else{
                listaInformacionPatologiasFlex.add("No es de la carretera");
            }
        }


    }
}
