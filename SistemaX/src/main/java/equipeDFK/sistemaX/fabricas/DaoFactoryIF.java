package equipeDFK.sistemaX.fabricas;

import equipeDFK.sistemaX.interfaces.FeriadoDaoIF;
import equipeDFK.sistemaX.interfaces.UsuarioDaoIF;

public interface DaoFactoryIF {

    public UsuarioDaoIF criaUsuarioDao();
    
    public FeriadoDaoIF criaFeriadoDao();

}
