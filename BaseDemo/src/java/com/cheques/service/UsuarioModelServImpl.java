package com.cheques.service;

import com.cheques.dao.IUsuarioModelDao;
import com.cheques.dao.UsuarioModelDaoImpl;
import com.cheques.models.ModulosModel;
import com.cheques.models.UsuariosModel;
import java.io.Serializable;
import java.util.List;
import org.hibernate.Session;


public class UsuarioModelServImpl implements Serializable, IUsuarioModelServ {

    private IUsuarioModelDao usuarioModelDao;

    public UsuarioModelServImpl() {
        usuarioModelDao = new UsuarioModelDaoImpl();
    }

    @Override
    public UsuariosModel validarUsuario(Session session, String txtUsuario, String txtClave, String user, String secreto, boolean esPorParametros, String ip) {
        UsuariosModel u = null;
           u = usuarioModelDao.cargarUsuarioSiaga(session, txtUsuario, txtClave);
        return u;
    }

    @Override
    public List<ModulosModel> cargarModulosDelUsuario(Session session, Integer idusuario) {
        return usuarioModelDao.cargarModulosDelUsuario(session, idusuario);
    }

   
}
