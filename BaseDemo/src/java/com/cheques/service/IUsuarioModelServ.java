
package com.cheques.service;

import com.cheques.models.ModulosModel;
import com.cheques.models.UsuariosModel;
import java.util.List;
import org.hibernate.Session;

public interface IUsuarioModelServ {
     public UsuariosModel validarUsuario(Session session, String txtUsuario, String txtClave, String user, String secreto, boolean esPorParametros, String ip);
     public List<ModulosModel> cargarModulosDelUsuario(Session session, Integer idusuario);
}
