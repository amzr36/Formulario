package com.alejo_zr.exceldb.Carretera;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.alejo_zr.exceldb.Segmento.ConsultarSegmentoActivity;
import com.alejo_zr.exceldb.R;
import com.alejo_zr.exceldb.Segmento.RegistroSegmentoActivity;
import com.alejo_zr.exceldb.entidades.Carretera;

public class CarreteraActivity extends AppCompatActivity {

    TextView tvIdCarretera,tvNomCarretera,tvNombreCarretera,tvCodigoCarretera,tvTerritorialCarretera,tvAdmonCarretera,
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
        Carretera user=null;

        if(objetoEnviado!=null){
            user= (Carretera) objetoEnviado.getSerializable("usuario");
            tvIdCarretera.setText(user.getId().toString());
            tvNomCarretera.setText(user.getNombreCarretera().toString());
            tvNombreCarretera.setText(user.getNombreCarretera().toString());
            tvCodigoCarretera.setText(user.getCodCarretera().toString());
            tvTerritorialCarretera.setText(user.getTerritorial().toString());
            tvAdmonCarretera.setText(user.getAdmon().toString());
            tvLevantadoCarretera.setText(user.getLevantado().toString());

        }



    }

    public void onClick(View view) {

        Intent intent = null;
        switch (view.getId()) {

            case R.id.btnRegistroSegmento:
                intent = new Intent(CarreteraActivity.this,RegistroSegmentoActivity.class);
                intent.putExtra("id_carretera",tvIdCarretera.getText().toString());
                intent.putExtra("nom_carretera",tvNombreCarretera.getText().toString());
                startActivity(intent);
                break;
            case R.id.btnConsultarSegmento:
                intent = new Intent(CarreteraActivity.this,ConsultarSegmentoActivity.class);
                startActivity(intent);
                break;


        }
    }
}
