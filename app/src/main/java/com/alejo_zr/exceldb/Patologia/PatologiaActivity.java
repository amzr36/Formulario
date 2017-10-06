package com.alejo_zr.exceldb.Patologia;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.alejo_zr.exceldb.R;
import com.alejo_zr.exceldb.entidades.PatoFlex;

public class PatologiaActivity extends AppCompatActivity {

    TextView tvIdDaño,tvIdSegmento,tvNombreCarreteraPatologiaActivity,tvCarrilDanio,tvAclaraciones,tvanchRepa,tvlarRepa,tvdanionombre,tvlarDanio,tvanchDanio;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patologia);

        tvCarrilDanio= (TextView) findViewById(R.id.tvCarrilDanio);
        tvAclaraciones=(TextView) findViewById(R.id.tvAclaraciones);
        tvanchRepa = (TextView) findViewById(R.id.tvanchorepa);
        tvlarRepa = (TextView) findViewById(R.id.tvlarRepa);
        tvdanionombre = (TextView) findViewById(R.id.tvdanionombre);
        tvlarDanio = (TextView) findViewById(R.id.tvlarDanio);
        tvanchDanio = (TextView) findViewById(R.id.tvanchDanio);
        tvIdSegmento = (TextView) findViewById(R.id.tvIdSegmento);
        tvNombreCarreteraPatologiaActivity = (TextView) findViewById(R.id.tvNombreCarreteraPatologiaActivity);
        tvIdDaño=(TextView) findViewById(R.id.tvIdDaño);


        Bundle patologiaEnviado=getIntent().getExtras();
        PatoFlex patoFlex=null;

        if(patologiaEnviado!=null){
            patoFlex = (PatoFlex) patologiaEnviado.getSerializable("patologia");
            tvCarrilDanio.setText(patoFlex.getCarril().toString());
            tvAclaraciones.setText(patoFlex.getAclaraciones().toString());
            tvanchRepa.setText(patoFlex.getAnchoRepa().toString());
            tvlarRepa.setText(patoFlex.getLargoRepa().toString());
            tvdanionombre.setText(patoFlex.getDanio().toString());
            tvanchDanio.setText(patoFlex.getAnchoDanio().toString());
            tvIdSegmento.setText(patoFlex.getId_segmento_patoFlex().toString());
            tvNombreCarreteraPatologiaActivity.setText(patoFlex.getNombre_carretera_patoFlex().toString());
            tvIdDaño.setText(patoFlex.getId_patoFlex().toString());

        }
    }

    public void onClick (View view){

        Intent intent = null;
        switch (view.getId()){

            case R.id.btnEditarPatologia:
                intent = new Intent(PatologiaActivity.this, EditarPatologiaActivity.class);
                intent.putExtra("tvCarrilDanio",tvCarrilDanio.getText().toString());
                intent.putExtra("tvAclaraciones",tvAclaraciones.getText().toString());
                intent.putExtra("tvanchRepa", tvanchRepa.getText().toString());
                intent.putExtra("tvlarRepa",tvlarRepa.getText().toString());
                intent.putExtra("tvdanionombre",tvdanionombre.getText().toString());
                intent.putExtra("tvanchDanio",tvanchDanio.getText().toString());
                intent.putExtra("tvIdSegmento",tvIdSegmento.getText().toString());
                intent.putExtra("tvNombreCarreteraPatologiaActivity",tvNombreCarreteraPatologiaActivity.getText().toString());
                intent.putExtra("tvIdDaño",tvIdDaño.getText().toString());
                startActivity( intent);
                break;

        }
    }

}
