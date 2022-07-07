package com.cheques.pojos;
// Generated 03/31/2021 12:13:54 PM by Hibernate Tools 3.2.1.GA

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Usuarios generated by hbm2java
 */
public class Usuarios implements java.io.Serializable {

    private Integer idusuario;
    private Integer idempleadoidac;
    private String username;
    private String clave;
    private String nombre;
    private String apellidos;
    private int area;
    private String telefono;
    private String mail;
    private String direccion;
    private String secreto;
    private boolean habilitado;
    private Date fechacreacion;
    private Date fechamodificacion;
    private Integer idcreador;
    private Integer idmodifico;
    private Integer iddocumentosoporte;
    private Date proximocambiocontrasena;
    private String extension;
    private String celular;
    private String mailalterno;
    private Integer idusuariofirma;
    private String titulo;
    private String siglasparacarta;
    private Set usuarioaccesos = new HashSet(0);

    public Usuarios() {
    }

    public Usuarios(Integer idusuario) {
        this.idusuario = idusuario;
    }

    public Usuarios(String username, String nombre, String apellidos, int area, boolean habilitado) {
        this.username = username;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.area = area;
        this.habilitado = habilitado;
    }

    public Usuarios(Integer idempleadoidac, String username, String clave, String nombre, String apellidos, int area, String telefono, String mail, String direccion, String secreto, boolean habilitado, Date fechacreacion, Date fechamodificacion, Integer idcreador, Integer idmodifico, Integer iddocumentosoporte, Date proximocambiocontrasena, String extension, String celular, String mailalterno, Integer idusuariofirma, String titulo, String siglasparacarta, Set usuarioaccesos) {
        this.idempleadoidac = idempleadoidac;
        this.username = username;
        this.clave = clave;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.area = area;
        this.telefono = telefono;
        this.mail = mail;
        this.direccion = direccion;
        this.secreto = secreto;
        this.habilitado = habilitado;
        this.fechacreacion = fechacreacion;
        this.fechamodificacion = fechamodificacion;
        this.idcreador = idcreador;
        this.idmodifico = idmodifico;
        this.iddocumentosoporte = iddocumentosoporte;
        this.proximocambiocontrasena = proximocambiocontrasena;
        this.extension = extension;
        this.celular = celular;
        this.mailalterno = mailalterno;
        this.idusuariofirma = idusuariofirma;
        this.titulo = titulo;
        this.siglasparacarta = siglasparacarta;
        this.usuarioaccesos = usuarioaccesos;
    }

    public Integer getIdusuario() {
        return this.idusuario;
    }

    public void setIdusuario(Integer idusuario) {
        this.idusuario = idusuario;
    }

    public Integer getIdempleadoidac() {
        return this.idempleadoidac;
    }

    public void setIdempleadoidac(Integer idempleadoidac) {
        this.idempleadoidac = idempleadoidac;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getClave() {
        return this.clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return this.apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getArea() {
        return this.area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public String getTelefono() {
        return this.telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getMail() {
        return this.mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getDireccion() {
        return this.direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getSecreto() {
        return this.secreto;
    }

    public void setSecreto(String secreto) {
        this.secreto = secreto;
    }

    public boolean isHabilitado() {
        return this.habilitado;
    }

    public void setHabilitado(boolean habilitado) {
        this.habilitado = habilitado;
    }

    public Date getFechacreacion() {
        return this.fechacreacion;
    }

    public void setFechacreacion(Date fechacreacion) {
        this.fechacreacion = fechacreacion;
    }

    public Date getFechamodificacion() {
        return this.fechamodificacion;
    }

    public void setFechamodificacion(Date fechamodificacion) {
        this.fechamodificacion = fechamodificacion;
    }

    public Integer getIdcreador() {
        return this.idcreador;
    }

    public void setIdcreador(Integer idcreador) {
        this.idcreador = idcreador;
    }

    public Integer getIdmodifico() {
        return this.idmodifico;
    }

    public void setIdmodifico(Integer idmodifico) {
        this.idmodifico = idmodifico;
    }

    public Integer getIddocumentosoporte() {
        return this.iddocumentosoporte;
    }

    public void setIddocumentosoporte(Integer iddocumentosoporte) {
        this.iddocumentosoporte = iddocumentosoporte;
    }

    public Date getProximocambiocontrasena() {
        return this.proximocambiocontrasena;
    }

    public void setProximocambiocontrasena(Date proximocambiocontrasena) {
        this.proximocambiocontrasena = proximocambiocontrasena;
    }

    public String getExtension() {
        return this.extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public String getCelular() {
        return this.celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getMailalterno() {
        return this.mailalterno;
    }

    public void setMailalterno(String mailalterno) {
        this.mailalterno = mailalterno;
    }

    public Integer getIdusuariofirma() {
        return this.idusuariofirma;
    }

    public void setIdusuariofirma(Integer idusuariofirma) {
        this.idusuariofirma = idusuariofirma;
    }

    public String getTitulo() {
        return this.titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getSiglasparacarta() {
        return this.siglasparacarta;
    }

    public void setSiglasparacarta(String siglasparacarta) {
        this.siglasparacarta = siglasparacarta;
    }

    public Set getUsuarioaccesos() {
        return this.usuarioaccesos;
    }

    public void setUsuarioaccesos(Set usuarioaccesos) {
        this.usuarioaccesos = usuarioaccesos;
    }
}
