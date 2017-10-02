package com.alejo_zr.exceldb.Patologia;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.provider.Settings;
import android.support.annotation.RequiresApi;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.alejo_zr.exceldb.BaseDatos;
import com.alejo_zr.exceldb.R;
import com.alejo_zr.exceldb.utilidades.Utilidades;

import java.io.File;

import static android.Manifest.permission.CAMERA;
import static android.Manifest.permission.WRITE_EXTERNAL_STORAGE;

public class RegistroPatologiaActivity extends AppCompatActivity {

    private final String CARPETA_RAIZ="InventarioVial/";
    private final String RUTA_IMAGEN=CARPETA_RAIZ+"InventarioVial";

    final int COD_SELECCIONA=10;
    final int COD_FOTO=20;

    Button btnRegistrarPatologia;
    ImageButton botonCargar;
    ImageView imagen;
    String path;

    Spinner spinnerPatoFlex;
    TextView tv_nombre_carretera_patologia,tv_id_segmento_patologia;
    EditText campoCarrilPato, campoDanioPato, campoLargoDanio, campoAnchoDanio, campoLargoRepa, campoAnchoRepa, campoAclaracion;
    String[] tipoDanio = {"Seleccione el tipo de Daño", "Fisuras longitudinales y transversales", "Fisura longitudinal en junta de construcción",
            "Fisuras por reflexión de juntas o grietas en placas de concreto", "Fisuras en medialuna", "Fisuras de borde", "Fisuras en bloque", "Piel de cocotrilo",
            "Fisuración por desplazamiento de capas", "Fisuración incipiente", "Ondulación", "Abultamiento", "Hundimiento", "Ahuellamiento", "Descascaramiento",
            "Baches", "Parche", "Desgaste superficial", "Perdida de agregado", "Pulimento del agregado", "Cabezas duras", "Exudación", "Surcos",
            "Corrimiento vertical de la berma", "Separación de la berma", "Afloramiento de finos", "Afloramiento de agua"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_patologia);

        imagen= (ImageView) findViewById(R.id.imagemId);
        botonCargar= (ImageButton) findViewById(R.id.btnDanio);
        btnRegistrarPatologia= (Button) findViewById(R.id.btnRegistrarPatologia);

        if(validaPermisos()){
            botonCargar.setEnabled(true);
        }else{
            botonCargar.setEnabled(false);
        }

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

