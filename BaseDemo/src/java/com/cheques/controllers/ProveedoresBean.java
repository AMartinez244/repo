/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cheques.controllers;

import com.cheques.models.GeneralModel;
import com.cheques.models.UsuariosModel;
import com.cheques.pojos.Proveedor;
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
public class ProveedoresBean implements Serializable {

    private HttpSession httpSession = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
    private UsuariosModel usuarioLogueado;
    private Util util = new Util();
    private Proveedor proveedor;
    private List<GeneralModel> proveedores;

    public ProveedoresBean() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            usuarioLogueado = (UsuariosModel) httpSession.getAttribute("usuarioLogueado");
            if (usuarioLogueado != null) {
                cargarProveedores(session);
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

    private void cargarProveedores(Session session) {
        proveedores = new ArrayList();
        proveedores = (List<GeneralModel>) session.createSQLQuery("SELECT p.idproveedor, p.nombre, IF ( p.tipopersona = 0, 'Física', 'Juridica' ) tipopersona, p.identificacion, format(p.balance, 2) balance, p.cuentacontable, CONCAT_WS(' ', u.nombre, u.apellidos) creador, DATE_FORMAT(p.fechacreacion, '%d-%m-%Y') fechacreacion FROM proveedor p INNER JOIN usuarios u ON u.idusuario = p.idcreo WHERE p.habilitado = 1")
                .addScalar("idproveedor", Hibernate.INTEGER)
                .addScalar("nombre", Hibernate.STRING)
                .addScalar("tipopersona", Hibernate.STRING)
                .addScalar("identificacion", Hibernate.STRING)
                .addScalar("balance", Hibernate.STRING)
                .addScalar("cuentacontable", Hibernate.STRING)
                .addScalar("creador", Hibernate.STRING)
                .addScalar("fechacreacion", Hibernate.STRING)
                .setResultTransformer(Transformers.aliasToBean(GeneralModel.class))
                .list();
    }

    public void mantenimientoProveedores(int option, Integer id, boolean habilitado) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            switch (option) {
                case 0:
                    proveedor = new Proveedor();
                    break;
                case 1:
                    proveedor.setHabilitado(habilitado);
                    proveedor.setIdcreo(usuarioLogueado.getIdusuario());
                    proveedor.setFechacreacion(new Date());
                    session.beginTransaction();
                    session.save(proveedor);
                    session.getTransaction().commit();
                    cargarProveedores(session);
                    PrimeFaces.current().executeScript("PF('dlgPro').hide();");
                    PrimeFaces.current().executeScript("PF('dt_pro').clearFilters();");
                    Alertas.desplegarMensaje((byte) 1, "Guardado correctamente.", "");
                    break;
                case 2:
                    proveedor = (Proveedor) session.get(Proveedor.class, id);
                    break;
                case 3:
                    proveedor.setHabilitado(habilitado);
                    session.beginTransaction();
                    session.update(proveedor);
                    session.getTransaction().commit();
                    cargarProveedores(session);
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

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public List<GeneralModel> getProveedores() {
        return proveedores;
    }

    public void setProveedores(List<GeneralModel> proveedores) {
        this.proveedores = proveedores;
    }
}
