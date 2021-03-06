package com.cheques.pojos;
// Generated Dec 20, 2016 2:19:08 PM by Hibernate Tools 3.2.1.GA


import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Documentos generated by hbm2java
 */
@Entity
@Table(name="documentos"
    ,catalog="siaga"
)
public class Documentos  implements java.io.Serializable {

     private Integer iddocumentos;
     private String descripcion;
     private Integer idclasificaciondoc;
     private Date fechamodificacion;
     private boolean habilitado;

    public Documentos() {
    }

	
    public Documentos(String descripcion, boolean habilitado) {
        this.descripcion = descripcion;
        this.habilitado = habilitado;
    }
    public Documentos(String descripcion, Integer idclasificaciondoc, Date fechamodificacion, boolean habilitado) {
       this.descripcion = descripcion;
       this.idclasificaciondoc = idclasificaciondoc;
       this.fechamodificacion = fechamodificacion;
       this.habilitado = habilitado;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)
    
    @Column(name="iddocumentos", unique=true, nullable=false)
    public Integer getIddocumentos() {
        return this.iddocumentos;
    }
    
    public void setIddocumentos(Integer iddocumentos) {
        this.iddocumentos = iddocumentos;
    }
    
    @Column(name="descripcion", nullable=false, length=250)
    public String getDescripcion() {
        return this.descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    @Column(name="idclasificaciondoc")
    public Integer getIdclasificaciondoc() {
        return this.idclasificaciondoc;
    }
    
    public void setIdclasificaciondoc(Integer idclasificaciondoc) {
        this.idclasificaciondoc = idclasificaciondoc;
    }
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="fechamodificacion", length=19)
    public Date getFechamodificacion() {
        return this.fechamodificacion;
    }
    
    public void setFechamodificacion(Date fechamodificacion) {
        this.fechamodificacion = fechamodificacion;
    }
    
    @Column(name="habilitado", nullable=false)
    public boolean isHabilitado() {
        return this.habilitado;
    }
    
    public void setHabilitado(boolean habilitado) {
        this.habilitado = habilitado;
    }




}


