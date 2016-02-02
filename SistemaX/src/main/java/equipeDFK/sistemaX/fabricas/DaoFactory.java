package equipeDFK.sistemaX.fabricas;

/**
 * Fabrica de {@linkplain DaoFactoryIF}
 * @author Dijalma Silva <dijalmacz@gmail.com>
 */
public class DaoFactory {
    
    /**
     * Retorna uma instância de {@linkplain DaoFactoryIF}
     * @return {@linkplain DaoFactoryBD}
     */
    public static DaoFactoryIF creatFactory(){
        return new DaoFactoryBD();
    }
}
