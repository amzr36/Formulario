package com.alejo_zr.exceldb.entidades;

import java.io.Serializable;

/**
 * Created by Alejo on 29/09/2017.
 */

public class PatoFlex implements Serializable {

    private Integer id_patoFlex;
    private String nombre_carretera_patoFlex;
    private String id_segmento_patoFlex;
    private String carril;
    private String danio;
    private String largoDanio;
    private String anchoDanio;
    private String largoRepa;
    private String anchoRepa;
    private String aclaraciones;
    private String foto;

    public PatoFlex(Integer id_patoFlex, String nombre_carretera_patoFlex, String id_segmento_patoFlex, String carril, String danio, String largoDanio,
                    String anchoDanio, String largoRepa, String anchoRepa, String aclaraciones, String foto) {
        this.id_patoFlex = id_patoFlex;
        this.nombre_carretera_patoFlex = nombre_carretera_patoFlex;
        this.id_segmento_patoFlex = id_segmento_patoFlex;
        this.carril = carril;
        this.danio = danio;
        this.largoDanio = largoDanio;
        this.anchoDanio = anchoDanio;
        this.largoRepa = largoRepa;
        this.anchoRepa = anchoRepa;
        this.aclaraciones = aclaraciones;
        this.foto = foto;
    }

    public PatoFlex() {

    }

    private void PatoFlex(Integer ID_patoFlex, String Nombre_carretera_patoFlex, String ID_segmento_patoFlex, String CArril, String DAnio, String LArgoDanio,
                          String ANchoDanio, String LArgoRepa, String ANchoRepa, String AClaraciones, String FOto){

    }

    public Integer getId_patoFlex() {
        return id_patoFlex;
    }

    public void setId_patoFlex(Integer id_patoFlex) {
        this.id_patoFlex = id_patoFlex;
    }

    public String getNombre_carretera_patoFlex() {
        return nombre_carretera_patoFlex;
    }

    public void setNombre_carretera_patoFlex(String nombre_carretera_patoFlex) {
        this.nombre_carretera_patoFlex = nombre_carretera_patoFlex;
    }

    public String getId_segmento_patoFlex() {
        return id_segmento_patoFlex;
    }

    public void setId_segmento_patoFlex(String id_segmento_patoFlex) {
        this.id_segmento_patoFlex = id_segmento_patoFlex;
    }

    public String getCarril() {
        return carril;
    }

    public void setCarril(String carril) {
        this.carril = carril;
    }

    public String getDanio() {
        return danio;
    }

    public void setDanio(String danio) {
        this.danio = danio;
    }

    public String getLargoDanio() {
        return largoDanio;
    }

    public void setLargoDanio(String largoDanio) {
        this.largoDanio = largoDanio;
    }

    public String getAnchoDanio() {
        return anchoDanio;
    }

    public void setAnchoDanio(String anchoDanio) {
        this.anchoDanio = anchoDanio;
    }

    public String getLargoRepa() {
        return largoRepa;
    }

    public void setLargoRepa(String largoRepa) {
        this.largoRepa = largoRepa;
    }

    public String getAnchoRepa() {
        return anchoRepa;
    }

    public void setAnchoRepa(String anchoRepa) {
        this.anchoRepa = anchoRepa;
    }

    public String getAclaraciones() {
        return aclaraciones;
    }

    public void setAclaraciones(String aclaraciones) {
        this.aclaraciones = aclaraciones;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }
}
