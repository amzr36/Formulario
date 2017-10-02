package com.alejo_zr.exceldb.entidades;

import java.io.Serializable;

/**
 * Created by Alejo on 28/09/2017.
 */

public class Segmento implements Serializable {

    private Integer id_segmento;
    private String nombre_carretera;
    private String tipoPav;
    private String nCalzadas;
    private String nCarriles;
    private String anchoCarril;
    private String anchoBerma;
    private String pri;
    private String prf;
    private String comentarios;

    public Segmento() {
        this.id_segmento = id_segmento;
        this.nombre_carretera = nombre_carretera;
        this.tipoPav = tipoPav;
        this.nCalzadas = nCalzadas;
        this.nCarriles = nCarriles;
        this.anchoCarril = anchoCarril;
        this.anchoBerma = anchoBerma;
        this.pri = pri;
        this.prf = prf;
        this.comentarios = comentarios;
    }

    public Integer getId_segmento() {
        return id_segmento;
    }

    public void setId_segmento(Integer id_segmento) {
        this.id_segmento = id_segmento;
    }

    public String getNombre_carretera() {
        return nombre_carretera;
    }

    public void setNombre_carretera(String nombre_carretera) {
        this.nombre_carretera = nombre_carretera;
    }

    public String getTipoPav() {
        return tipoPav;
    }

    public void setTipoPav(String tipoPav) {
        this.tipoPav = tipoPav;
    }

    public String getnCalzadas() {
        return nCalzadas;
    }

    public void setnCalzadas(String nCalzadas) {
        this.nCalzadas = nCalzadas;
    }

    public String getnCarriles() {
        return nCarriles;
    }

    public void setnCarriles(String nCarriles) {
        this.nCarriles = nCarriles;
    }

    public String getAnchoCarril() {
        return anchoCarril;
    }

    public void setAnchoCarril(String anchoCarril) {
        this.anchoCarril = anchoCarril;
    }

    public String getAnchoBerma(String string) {
        return anchoBerma;
    }

    public void setAnchoBerma(String anchoBerma) {
        this.anchoBerma = anchoBerma;
    }

    public String getPri() {
        return pri;
    }

    public void setPri(String pri) {
        this.pri = pri;
    }

    public String getPrf() {
        return prf;
    }

    public void setPrf(String prf) {
        this.prf = prf;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }
}
