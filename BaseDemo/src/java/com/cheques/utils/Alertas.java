
package com.cheques.utils;

import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.primefaces.PrimeFaces;

public class Alertas implements Serializable{
    
    
    public static void desplegarMensaje(byte severidad, String resumen, String detalle) {
        FacesMessage fm = new FacesMessage();
        switch (severidad) {
            case 0: {
                fm = new FacesMessage(FacesMessage.SEVERITY_WARN, resumen, detalle);
                break;
            }
            case 1: {
                fm = new FacesMessage(FacesMessage.SEVERITY_INFO, resumen, detalle);
                break;
            }
            case 2: {
                fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, resumen, detalle);
                break;
            }
        }

        FacesContext.getCurrentInstance().addMessage(null, fm);
    }

    public static void desplegarMensajeJS(byte severidad, String detalle) {
    
        switch (severidad) {
            case 0: {
                PrimeFaces.current().executeScript("swal({title: 'Advertencia', text:'" + detalle + "', type: 'warning'})");
                break;
            }
            case 1: {
                PrimeFaces.current().executeScript("swal({title:'Confirmación', text:'" + detalle + "', type: 'success'})");
                break;
            }
            case 2: {
                PrimeFaces.current().executeScript("swal({title:'Error', text:'" + detalle + "', type: 'error'})");
                break;
            }

            case 3: {
                PrimeFaces.current().executeScript("swal({title:'Información', text:'" + detalle + "', type: 'info'})");
                break;
            }
        }
    }
    
}
