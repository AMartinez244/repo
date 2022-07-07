/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cheques.controllers;

import com.cheques.models.Menu;
import com.cheques.models.UsuariosModel;
import com.cheques.service.IUsuarioModelServ;
import com.cheques.service.UsuarioModelServImpl;
import com.cheques.utils.Alertas;
import com.cheques.utils.HibernateUtil;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.primefaces.context.PrimeFacesContext;

/**
 *
 * @author IDAC
 */
@ManagedBean
@ViewScoped
public class LoginBean implements Serializable {

    private String txtUsuario;
    private String txtClave;
    private HttpSession httpSession;
    private UsuariosModel usuarioLogueado;
    private Menu menu;
    private String ip;
    private List<Object[]> listUnidadMedida;

    public LoginBean() {
        usuarioLogueado = new UsuariosModel();
        httpSession = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
    }

    public void btnLogin() {
        if (!txtUsuario.isEmpty() && (!txtClave.isEmpty())) {
            Session session = HibernateUtil.getSessionFactory().openSession();
            try {
                IUsuarioModelServ service = new UsuarioModelServImpl();
                usuarioLogueado = service.validarUsuario(session, txtUsuario, txtClave, null, null, false, ip);
                if (usuarioLogueado != null) {
                    menu = new Menu(service.cargarModulosDelUsuario(session, usuarioLogueado.getIdusuario()));
                    httpSession.setAttribute("usuarioLogueado", usuarioLogueado);
                    httpSession.setAttribute("menu", menu);
                    FacesContext.getCurrentInstance().getExternalContext().redirect("principal.xhtml");

                } else {
                    Alertas.desplegarMensaje((byte) 0, "El usuario y/o contraseña suministrados son incorrectos. Inténtelo nuevamente.", "");
                }
            } catch (Exception e) {
                Logger.getLogger(LoginBean.class.getName()).log(Level.SEVERE, "Error al loguear al usuario", e);
            } finally {
                if (session.isOpen()) {
                    session.close();
                    session.getSessionFactory().close();
                }
            }
        } else {
            Alertas.desplegarMensaje((byte) 0, "Debe llenar todos los campos.", "");
        }
    }

    public boolean paramLogin(String user, String secreto) {
        if (!user.isEmpty() && (!secreto.isEmpty())) {
            Session session = HibernateUtil.getSessionFactory().openSession();
            try {
                IUsuarioModelServ service = new UsuarioModelServImpl();
                usuarioLogueado = service.validarUsuario(session, null, null, user, secreto, true, ip);
                if (usuarioLogueado != null) {
                    menu = new Menu(service.cargarModulosDelUsuario(session, usuarioLogueado.getIdusuario()));
                    httpSession.setAttribute("usuarioLogueado", usuarioLogueado);
                    httpSession.setAttribute("menu", menu);
                    FacesContext.getCurrentInstance().getExternalContext().redirect("principal.xhtml");
                    return true;
                } else {
                    return false;
                }
            } catch (Exception e) {
                Logger.getLogger(LoginBean.class.getName()).log(Level.SEVERE, "Error al loguear al usuario", e);
            } finally {
                if (session.isOpen()) {
                    session.close();
                    session.getSessionFactory().close();
                }
            }
        }
        return false;
    }

    public void cerrarSesion() {
        try {
            FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
            PrimeFacesContext.getCurrentInstance().getExternalContext().redirect("login.xhtml");
        } catch (IOException e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "Error al cerrar la session del usurio", e);
        }
    }

    public String getTxtUsuario() {
        return txtUsuario;
    }

    public void setTxtUsuario(String txtUsuario) {
        this.txtUsuario = txtUsuario;
    }

    public String getTxtClave() {
        return txtClave;
    }

    public void setTxtClave(String txtClave) {
        this.txtClave = txtClave;
    }

    public UsuariosModel getUsuarioLogueado() {
        return (UsuariosModel) httpSession.getAttribute("usuarioLogueado");
    }

    public void setUsuarioLogueado(UsuariosModel usuarioLogueado) {
        this.usuarioLogueado = usuarioLogueado;
    }

    public Menu getMenu() {
        return (Menu) httpSession.getAttribute("menu");
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public List<Object[]> getListUnidadMedida() {
        return listUnidadMedida;
    }

    public void setListUnidadMedida(List<Object[]> listUnidadMedida) {
        this.listUnidadMedida = listUnidadMedida;
    }
}
