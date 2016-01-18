package com.mycompany.fabricas;

import com.mycompany.dao.UsuarioDao;
import com.mycompany.interfaces.UsuarioDaoIF;

public class DaoFactoryBD implements DaoFactoryIF {

    private DaoFactoryBD instance;

    @Override
    public UsuarioDaoIF criaUsuarioDao() {
        return new UsuarioDao();
    }
}
