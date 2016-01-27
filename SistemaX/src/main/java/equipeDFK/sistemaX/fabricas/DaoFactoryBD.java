package equipeDFK.sistemaX.fabricas;

import equipeDFK.sistemaX.dao.FeriadoDao;
import equipeDFK.sistemaX.dao.UsuarioDao;
import equipeDFK.sistemaX.interfaces.FeriadoDaoIF;
import equipeDFK.sistemaX.interfaces.UsuarioDaoIF;

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
