package com.alejo_zr.exceldb.Patologia;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.alejo_zr.exceldb.BaseDatos;
import com.alejo_zr.exceldb.R;
import com.alejo_zr.exceldb.entidades.PatoFlex;
import com.alejo_zr.exceldb.utilidades.Utilidades;

import java.util.ArrayList;

public class ConsultaPatologiaActivity extends AppCompatActivity {

    ListView listViewPatologias;
    ArrayList<String> listaInformacionPatologias;
    ArrayList<PatoFlex> listaPatologias;

    BaseDatos baseDatos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consulta_patologia);

        baseDatos=new BaseDatos(this);
        listViewPatologias = (ListView) findViewById(R.id.listViewPatologia);

        consultarListaPatologias();

        ArrayAdapter adaptador = new ArrayAdapter(this,android.R.layout.simple_list_item_1,listaInformacionPatologias);
        listViewPatologias.setAdapter(adaptador);

        listViewPatologias.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int posS, long l) {


                PatoFlex patologia=listaPatologias.get(posS);
                Intent intent=new Intent(ConsultaPatologiaActivity.this, PatologiaActivity.class);

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
        listaPatologias= new ArrayList<PatoFlex>();
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

            listaPatologias.add(patoFlex);

        }
        obtenerLista();

    }

    private void obtenerLista() {

        listaInformacionPatologias = new ArrayList<String>();

        for(int i =0;i<listaPatologias.size();i++){
            listaInformacionPatologias.add("Carretera: "+listaPatologias.get(i).getNombre_carretera_patoFlex()+"- Segmento "
                    +listaPatologias.get(i).getId_segmento_patoFlex()+"- Daño: "+listaPatologias.get(i).getCarril());/**Corregir que el ´getDanio´efectivamente muestre el daño
                                                                                                                        que se registro**/
        }
    }



}
