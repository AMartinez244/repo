
package com.cheques.utils;

import com.cheques.controllers.LoginBean;
import com.cheques.models.UsuariosModel;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.NavigationHandler;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import javax.servlet.http.HttpSession;


public class AuthorizationListener implements PhaseListener {

    public void afterPhase(PhaseEvent event) {
        FacesContext facesContext = event.getFacesContext();
        String currentPage = facesContext.getViewRoot().getViewId();
        System.out.println("Current Page: " + currentPage);
        Map<String, String> requestMap = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        //Estas son las paginas del proyecto a las que se puede acceder sin autentificacion
        boolean pagesWithFreeAccess = ((currentPage.lastIndexOf("login.xhtml") > -1)
                || (currentPage.lastIndexOf("404.xhtml") > -1)
                || (currentPage.lastIndexOf("500.xhtml") > -1)
                || (currentPage.lastIndexOf("noexiste.xhtml") > -1));
        HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);

        String user = requestMap.get("u");
        String secreto = requestMap.get("p");
     

        if (session == null) {
            NavigationHandler nh = facesContext.getApplication().getNavigationHandler();
            nh.handleNavigation(facesContext, null, "loginPage");
            System.out.println("Session null");
        } else {

            if (!pagesWithFreeAccess) {
                UsuariosModel usuario_logueado = (UsuariosModel) session.getAttribute("usuarioLogueado");

                if (usuario_logueado == null) {
                    NavigationHandler nh = facesContext.getApplication().getNavigationHandler();
                    nh.handleNavigation(facesContext, null, "loginPage");
                    System.out.println("Usuario no logueado.");
                }
            } else if (user != null && secreto != null) {
                try {
                    Boolean logueado = new LoginBean().paramLogin(user, secreto);
                    if (logueado == false) {
                        NavigationHandler nh = facesContext.getApplication().getNavigationHandler();
                        nh.handleNavigation(facesContext, null, "loginPage");
                    }
                } catch (Exception ex) {
                    Logger.getLogger(AuthorizationListener.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public void beforePhase(PhaseEvent event) {
    }

    public PhaseId getPhaseId() {
        return PhaseId.RESTORE_VIEW;
    }
}
