package com.alejo_zr.exceldb.Segmento.Flexible;

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
import com.alejo_zr.exceldb.entidades.SegmentoFlex;
import com.alejo_zr.exceldb.utilidades.Utilidades;

import java.util.ArrayList;

import static com.alejo_zr.exceldb.R.string.segmento;

public class ConsultarSegmentoFlexActivity extends AppCompatActivity {

    private ListView listViewSegmentos;
    private ArrayList<String> listaInformacionSegmentos;
    private ArrayList<SegmentoFlex> listaSegmentos;
    private TextView tvnomCarretera_consultar_segmentoFlex;

    private BaseDatos baseDatos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultar_segmento_flex);

        baseDatos=new BaseDatos(this);

        listViewSegmentos = (ListView) findViewById(R.id.listViewSegmentoFlex);
        tvnomCarretera_consultar_segmentoFlex = (TextView) findViewById(R.id.tvnomCarretera_consultar_segmentoFlex);

        Bundle bundle = getIntent().getExtras();
        //String dato_id = bundle.getString("id_carretera").toString();
        String dato_nom = bundle.getString("nom_carretera").toString();
        tvnomCarretera_consultar_segmentoFlex.setText(dato_nom);

        consultarListaSegmentos();

        ArrayAdapter adaptador=new ArrayAdapter(this,android.R.layout.simple_list_item_1,listaInformacionSegmentos);
        listViewSegmentos.setAdapter(adaptador);

        listViewSegmentos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int posS, long l) {

                SegmentoFlex segmentoflex=listaSegmentos.get(posS);
                Intent intent=new Intent(ConsultarSegmentoFlexActivity.this,SegmentoFlexActivity.class);

                Bundle bundle=new Bundle();
                bundle.putSerializable("segmento",segmento);

                intent.putExtras(bundle);

                startActivity(intent);            }
        });
    }

    protected void onStart() {
        super.onStart();

        baseDatos=new BaseDatos(this);

        listViewSegmentos = (ListView) findViewById(R.id.listViewSegmentoFlex);
        tvnomCarretera_consultar_segmentoFlex = (TextView) findViewById(R.id.tvnomCarretera_consultar_segmentoFlex);

        Bundle bundle = getIntent().getExtras();
        //String dato_id = bundle.getString("id_carretera").toString();
        String dato_nom = bundle.getString("nom_carretera").toString();
        tvnomCarretera_consultar_segmentoFlex.setText(dato_nom);

        consultarListaSegmentos();

        ArrayAdapter adaptador=new ArrayAdapter(this,android.R.layout.simple_list_item_1,listaInformacionSegmentos);
        listViewSegmentos.setAdapter(adaptador);

        listViewSegmentos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int posS, long l) {

                SegmentoFlex segmentoflex=listaSegmentos.get(posS);
                Intent intent=new Intent(ConsultarSegmentoFlexActivity.this,SegmentoFlexActivity.class);

                Bundle bundle=new Bundle();
                bundle.putSerializable("segmento",segmento);

                intent.putExtras(bundle);

                startActivity(intent);
            }
        });

    }

    private void consultarListaSegmentos() {

        SQLiteDatabase db=baseDatos.getReadableDatabase();

        SegmentoFlex segmento=null;
        listaSegmentos= new ArrayList<SegmentoFlex>();
        //select * from carretera
        Cursor cursor=db.rawQuery("SELECT * FROM "+ Utilidades.SEGMENTOFLEX.TABLA_SEGMENTO,null);

        while(cursor.moveToNext()){
            segmento = new SegmentoFlex();
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
            boolean nomCarretera = tvnomCarretera_consultar_segmentoFlex.getText().toString().equals(listaSegmentos.get(i).getNombre_carretera());
            if(nomCarretera==true){
                listaInformacionSegmentos.add("Carretera: "+listaSegmentos.get(i).getNombre_carretera()+" - PRI: "+listaSegmentos.get(i).getPri());
            }else{
                listaInformacionSegmentos.add("NO ES DE LA CARRETERA");
            }

        }
    }

    public void onClick(View view) {

        switch (view.getId()){
            case R.id.floabtnAddSegFlex:
                Intent intent = new Intent(ConsultarSegmentoFlexActivity.this,RegistroSegmentoFlexActivity.class);
                intent.putExtra("nom_carretera",tvnomCarretera_consultar_segmentoFlex.getText().toString());
                startActivity(intent);
                break;
        }


    }

}
