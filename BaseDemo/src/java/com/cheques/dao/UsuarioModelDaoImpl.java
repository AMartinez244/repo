
package com.cheques.dao;

import com.cheques.models.ModulosModel;
import com.cheques.models.UsuariosModel;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.transform.Transformers;


public class UsuarioModelDaoImpl implements Serializable, IUsuarioModelDao {

    

    @Override
    public UsuariosModel cargarUsuarioSiaga(Session session, String username, String contrasena) {
        UsuariosModel u = new UsuariosModel();
        try {
            u = (UsuariosModel) session.createSQLQuery("SELECT u.idusuario, u.nombre, u.apellidos, u.username FROM usuarios u LEFT JOIN personal e ON e.idpersonal = u.idpersonal WHERE u.habilitado = 1 AND u.username = '" + username + "' AND u.clave = MD5(" + contrasena + ") GROUP BY u.idusuario")
                    .addScalar("idusuario", Hibernate.INTEGER)
                    .addScalar("nombre", Hibernate.STRING)
                    .addScalar("apellidos", Hibernate.STRING)
                    .addScalar("username", Hibernate.STRING)
                    .setResultTransformer(Transformers.aliasToBean(UsuariosModel.class)).uniqueResult();
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "Error al cargar datos del usuario", e);
        }

        return u;
    }


    @Override
    public List<ModulosModel> cargarModulosDelUsuario(Session session, Integer idusuario) {
        List<ModulosModel> r = new ArrayList();

        try {
            r = (List<ModulosModel>) session.createSQLQuery("SELECT descripcion, url, ayuda, iconame FROM usuarios u INNER JOIN usuariosperfiles up ON up.idusuario = u.idusuario AND up.habilitado = 1 INNER JOIN perfilmodulo pm ON pm.idperfil = up.idperfil AND pm.habilitado = 1 INNER JOIN modulos m ON m.idmodulo = pm.idmodulo AND m.habilitado = 1 AND LENGTH(trim(m.url)) > 0 WHERE u.habilitado = 1 AND m.idsistema = 96 AND u.idusuario = :idusuario GROUP BY m.idmodulo ORDER BY orden")
                    .addScalar("descripcion", Hibernate.STRING)
                    .addScalar("url", Hibernate.STRING)
                    .addScalar("ayuda", Hibernate.STRING)
                    .addScalar("iconame", Hibernate.STRING)
                    .setParameter("idusuario", idusuario)
                    .setResultTransformer(Transformers.aliasToBean(ModulosModel.class)).list();
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "Error al cargar modulos del usuario", e);
        }

        return r;
    }
}
