package com.alejo_zr.exceldb.utilidades;

/**
 * Created by Alejo on 21/09/2017.
 */

public class Utilidades {

    public  static final String TABLA_CARRETERA="carretera";
    public static final String CAMPO_ID="id";
    public static final String CAMPO_LEVANTADO="levantado";
    public static final String CAMPO_NOMBRE="nombre";
    public static final String CAMPO_CODIGO="codigo";
    public static final String CAMPO_TERRITO="territorial";

    public static final  String CREAR_TABLA_CARRETERA = "CREATE TABLE "+TABLA_CARRETERA+" ("+CAMPO_ID+" INTEGER, "
            +CAMPO_NOMBRE+" TEXT, "+CAMPO_CODIGO+"TEXT,"+CAMPO_TERRITO+"TEXT)";

}
