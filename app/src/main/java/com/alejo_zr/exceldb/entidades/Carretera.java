package com.alejo_zr.exceldb.entidades;

/**
 * Created by Alejo on 21/09/2017.
 */

public class Carretera {

    private Integer id;
    private String levantado;
    private String nombre;
    private String codigo;
    private String territorial;

    public Carretera() {
        this.id = id;
        this.levantado = levantado;
        this.nombre = nombre;
        this.codigo = codigo;
        this.territorial = territorial;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLevantado() {
        return levantado;
    }

    public void setLevantado(String levantado) {
        this.levantado = levantado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getTerritorial() {
        return territorial;
    }

    public void setTerritorial(String territorial) {
        this.territorial = territorial;
    }
}
