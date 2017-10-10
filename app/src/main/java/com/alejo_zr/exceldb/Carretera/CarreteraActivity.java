package com.alejo_zr.exceldb.Carretera;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.alejo_zr.exceldb.R;
import com.alejo_zr.exceldb.Segmento.Flexible.ConsultarSegmentoFlexActivity;
import com.alejo_zr.exceldb.Segmento.Rigido.ConsultarSegmentoRigiActivity;
import com.alejo_zr.exceldb.entidades.Carretera;

public class CarreteraActivity extends AppCompatActivity {

    private TextView tvIdCarretera,tvNomCarretera,tvNombreCarretera,tvCodigoCarretera,tvTerritorialCarretera,tvAdmonCarretera,
            tvLevantadoCarretera;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carretera);

        tvIdCarretera = (TextView) findViewById(R.id.tvIdCarretera);
        tvNomCarretera = (TextView) findViewById(R.id.tvNomCarretera);
        tvNombreCarretera = (TextView) findViewById(R.id.tvNombreCarretera);
        tvCodigoCarretera = (TextView) findViewById(R.id.tvCodigoCarretera);
        tvTerritorialCarretera = (TextView) findViewById(R.id.tvTerritorialCarretera);
        tvAdmonCarretera = (TextView) findViewById(R.id.tvAdmonCarretera);
        tvLevantadoCarretera = (TextView) findViewById(R.id.tvLevantadoCarretera);

        Bundle objetoEnviado=getIntent().getExtras();
        Carretera carretera=null;

        if(objetoEnviado!=null){
            carretera= (Carretera) objetoEnviado.getSerializable("carretera");
            tvIdCarretera.setText(carretera.getId().toString());
            tvNomCarretera.setText(carretera.getNombreCarretera().toString());
            tvNombreCarretera.setText(carretera.getNombreCarretera().toString());
            tvCodigoCarretera.setText(carretera.getCodCarretera().toString());
            tvTerritorialCarretera.setText(carretera.getTerritorial().toString());
            tvAdmonCarretera.setText(carretera.getAdmon().toString());
            tvLevantadoCarretera.setText(carretera.getLevantado().toString());

        }



    }



    public void onClick(View view) {

        Intent intent = null;
        switch (view.getId()) {

            case R.id.btnSegmentoFlexible:
                intent = new Intent(CarreteraActivity.this, ConsultarSegmentoFlexActivity.class);
                intent.putExtra("id_carretera",tvIdCarretera.getText().toString());
                intent.putExtra("nom_carretera",tvNombreCarretera.getText().toString());
                startActivity(intent);
                break;
            case R.id.btnSegmentoRigido:
                intent = new Intent(CarreteraActivity.this, ConsultarSegmentoRigiActivity.class);
                intent.putExtra("id_carretera",tvIdCarretera.getText().toString());
                intent.putExtra("nom_carretera",tvNombreCarretera.getText().toString());
                startActivity(intent);
                break;

            case R.id.btnEditarCarretera:
                intent = new Intent(CarreteraActivity.this,EditarCarreteraActivity.class);
                intent.putExtra("id_carretera",tvIdCarretera.getText().toString());
                intent.putExtra("nom_carretera",tvNombreCarretera.getText().toString());
                intent.putExtra("cod_carretera",tvCodigoCarretera.getText().toString());
                intent.putExtra("territo",tvTerritorialCarretera.getText().toString());
                intent.putExtra("admon",tvAdmonCarretera.getText().toString());
                intent.putExtra("levantado",tvLevantadoCarretera.getText().toString());
                startActivity(intent);
                break;


        }
    }
}
