/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cheques.models;

import java.io.Serializable;

/**
 *
 * @author Administrator
 */
public class GeneralModel implements Serializable {

    private Integer idconceptopago;
    private String descripcion;
    private String estado;
    private String creador;
    private String fechacreacion;
    private Integer idproveedor;
    private String nombre;
    private String tipopersona;
    private String identificacion;
    private String balance;
    private String cuentacontable;
    private Integer idcheques;
    private String proveedor;
    private String monto;
    private String fecharegistro;
    private String cuentarelacionada;

    public GeneralModel() {
    }

    public Integer getIdconceptopago() {
        return idconceptopago;
    }

    public void setIdconceptopago(Integer idconceptopago) {
        this.idconceptopago = idconceptopago;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCreador() {
        return creador;
    }

    public void setCreador(String creador) {
        this.creador = creador;
    }

    public String getFechacreacion() {
        return fechacreacion;
    }

    public void setFechacreacion(String fechacreacion) {
        this.fechacreacion = fechacreacion;
    }

    public Integer getIdproveedor() {
        return idproveedor;
    }

    public void setIdproveedor(Integer idproveedor) {
        this.idproveedor = idproveedor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipopersona() {
        return tipopersona;
    }

    public void setTipopersona(String tipopersona) {
        this.tipopersona = tipopersona;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public String getCuentacontable() {
        return cuentacontable;
    }

    public void setCuentacontable(String cuentacontable) {
        this.cuentacontable = cuentacontable;
    }

    public Integer getIdcheques() {
        return idcheques;
    }

    public void setIdcheques(Integer idcheques) {
        this.idcheques = idcheques;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    public String getMonto() {
        return monto;
    }

    public void setMonto(String monto) {
        this.monto = monto;
    }

    public String getFecharegistro() {
        return fecharegistro;
    }

    public void setFecharegistro(String fecharegistro) {
        this.fecharegistro = fecharegistro;
    }

    public String getCuentarelacionada() {
        return cuentarelacionada;
    }

    public void setCuentarelacionada(String cuentarelacionada) {
        this.cuentarelacionada = cuentarelacionada;
    }
    
}
