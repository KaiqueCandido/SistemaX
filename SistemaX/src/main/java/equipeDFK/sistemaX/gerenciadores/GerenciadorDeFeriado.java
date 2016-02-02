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
     * Método que cadastra um feriado e retorna um valor booleano true para
     * sucesso false para erro
     *
     * @param feriado
     * @return boolean
     * @throws SQLException
     */
    public boolean cadastrar(Feriado feriado) throws SQLException {
        DaoFactoryIF fabrica = DaoFactory.creatFactory();
        FeriadoDaoIF feriadoDao = fabrica.criaFeriadoDao();
        return feriadoDao.cadastrar(feriado);
    }

    /**
     * Método que remove um feriado
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
     * Método que atualiza um feriado
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
     * Método que faz uma busca a partir de uma data e retorna um
     * {@linkplain Feriado}
     *
     * @param dataFeriado
     * @return {@linkplain Feriado}
     * @throws SQLException
     */
    public Feriado pesquisar(String dataFeriado) throws SQLException {
        DaoFactoryIF fabrica = DaoFactory.creatFactory();
        FeriadoDaoIF feriadoDao = fabrica.criaFeriadoDao();
        return feriadoDao.pesquisarFeriado(dataFeriado);
    }

    /**
     * Método que retorna todos os feriados
     *
     * @return {@linkplain List}
     * @throws SQLException
     */
    public List<Feriado> listar() throws SQLException {
        DaoFactoryIF fabrica = DaoFactory.creatFactory();
        FeriadoDaoIF feriadoDao = fabrica.criaFeriadoDao();
        return feriadoDao.listar();
    }

    /**
     * Método que adiciona os feriados lidos por um arquivo CSV
     *
     * @param feriados
     * @param condicao
     * @return
     * @throws SQLException
     */
    public boolean importaferiado(List feriados, boolean condicao) throws SQLException {
        DaoFactoryIF fabrica = DaoFactory.creatFactory();
        FeriadoDaoIF feriadoDao = fabrica.criaFeriadoDao();
        return feriadoDao.importaferiado(feriados, condicao);
    }
}
