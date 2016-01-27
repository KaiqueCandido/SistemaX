/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.interfaces;

import com.mycompany.entidades.Feriado;
import java.sql.SQLException;
import java.util.Date;

/**
 *
 * @author NandaPC
 */
public interface FeriadoDaoIF {
    
    /**
     * 
     * @param feriado
     * @return
     * @throws SQLException 
     */
    public boolean cadastrar(Feriado feriado) throws SQLException;

    /**
     * 
     * @param feriado
     * @throws SQLException 
     */
    public void remover(Feriado feriado) throws SQLException;

    /**
     * 
     * @param feriado
     * @throws SQLException 
     */
    public void atualizar(Feriado feriado) throws SQLException;
    
    /**
     * 
     * @param dataFeriado
     * @throws SQLException 
     */
    public Feriado pesquisarFeriado (String dataFeriado) throws SQLException;
}
