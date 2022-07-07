
package com.cheques.utils;

import java.io.PrintWriter;
import java.io.Serializable;
import java.io.StringWriter;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;


@ManagedBean
@RequestScoped
public class ErrorHandler implements Serializable {

    private String trace;

    public ErrorHandler() {
    }

    public String getStatusCode() {
        String val = String.valueOf((Integer) FacesContext.getCurrentInstance().getExternalContext().getRequestMap().get("javax.servlet.error.status_code"));
        return val;
    }

    public String getMessage() {
        String val = (String) FacesContext.getCurrentInstance().getExternalContext().getRequestMap().get("javax.servlet.error.message");
        return val;
    }

    public String getExceptionType() {

        String val = FacesContext.getCurrentInstance().getExternalContext().getRequestMap().get("javax.servlet.error.exception_type").toString();
        return val;

    }

    public String getException() {
        String val = (String) ((Exception) FacesContext.getCurrentInstance().getExternalContext().getRequestMap().get("javax.servlet.error.exception")).toString();
        return val;
    }

    public String getRequestURI() {
        return (String) FacesContext.getCurrentInstance().getExternalContext().getRequestMap().get("javax.servlet.error.request_uri");

    }

    public String getServletName() {
        return (String) FacesContext.getCurrentInstance().getExternalContext().getRequestMap().get("javax.servlet.error.servlet_name");

    }

    public String getStackTrace() {

        FacesContext context = FacesContext.getCurrentInstance();
        Map requestMap = context.getExternalContext().getRequestMap();
        Throwable ex = (Throwable) requestMap.get("javax.servlet.error.exception");

        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        ex.printStackTrace(pw);
        trace = sw.toString();

        return trace;
    }
}
