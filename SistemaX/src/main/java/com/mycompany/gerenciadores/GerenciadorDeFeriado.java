/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gerenciadores;

import com.mycompany.entidades.Feriado;
import com.mycompany.fabricas.DaoFactory;
import com.mycompany.fabricas.DaoFactoryIF;
import com.mycompany.interfaces.FeriadoDaoIF;
import java.sql.SQLException;

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
}
