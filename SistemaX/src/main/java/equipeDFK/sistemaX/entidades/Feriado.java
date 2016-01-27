/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package equipeDFK.sistemaX.entidades;

import java.util.Date;

/**
 *
 * @author NandaPC
 */
public class Feriado {
    
    private int idFeriado;
    private String nomeFeriado;
    private Date dataFeriado;

    public Feriado() {
    }

    public Feriado(String nomeFeriado, Date dataFeriado) {
        this.nomeFeriado = nomeFeriado;
        this.dataFeriado = dataFeriado;
    }

    public int getIdFeriado() {
        return idFeriado;
    }

    public void setIdFeriado(int idFeriado) {
        this.idFeriado = idFeriado;
    }

    public String getNomeFeriado() {
        return nomeFeriado;
    }

    public void setNomeFeriado(String nomeFeriado) {
        this.nomeFeriado = nomeFeriado;
    }

    public Date getDataFeriado() {
        return dataFeriado;
    }

    public void setDataFeriado(Date dataFeriado) {
        this.dataFeriado = dataFeriado;
    }
    
    
}
