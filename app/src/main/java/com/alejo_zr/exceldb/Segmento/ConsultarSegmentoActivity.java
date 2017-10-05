package com.alejo_zr.exceldb.Segmento;

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
import com.alejo_zr.exceldb.entidades.Segmento;
import com.alejo_zr.exceldb.utilidades.Utilidades;

import java.util.ArrayList;

public class ConsultarSegmentoActivity extends AppCompatActivity {

    ListView listViewSegmentos;
    ArrayList<String> listaInformacionSegmentos;
    ArrayList<Segmento> listaSegmentos;

    BaseDatos baseDatos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultar_segmento);

        baseDatos=new BaseDatos(this);

        listViewSegmentos = (ListView) findViewById(R.id.listViewSegmento);

        consultarListaSegmentos();

        ArrayAdapter adaptador=new ArrayAdapter(this,android.R.layout.simple_list_item_1,listaInformacionSegmentos);
        listViewSegmentos.setAdapter(adaptador);

        listViewSegmentos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int posS, long l) {

                Segmento segmento=listaSegmentos.get(posS);
                Intent intent=new Intent(ConsultarSegmentoActivity.this,SegmentoActivity.class);

                Bundle bundle=new Bundle();
                bundle.putSerializable("segmento",segmento);

                intent.putExtras(bundle);

                startActivity(intent);



            }
        });

    }

    private void consultarListaSegmentos() {

        SQLiteDatabase db=baseDatos.getReadableDatabase();

        Segmento segmento=null;
        listaSegmentos= new ArrayList<Segmento>();
        //select * from carretera
        Cursor cursor=db.rawQuery("SELECT * FROM "+ Utilidades.TABLA_SEGMENTO,null);

        while(cursor.moveToNext()){
            segmento = new Segmento();
                segmento.setId_segmento(cursor.getInt(0));
                segmento.setNombre_carretera(cursor.getString(1));
                segmento.setPavInt(cursor.getInt(2));
                segmento.setTipoPav(cursor.getString(3));
                segmento.setnCalzadas(cursor.getString(4));
                segmento.setnCarriles(cursor.getString(5));
                segmento.setAnchoCarril(cursor.getString(6));
                segmento.setAnchoBerma(cursor.getString(7));
                segmento.setPri(cursor.getString(8));
                segmento.setPrf(cursor.getString(9));
                segmento.setComentarios(cursor.getString(10));

                listaSegmentos.add(segmento);
        }

       obtenerLista();

    }

    private void obtenerLista() {

        listaInformacionSegmentos = new ArrayList<String>();



        for (int i=0; i<listaSegmentos.size();i++){
            listaInformacionSegmentos.add("Carretera"+listaSegmentos.get(i).getNombre_carretera()+"- Segmento "
                    +listaSegmentos.get(i).getId_segmento());
        }
    }
}
