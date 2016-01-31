/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package equipeDFK.sistemaX.gerenciadores;

import equipeDFK.sistemaX.entidades.Feriado;
import equipeDFK.sistemaX.fabricas.DaoFactory;
import equipeDFK.sistemaX.fabricas.DaoFactoryIF;
import equipeDFK.sistemaX.interfaces.FeriadoDaoIF;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author NandaPC
 */
public class GerenciadorDeFeriado {

    /**
     *
     * @param feriado
     * @return
     * @throws SQLException
     */
    public boolean cadastrar(Feriado feriado) throws SQLException {
        DaoFactoryIF fabrica = DaoFactory.creatFactory();
        FeriadoDaoIF feriadoDao = fabrica.criaFeriadoDao();
        return feriadoDao.cadastrar(feriado);
    }

    /**
     *
     * @param feriado
     * @throws SQLException
     */
    public void remover(Feriado feriado) throws SQLException {
        DaoFactoryIF fabrica = DaoFactory.creatFactory();
        FeriadoDaoIF feriadoDao = fabrica.criaFeriadoDao();
        feriadoDao.remover(feriado);
    }

    /**
     *
     * @param feriado
     * @throws SQLException
     */
    public void atualizar(Feriado feriado) throws SQLException {
        DaoFactoryIF fabrica = DaoFactory.creatFactory();
        FeriadoDaoIF feriadoDao = fabrica.criaFeriadoDao();
        feriadoDao.atualizar(feriado);
    }

    /**
     *
     * @param dataFeriado
     * @return
     * @throws SQLException
     */
    public Feriado pesquisar(String dataFeriado) throws SQLException {
        DaoFactoryIF fabrica = DaoFactory.creatFactory();
        FeriadoDaoIF feriadoDao = fabrica.criaFeriadoDao();
        return feriadoDao.pesquisarFeriado(dataFeriado);
    }

    public List<Feriado> listar() throws SQLException {
        DaoFactoryIF fabrica = DaoFactory.creatFactory();
        FeriadoDaoIF feriadoDao = fabrica.criaFeriadoDao();
        return feriadoDao.listar();
    }
}
