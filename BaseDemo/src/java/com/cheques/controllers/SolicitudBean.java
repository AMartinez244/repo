/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cheques.controllers;

import com.cheques.models.GeneralModel;
import com.cheques.models.UsuariosModel;
import com.cheques.pojos.Cheques;

import com.cheques.utils.Alertas;
import com.cheques.utils.HibernateUtil;
import com.cheques.utils.Util;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.servlet.http.HttpSession;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.transform.Transformers;
import org.primefaces.PrimeFaces;

/**
 *
 * @author Administrator
 */
@ManagedBean
@ViewScoped
public class SolicitudBean implements Serializable {

    private HttpSession httpSession = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
    private UsuariosModel usuarioLogueado;
    private Util util = new Util();
    private Cheques cheques;
    private List<GeneralModel> solicitudes;
    private List<SelectItem> proveedores;

    public SolicitudBean() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            usuarioLogueado = (UsuariosModel) httpSession.getAttribute("usuarioLogueado");
            if (usuarioLogueado != null) {
                cargarSolicitudes(session);
            }
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "Error al cargar los datos", e);
        } finally {
            if (session.isOpen()) {
                session.close();
                session.getSessionFactory().close();
            }
        }
    }

    private void cargarSolicitudes(Session session) {
        solicitudes = new ArrayList();
        solicitudes = (List<GeneralModel>) session.createSQLQuery("SELECT c.idcheques, p.nombre proveedor, format(c.monto, 2) monto, DATE_FORMAT(c.fecharegistro, '%d-%m-%Y') fecharegistro, CASE WHEN c.estado = 0 THEN 'Anulado' WHEN c.estado = 1 THEN 'Pendiente' WHEN c.estado = 2 THEN 'Cheque Generado'  END estado, c.cuentarelacionada, CONCAT_WS(' ', u.nombre, u.apellidos) creador, DATE_FORMAT(c.fechacreacion, '%d-%m-%Y') fechacreacion FROM cheques c INNER JOIN proveedor p ON p.idproveedor = c.idproveedor INNER JOIN usuarios u ON u.idusuario = c.idcreo WHERE c.habilitado = 1")
                .addScalar("idcheques", Hibernate.INTEGER)
                .addScalar("proveedor", Hibernate.STRING)
                .addScalar("monto", Hibernate.STRING)
                .addScalar("fecharegistro", Hibernate.STRING)
                .addScalar("estado", Hibernate.STRING)
                .addScalar("cuentarelacionada", Hibernate.STRING)
                .addScalar("creador", Hibernate.STRING)
                .addScalar("fechacreacion", Hibernate.STRING)
                .setResultTransformer(Transformers.aliasToBean(GeneralModel.class))
                .list();
    }

    public void mantenimientoSolicitud(int option, Integer id, boolean habilitado) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            switch (option) {
                case 0:
                    cheques = new Cheques();
                    cargarProveedores(session);
                    break;
                case 1:
                    cheques.setEstado(1);
                    cheques.setHabilitado(habilitado);
                    cheques.setIdcreo(usuarioLogueado.getIdusuario());
                    cheques.setFechacreacion(new Date());
                    session.beginTransaction();
                    session.save(cheques);
                    session.getTransaction().commit();
                    cargarSolicitudes(session);
                     PrimeFaces.current().executeScript("PF('dlgPro').hide();");
                    PrimeFaces.current().executeScript("PF('dt_pro').clearFilters();");
                    Alertas.desplegarMensaje((byte) 1, "Guardado correctamente.", "");
                    break;
                case 2:
                    cargarProveedores(session);
                    cheques = (Cheques) session.get(Cheques.class, id);
                    break;
                case 3:
                    cheques.setEstado(id);
                    cheques.setHabilitado(habilitado);
                    session.beginTransaction();
                    session.update(cheques);
                    session.getTransaction().commit();
                    cargarSolicitudes(session);
                 PrimeFaces.current().executeScript("PF('dlgPro').hide();");
                    PrimeFaces.current().executeScript("PF('dt_pro').clearFilters();");
                    Alertas.desplegarMensaje((byte) 1, "Cambios realizados correctamente.", "");
                    break;
            }
        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            if (session.isOpen()) {
                session.close();
                session.getSessionFactory().close();
            }
        }
    }

    private void cargarProveedores(Session session) {
        proveedores = new ArrayList();
        List<Object[]> lista = (List<Object[]>) session.createSQLQuery("SELECT p.idproveedor, p.nombre FROM proveedor p WHERE p.habilitado = 1")
                .addScalar("idproveedor", Hibernate.STRING)
                .addScalar("nombre", Hibernate.STRING)
                .list();
        proveedores = util.fillSelectItemFromList(lista);
    }

    public List<SelectItem> getProveedores() {
        return proveedores;
    }

    public void setProveedores(List<SelectItem> proveedores) {
        this.proveedores = proveedores;
    }

    public Cheques getCheques() {
        return cheques;
    }

    public void setCheques(Cheques cheques) {
        this.cheques = cheques;
    }

    public List<GeneralModel> getSolicitudes() {
        return solicitudes;
    }

    public void setSolicitudes(List<GeneralModel> solicitudes) {
        this.solicitudes = solicitudes;
    }
}
