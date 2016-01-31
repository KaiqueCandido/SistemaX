/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package equipeDFK.sistemaX.controller;

import equipeDFK.sistemaX.gerenciadores.GerenciadorDeFeriado;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author kaique
 */
@Controller
public class ControllerAgenda {

    @RequestMapping(value = "montaAgenda")
    public ModelAndView MontaAgenda() {

        ModelAndView mv = new ModelAndView("managerHoliday");

        return mv;
    }

    @RequestMapping(value = "getEventos.json")
    public @ResponseBody List GetEventos() throws SQLException {
        GerenciadorDeFeriado gf = new GerenciadorDeFeriado();
        List eventos = new ArrayList();       
        eventos = gf.listar();       
        for (Object evento : eventos) {
            System.out.println(evento);
        }
        
        return eventos;
    }

}
