/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cheques.models;

import java.io.Serializable;

/**
 *
 * @author IDAC
 */
public class DestinatariosCorreoIntentoAccesoModel implements Serializable {

    private Integer idusuario;
    private String nombre;
    private String iddestinatario;
    private String correodestinatario;
    private String username;

    public Integer getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(Integer idusuario) {
        this.idusuario = idusuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getIddestinatario() {
        return iddestinatario;
    }

    public void setIddestinatario(String iddestinatario) {
        this.iddestinatario = iddestinatario;
    }

    public String getCorreodestinatario() {
        return correodestinatario;
    }

    public void setCorreodestinatario(String correodestinatario) {
        this.correodestinatario = correodestinatario;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
