/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package equipeDFK.sistemaX.conversao;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Classe Data, responsável pelas formatações de datas.
 * @author NandaPC
 */
public class Data {
    
    /**
     * Método que recebe uma string e retorna uma data do tipo {@linkplain Date}
     * @param date
     * @return {@linkplain Date}
     */
    public Date stringParaDate(String date){
        Date data = null;
        try {
            DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            data = (Date)formatter.parse(date);
        } catch (Exception e) {
        }
        return data;
    }
    
}
