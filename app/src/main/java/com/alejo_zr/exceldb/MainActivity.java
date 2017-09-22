package com.alejo_zr.exceldb;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.alejo_zr.exceldb.utilidades.Utilidades;

import java.io.File;
import java.util.Locale;

import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

public class MainActivity extends AppCompatActivity {
    int iRegistro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ConexionSQLiteHelper conn = new ConexionSQLiteHelper(this,"bd_carretera",null,1);
        conn.insertData();

    }

    public void onClick(View view){
        Intent intent = null;
        switch (view.getId()){
            case R.id.btnRegistroCarretera:
                intent = new Intent(MainActivity.this,RegistroCarreteraActivity.class);
                break;
            case R.id.btnConsultarCarretera:
                intent = new Intent(MainActivity.this,ConsultarCarreteraActivity.class);
                break;
            case R.id.btnExportar:
                exportar();
                break;
        }
        if(intent != null){
            startActivity(intent);
        }

    }

    private void exportar() {

        Toast.makeText(getApplicationContext(),"SI RECONOCE EL BOTON",Toast.LENGTH_SHORT).show();
        ConexionSQLiteHelper conn = new ConexionSQLiteHelper(this,"bd_carreteras",null,1);
        conn.insertData();
        final Cursor cursor = conn.getroad();

        File sd = Environment.getExternalStorageDirectory();
        String csvFile = "123Probando.xls";

        File directory = new File(sd.getAbsolutePath());
        //create directory if not exist
        if (!directory.isDirectory()) {
            directory.mkdirs();
        }
        Toast.makeText(getApplicationContext(),"ANTES DEL TRY",Toast.LENGTH_SHORT).show();
        try {
            //Toast.makeText(getApplicationContext(),"ENTRA AL TRY",Toast.LENGTH_SHORT).show();
            //file path
            File file = new File(directory, csvFile);
            WorkbookSettings wbSettings = new WorkbookSettings();
            wbSettings.setLocale(new Locale("en", "EN"));
            WritableWorkbook workbook;
            workbook = Workbook.createWorkbook(file, wbSettings);
            //Excel sheet name. 0 represents first sheet
            WritableSheet sheet = workbook.createSheet("userList", 0);

            sheet.addCell(new Label(0, 0, "ID"));
            sheet.addCell(new Label(1, 0, "RoadName")); // column and row
            sheet.addCell(new Label(2, 0, "Code"));
            sheet.addCell(new Label(3, 0, "Territorial"));
            sheet.addCell(new Label(4, 0, "Admon"));
            sheet.addCell(new Label(5, 0, "Levantado por"));


            int iff = 1;

            if (cursor.moveToNext()) {


                Toast.makeText(getApplicationContext(),"Entro al IF "+iff,Toast.LENGTH_SHORT).show();

                do {

                    Toast.makeText(getApplicationContext(),"Entro al do "+iff,Toast.LENGTH_SHORT).show();

                    String id = cursor.getString(cursor.getColumnIndex(Utilidades.CAMPO_ID));
                    Toast.makeText(getApplicationContext(),"Reconoce ID",Toast.LENGTH_SHORT).show();
                    String roadName = cursor.getString(cursor.getColumnIndex(Utilidades.CAMPO_NOMBRE));
                    Toast.makeText(getApplicationContext(),"Reconoce titulo",Toast.LENGTH_SHORT).show();
                    //String codeNumber = cursor.getString(cursor.getColumnIndex(Utilidades.CAMPO_CODIGO));
                    Toast.makeText(getApplicationContext(),"Reconoce codigo",Toast.LENGTH_SHORT).show();
                    int i = cursor.getPosition();
                    int il =i+1;
                    sheet.addCell(new Label(0, il, id));
                    sheet.addCell(new Label(1, il, roadName));
                    //sheet.addCell(new Label(1, i, codeNumber));
                    Toast.makeText(getApplicationContext(),"Sale del do "+iff,Toast.LENGTH_SHORT).show();

                    iff = iff+1;
                } while (cursor.moveToNext());

            }
            Toast.makeText(getApplicationContext(),"DESPUES IF",Toast.LENGTH_SHORT).show();
            //closing cursor
            cursor.close();
            workbook.write();
            workbook.close();
            Toast.makeText(getApplicationContext(),"ANTES TOAST EXCEL",Toast.LENGTH_SHORT).show();
            Toast.makeText(getApplication(), "Data Exported in a Excel Sheet", Toast.LENGTH_SHORT).show();


        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(getApplicationContext(),"Entra al CATCH",Toast.LENGTH_SHORT).show();
        }

    }
}
