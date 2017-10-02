package com.alejo_zr.exceldb.utilidades;

/**
 * Created by Alejo on 21/09/2017.
 */

public class Utilidades {

    //Constantes tabla Carretera
    public static final String TABLA_CARRETERA="carretera";
    public static final String CAMPO_ID_CARRETERA="id";
    public static final String CAMPO_NOMBRE_CARRETERA="nombreCarretera";
    public static final String CAMPO_CODIGO_CARRETERA="codigoCarretera";
    public static final String CAMPO_TERRITO_CARRETERA="territorial";
    public static final String CAMPO_ADMON_CARRETERA="admon";
    public static final String CAMPO_LEVANTADO_CARRETERA="levantado";


    // Sentencia SQL para la creación de una tabla
    public static final  String CREAR_TABLA_CARRETERA = "CREATE TABLE "+TABLA_CARRETERA+
            " ("+CAMPO_ID_CARRETERA+" INTEGER PRIMARY KEY AUTOINCREMENT, "+CAMPO_NOMBRE_CARRETERA+" TEXT ,"+CAMPO_CODIGO_CARRETERA+" TEXT,"
            +CAMPO_TERRITO_CARRETERA+" TEXT,"+CAMPO_ADMON_CARRETERA+" TEXT,"+CAMPO_LEVANTADO_CARRETERA+" TEXT)";




    //Constantes tabla Segmentos
    public static final String TABLA_SEGMENTO="segmento";
    public static final String CAMPO_ID_SEGMENTO="id_segmento";
    public static final String CAMPO_NOMBRE_CARRETERA_SEGMENTO="nombre_carretera";
    public static final String CAMPO_TIPO_PAV_SEGMENTO="tipo_pav";
    public static final String CAMPO_CALZADAS_SEGMENTO="numero_calzadas";
    public static final String CAMPO_CARRILES_SEGMENTO="numero_carriles";
    public static final String CAMPO_ANCHO_CARRIL="ancho_carril";
    public static final String CAMPO_ANCHO_BERMA="ancho_berma";
    public static final String CAMPO_PRI_SEGMENTO="pri";
    public static final String CAMPO_PRF_SEGMENTO="prf";
    public static final String CAMPO_COMENTARIOS="comentarios";


    public static final String CREAR_TABLA_SEGMENTO="CREATE TABLE " +
            ""+TABLA_SEGMENTO+" ("+CAMPO_ID_SEGMENTO+" INTEGER PRIMARY KEY AUTOINCREMENT, "+CAMPO_NOMBRE_CARRETERA_SEGMENTO+" TEXT,"+CAMPO_TIPO_PAV_SEGMENTO+" TEXT, "
            +CAMPO_CALZADAS_SEGMENTO+" TEXT,"+CAMPO_CARRILES_SEGMENTO+" TEXT,"+CAMPO_ANCHO_CARRIL+" TEXT,"+CAMPO_ANCHO_BERMA+
            " TEXT,"+CAMPO_PRI_SEGMENTO+" TEXT,"+CAMPO_PRF_SEGMENTO+" TEXT,"+CAMPO_COMENTARIOS+" TEXT)";

    //Constantes tabla patologia
    public static final String TABLA_PATOLOGIA="patologia";
    public static final String CAMPO_ID_PATOLOGIA="id";
    public static final String CAMPO_ID_SEGMENTO_PATOLOGIA="id_segmento";
    public static final String CAMPO_NOMBRE_CARRETERA_PATOLOGIA="nom_carretera";
    public static final String CAMPO_CARRIL_PATOLOGIA="carril";
    public static final String CAMPO_DANIO_PATOLOGIA="daño";
    public static final String CAMPO_LARGO_PATOLOGIA="largo";
    public static final String CAMPO_ANCHO_PATOLOGIA="ancho";
    public static final String CAMPO_LARGO_REPARACION="largo_reparacion";
    public static final String CAMPO_ANCHO_REPARACION="ancho_reparacion";
    public static final String CAMPO_ACLARACIONES="aclaraciones";


    // Sentencia SQL para la creación de una tabla
    public static final  String CREAR_TABLA_PATOLOGIA= "CREATE TABLE "+TABLA_PATOLOGIA+
            " ("+CAMPO_ID_PATOLOGIA+" INTEGER PRIMARY KEY AUTOINCREMENT, "+CAMPO_NOMBRE_CARRETERA_PATOLOGIA+" TEXT,"+CAMPO_ID_SEGMENTO_PATOLOGIA+" INTEGER,"
            +CAMPO_DANIO_PATOLOGIA+" TEXT ,"+CAMPO_CARRIL_PATOLOGIA+" TEXT ,"+CAMPO_LARGO_PATOLOGIA+" TEXT,"+CAMPO_ANCHO_PATOLOGIA+" TEXT,"
            +CAMPO_LARGO_REPARACION+" TEXT,"+CAMPO_ANCHO_REPARACION+" TEXT,"+CAMPO_ACLARACIONES+" TEXT)";


    /*

    public  static final String TABLA_CARRETERA="carretera";
    public static final String CAMPO_ID="id";
    public static final String CAMPO_NOMBRE="nombre ";
    public static final String CAMPO_CODIGO="codigo";
    public static final String CAMPO_TERRITO="territorial";
    public static final String CAMPO_LEVANTADO="levantado";


    public static final  String CREAR_TABLA_CARRETERA = "CREATE TABLE "+TABLA_CARRETERA+" ("+CAMPO_ID+" INTEGER, "
            +CAMPO_NOMBRE+" TEXT, "+CAMPO_CODIGO+" TEXT,"+CAMPO_TERRITO+" TEXT,"+CAMPO_LEVANTADO+" TEXT )";

            */

}
