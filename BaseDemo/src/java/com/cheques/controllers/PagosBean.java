/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cheques.controllers;

import com.cheques.models.GeneralModel;
import com.cheques.models.UsuariosModel;
import com.cheques.pojos.Conceptopago;
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
public class PagosBean implements Serializable {

    private HttpSession httpSession = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
    private UsuariosModel usuarioLogueado;
    private Util util = new Util();
    private Conceptopago conceptoPago;
    private List<GeneralModel> conceptos;

    public PagosBean() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            usuarioLogueado = (UsuariosModel) httpSession.getAttribute("usuarioLogueado");
            if (usuarioLogueado != null) {
                cargarConceptosPagos(session);
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

    private void cargarConceptosPagos(Session session) {
        conceptos = new ArrayList();
        conceptos = (List<GeneralModel>) session.createSQLQuery("SELECT c.idconceptopago, c.descripcion, CASE WHEN c.estado = 1 THEN 'Solicitado' WHEN c.estado = 2 THEN 'Aprobado' WHEN c.estado = 3 THEN 'Declinado' END estado, CONCAT_WS(' ', u.nombre, u.apellidos) creador, DATE_FORMAT(c.fechacreacion, '%d-%m-%Y') fechacreacion FROM conceptopago c INNER JOIN usuarios u ON u.idusuario = c.idcreo WHERE c.habilitado = 1")
                .addScalar("idconceptopago", Hibernate.INTEGER)
                .addScalar("descripcion", Hibernate.STRING)
                .addScalar("estado", Hibernate.STRING)
                .addScalar("creador", Hibernate.STRING)
                .addScalar("fechacreacion", Hibernate.STRING)
                .setResultTransformer(Transformers.aliasToBean(GeneralModel.class))
                .list();
    }

    public void mantenimientoPagos(int option, Integer id, boolean habilitado) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            switch (option) {
                case 0:
                    conceptoPago = new Conceptopago();
                    break;
                case 1:
                    conceptoPago.setHabilitado(habilitado);
                    conceptoPago.setEstado(1);
                    conceptoPago.setIdcreo(usuarioLogueado.getIdusuario());
                    conceptoPago.setFechacreacion(new Date());
                    session.beginTransaction();
                    session.save(conceptoPago);
                    session.getTransaction().commit();
                    cargarConceptosPagos(session);
                    PrimeFaces.current().executeScript("PF('dlgPag').hide();");
                    PrimeFaces.current().executeScript("PF('dt_pag').clearFilters();");
                    Alertas.desplegarMensaje((byte) 1, "Guardado correctamente.", "");
                    break;
                case 2:
                    conceptoPago = (Conceptopago) session.get(Conceptopago.class, id);
                    break;
                case 3:
                    conceptoPago.setHabilitado(habilitado);
                    session.beginTransaction();
                    session.update(conceptoPago);
                    session.getTransaction().commit();
                    cargarConceptosPagos(session);
                    PrimeFaces.current().executeScript("PF('dlgPag').hide();");
                    PrimeFaces.current().executeScript("PF('dt_pag').clearFilters();");
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

    public Conceptopago getConceptoPago() {
        return conceptoPago;
    }

    public void setConceptoPago(Conceptopago conceptoPago) {
        this.conceptoPago = conceptoPago;
    }

    public List<GeneralModel> getConceptos() {
        return conceptos;
    }

    public void setConceptos(List<GeneralModel> conceptos) {
        this.conceptos = conceptos;
    }
}
