package equipeDFK.sistemaX.fabricas;

public class DaoFactory {
    public static DaoFactoryIF creatFactory(){
        return new DaoFactoryBD();
    }
}