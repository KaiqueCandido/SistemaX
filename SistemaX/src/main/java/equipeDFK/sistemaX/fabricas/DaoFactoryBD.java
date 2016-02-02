package equipeDFK.sistemaX.fabricas;

import equipeDFK.sistemaX.dao.FeriadoDao;
import equipeDFK.sistemaX.dao.UsuarioDao;
import equipeDFK.sistemaX.interfaces.FeriadoDaoIF;
import equipeDFK.sistemaX.interfaces.UsuarioDaoIF;

/**
 *  Classe DaoFactoryBD que implementa a interface @{@linkplain DaoFactoryIF}
 * @author Dijalma Silva <dijalmacz@gmail.com>
 */
public class DaoFactoryBD implements DaoFactoryIF {

    
    /**
     * Retorna uma instância de {@linkplain UsuarioDao}
     * @return {@linkplain UsuarioDao}
     */
    @Override
    public UsuarioDaoIF criaUsuarioDao() {
        return new UsuarioDao();
    }

    
    /**
     * Retorna uma instância de {@linkplain FeriadoDao}
     * @return {@linkplain FeriadoDao}
     */
    @Override
    public FeriadoDaoIF criaFeriadoDao() {
        return new FeriadoDao();
    }
}
