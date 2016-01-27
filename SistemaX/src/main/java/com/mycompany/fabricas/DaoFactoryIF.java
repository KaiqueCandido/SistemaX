package com.mycompany.fabricas;

import com.mycompany.interfaces.FeriadoDaoIF;
import com.mycompany.interfaces.UsuarioDaoIF;

public interface DaoFactoryIF {

    public UsuarioDaoIF criaUsuarioDao();
    
    public FeriadoDaoIF criaFeriadoDao();

}
