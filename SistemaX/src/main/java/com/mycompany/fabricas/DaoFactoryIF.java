package com.mycompany.fabricas;

import com.mycompany.interfaces.UsuarioDaoIF;

public interface DaoFactoryIF {

    public UsuarioDaoIF criaUsuarioDao();

}
