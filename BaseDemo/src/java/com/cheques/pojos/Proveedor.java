package com.cheques.pojos;
// Generated Jul 6, 2022 9:15:07 AM by Hibernate Tools 3.2.1.GA

import java.math.BigDecimal;
import java.util.Date;

/**
 * Proveedor generated by hbm2java
 */
public class Proveedor implements java.io.Serializable {

    private Integer idproveedor;
    private String nombre;
    private Integer tipopersona;
    private String identificacion;
    private BigDecimal balance;
    private int cuentacontable;
    private boolean estado;
    private Integer idcreo;
    private Date fechacreacion;
    private boolean habilitado;

    public Proveedor() {
    }

  

    public Integer getIdproveedor() {
        return this.idproveedor;
    }

    public void setIdproveedor(Integer idproveedor) {
        this.idproveedor = idproveedor;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getTipopersona() {
        return tipopersona;
    }

    public void setTipopersona(Integer tipopersona) {
        this.tipopersona = tipopersona;
    }

   
    public String getIdentificacion() {
        return this.identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public BigDecimal getBalance() {
        return this.balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public int getCuentacontable() {
        return this.cuentacontable;
    }

    public void setCuentacontable(int cuentacontable) {
        this.cuentacontable = cuentacontable;
    }

    public boolean isEstado() {
        return this.estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public boolean isHabilitado() {
        return this.habilitado;
    }

    public void setHabilitado(boolean habilitado) {
        this.habilitado = habilitado;
    }

    public Integer getIdcreo() {
        return idcreo;
    }

    public void setIdcreo(Integer idcreo) {
        this.idcreo = idcreo;
    }

    public Date getFechacreacion() {
        return fechacreacion;
    }

    public void setFechacreacion(Date fechacreacion) {
        this.fechacreacion = fechacreacion;
    }
    
}