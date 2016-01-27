package equipeDFK.fabricas;

import equipeDFK.dao.FeriadoDao;
import equipeDFK.dao.UsuarioDao;
import equipeDFK.interfaces.FeriadoDaoIF;
import equipeDFK.interfaces.UsuarioDaoIF;

public class DaoFactoryBD implements DaoFactoryIF {

    private DaoFactoryBD instance;

    @Override
    public UsuarioDaoIF criaUsuarioDao() {
        return new UsuarioDao();
    }

    
    /**
     * 
     * @return 
     */
    @Override
    public FeriadoDaoIF criaFeriadoDao() {
        return new FeriadoDao();
    }
}
