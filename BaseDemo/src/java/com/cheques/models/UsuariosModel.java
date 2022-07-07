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
public class UsuariosModel implements Serializable {

    private Integer idusuario;
    private String nombre;
    private String apellidos;
    private String fotoempleado;
    private Integer noleido;
    private boolean tipologin;
    private String linksoporte;
    private String linkmensajes;
    private String cambiocontrasenasiaga;
    private String cambiocontrasenaad;
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

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getFotoempleado() {
        return fotoempleado;
    }

    public void setFotoempleado(String fotoempleado) {
        this.fotoempleado = fotoempleado;
    }

    public Integer getNoleido() {
        return noleido;
    }

    public void setNoleido(Integer noleido) {
        this.noleido = noleido;
    }

    public boolean isTipologin() {
        return tipologin;
    }

    public void setTipologin(boolean tipologin) {
        this.tipologin = tipologin;
    }

    public String getLinksoporte() {
        return linksoporte;
    }

    public void setLinksoporte(String linksoporte) {
        this.linksoporte = linksoporte;
    }

    public String getLinkmensajes() {
        return linkmensajes;
    }

    public void setLinkmensajes(String linkmensajes) {
        this.linkmensajes = linkmensajes;
    }

    public String getCambiocontrasenasiaga() {
        return cambiocontrasenasiaga;
    }

    public void setCambiocontrasenasiaga(String cambiocontrasenasiaga) {
        this.cambiocontrasenasiaga = cambiocontrasenasiaga;
    }

    public String getCambiocontrasenaad() {
        return cambiocontrasenaad;
    }

    public void setCambiocontrasenaad(String cambiocontrasenaad) {
        this.cambiocontrasenaad = cambiocontrasenaad;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