        Bundle bundle = getIntent().getExtras();
        String dato_nom_carretera = bundle.getString("nom_carretera_segmento");
        String id_segmento = bundle.getString("id_segmento");
        tv_nombre_carretera_patologia.setText(dato_nom_carretera);
        tv_id_segmento_patologia.setText(id_segmento);

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
    }



    public void onClick(View view) {

        switch (view.getId()){

            case R.id.btnRegistrarPatologia:
                registrarSegmento();
                break;
            case R.id.btnDanio:
                cargarImagen();
                break;
        }

    }

    private void registrarSegmento() {

        BaseDatos bd=new BaseDatos(this);

        SQLiteDatabase db=bd.getWritableDatabase();


        String insert="INSERT INTO "+ Utilidades.TABLA_PATOLOGIA
                +" ( " +Utilidades.CAMPO_NOMBRE_CARRETERA_PATOLOGIA+","+Utilidades.CAMPO_ID_SEGMENTO_PATOLOGIA+","+Utilidades.CAMPO_CARRIL_PATOLOGIA+","+Utilidades.CAMPO_DANIO_PATOLOGIA+
                ","+Utilidades.CAMPO_LARGO_PATOLOGIA+","+Utilidades.CAMPO_ANCHO_PATOLOGIA+ ","+Utilidades.CAMPO_LARGO_REPARACION+","+Utilidades.CAMPO_ANCHO_REPARACION+","
                +Utilidades.CAMPO_ACLARACIONES+")" +
                " VALUES ('"+tv_nombre_carretera_patologia.getText().toString()+"' , '"+tv_id_segmento_patologia.getText().toString()+"' , '"+campoCarrilPato.getText().toString()+
                "' , '"+campoDanioPato.getText().toString()+"' , '"+campoLargoDanio.getText().toString()+"' , '"+campoAnchoDanio.getText().toString()+"' , '"+
                campoLargoRepa.getText().toString()+"' , '"+campoAnchoRepa.getText().toString()+"' , '"+campoAclaracion.getText().toString()+"')";

        db.execSQL(insert);
        Toast.makeText(getApplicationContext(),R.string.regisPatologias,Toast.LENGTH_SHORT).show();

        db.close();

    }

    private void cargarImagen() {

        final CharSequence[] opciones={"Tomar Foto","Cargar Imagen","Cancelar"};
        final AlertDialog.Builder alertOpciones=new AlertDialog.Builder(RegistroPatologiaActivity.this);
        alertOpciones.setTitle("Seleccione una Opción");
        alertOpciones.setItems(opciones, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if (opciones[i].equals("Tomar Foto")){
                    tomarFotografia();
                }else{
                    if (opciones[i].equals("Cargar Imagen")){
                        Intent intent=new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                        intent.setType("image/");
                        startActivityForResult(intent.createChooser(intent,"Seleccione la Aplicación"),COD_SELECCIONA);
                    }else{
                        dialogInterface.dismiss();
                    }
                }
            }
        });
        alertOpciones.show();

    }

    private void tomarFotografia() {
        File fileImagen=new File(Environment.getExternalStorageDirectory(),RUTA_IMAGEN);
        boolean isCreada=fileImagen.exists();
        String nombreImagen="";
        if(isCreada==false){
            isCreada=fileImagen.mkdirs();
        }

        if(isCreada==true){
            nombreImagen=(System.currentTimeMillis()/1000)+".jpg";
        }


        path=Environment.getExternalStorageDirectory()+
                File.separator+RUTA_IMAGEN+File.separator+nombreImagen;

        File imagen=new File(path);

        Intent intent=null;
        intent=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        ////
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.N)
        {
            String authorities=getApplicationContext().getPackageName()+".provider";
            Uri imageUri= FileProvider.getUriForFile(this,authorities,imagen);
            intent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);
        }else
        {
            intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(imagen));
        }
        startActivityForResult(intent,COD_FOTO);

        ////
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode==RESULT_OK){

            switch (requestCode){
                case COD_SELECCIONA:
                    Uri miPath=data.getData();
                    imagen.setImageURI(miPath);
                    break;

                case COD_FOTO:
                    MediaScannerConnection.scanFile(this, new String[]{path}, null,
                            new MediaScannerConnection.OnScanCompletedListener() {
                                @Override
                                public void onScanCompleted(String path, Uri uri) {
                                    Log.i("Ruta de almacenamiento","Path: "+path);
                                }
                            });

                    Bitmap bitmap= BitmapFactory.decodeFile(path);
                    imagen.setImageBitmap(bitmap);

                    break;
            }


        }
    }

    private boolean validaPermisos() {

        if(Build.VERSION.SDK_INT<Build.VERSION_CODES.M){
            return true;
        }

        if((checkSelfPermission(CAMERA)== PackageManager.PERMISSION_GRANTED)&&
                (checkSelfPermission(WRITE_EXTERNAL_STORAGE)==PackageManager.PERMISSION_GRANTED)){
            return true;
        }

        if((shouldShowRequestPermissionRationale(CAMERA)) ||
                (shouldShowRequestPermissionRationale(WRITE_EXTERNAL_STORAGE))){
            cargarDialogoRecomendacion();
        }else{
            requestPermissions(new String[]{WRITE_EXTERNAL_STORAGE,CAMERA},100);
        }

        return false;
    }

    private void cargarDialogoRecomendacion() {
        AlertDialog.Builder dialogo=new AlertDialog.Builder(RegistroPatologiaActivity.this);
        dialogo.setTitle("Permisos Desactivados");
        dialogo.setMessage("Debe aceptar los permisos para el correcto funcionamiento de la App");

        dialogo.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                requestPermissions(new String[]{WRITE_EXTERNAL_STORAGE,CAMERA},100);
            }
        });
        dialogo.show();
    }

    private void solicitarPermisosManual() {
        final CharSequence[] opciones={"si","no"};
        final AlertDialog.Builder alertOpciones=new AlertDialog.Builder(RegistroPatologiaActivity.this);
        alertOpciones.setTitle("¿Desea configurar los permisos de forma manual?");
        alertOpciones.setItems(opciones, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if (opciones[i].equals("si")){
                    Intent intent=new Intent();
                    intent.setAction(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                    Uri uri=Uri.fromParts("package",getPackageName(),null);
                    intent.setData(uri);
                    startActivity(intent);
                }else{
                    Toast.makeText(getApplicationContext(),"Los permisos no fueron aceptados",Toast.LENGTH_SHORT).show();
                    dialogInterface.dismiss();
                }
            }
        });
        alertOpciones.show();
    }
}
