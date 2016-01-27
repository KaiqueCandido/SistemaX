package equipeDFK.fabricas;

import equipeDFK.interfaces.FeriadoDaoIF;
import equipeDFK.interfaces.UsuarioDaoIF;

public interface DaoFactoryIF {

    public UsuarioDaoIF criaUsuarioDao();
    
    public FeriadoDaoIF criaFeriadoDao();

}
