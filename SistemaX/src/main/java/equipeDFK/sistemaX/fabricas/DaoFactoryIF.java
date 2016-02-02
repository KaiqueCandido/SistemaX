package equipeDFK.sistemaX.fabricas;

import equipeDFK.sistemaX.interfaces.FeriadoDaoIF;
import equipeDFK.sistemaX.interfaces.UsuarioDaoIF;

/**
 * Interface Fabrica de DAO
 * @author Dijalma Silva <dijalmacz@gmail.com>
 */
public interface DaoFactoryIF {

    public UsuarioDaoIF criaUsuarioDao();
    
    public FeriadoDaoIF criaFeriadoDao();

}
