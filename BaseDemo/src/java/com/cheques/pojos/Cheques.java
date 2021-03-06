package com.cheques.pojos;
// Generated Jul 6, 2022 9:15:07 AM by Hibernate Tools 3.2.1.GA

import java.math.BigDecimal;
import java.util.Date;

/**
 * Cheques generated by hbm2java
 */
public class Cheques implements java.io.Serializable {

    private Integer idcheques;
    private int idproveedor;
    private BigDecimal monto;
    private Date fecharegistro;
    private Integer estado;
    private int cuentarelacionada;
    private Integer idcreo;
    private Date fechacreacion;
    private boolean habilitado;

    public Cheques() {
    }

    public Integer getIdcheques() {
        return this.idcheques;
    }

    public void setIdcheques(Integer idcheques) {
        this.idcheques = idcheques;
    }

    public int getIdproveedor() {
        return this.idproveedor;
    }

    public void setIdproveedor(int idproveedor) {
        this.idproveedor = idproveedor;
    }

    public BigDecimal getMonto() {
        return this.monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    public Date getFecharegistro() {
        return this.fecharegistro;
    }

    public void setFecharegistro(Date fecharegistro) {
        this.fecharegistro = fecharegistro;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    public int getCuentarelacionada() {
        return this.cuentarelacionada;
    }

    public void setCuentarelacionada(int cuentarelacionada) {
        this.cuentarelacionada = cuentarelacionada;
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
