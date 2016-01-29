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

    private String nomeFeriado;
    private String dataFeriado;

    public Feriado() {
    }

    public Feriado(String nomeFeriado, String dataFeriado) {
        this.nomeFeriado = nomeFeriado;
        this.dataFeriado = dataFeriado;
    }

    public String getNomeFeriado() {
        return nomeFeriado;
    }

    public void setNomeFeriado(String nomeFeriado) {
        this.nomeFeriado = nomeFeriado;
    }

    public String getDataFeriado() {
        return dataFeriado;
    }

    public void setDataFeriado(String dataFeriado) {
        this.dataFeriado = dataFeriado;
    }

}
