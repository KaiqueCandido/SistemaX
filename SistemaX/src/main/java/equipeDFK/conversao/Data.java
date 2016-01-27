/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conversao;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author NandaPC
 */

public class Data {
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
