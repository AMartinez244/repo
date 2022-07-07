
package com.cheques.dao;
import com.cheques.models.ModulosModel;
import com.cheques.models.UsuariosModel;
import java.util.List;
import org.hibernate.Session;

public interface IUsuarioModelDao {
    public UsuariosModel cargarUsuarioSiaga(Session session, String username, String contrasena);
    public List<ModulosModel> cargarModulosDelUsuario(Session session, Integer idusuario);
}
