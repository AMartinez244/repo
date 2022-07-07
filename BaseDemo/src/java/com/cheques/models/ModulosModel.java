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
public class ModulosModel implements Serializable {

    private String descripcion;
    private String url;
    private String ayuda;
    private String iconame;

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getAyuda() {
        return ayuda;
    }

    public void setAyuda(String ayuda) {
        this.ayuda = ayuda;
    }

    public String getIconame() {
        return iconame;
    }

    public void setIconame(String iconame) {
        this.iconame = iconame;
    }
}
