/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package equipeDFK.sistemaX.controller;

import equipeDFK.sistemaX.gerenciadores.GerenciadorDeFeriado;
import equipeDFK.sistemaX.openCSV.OpenCSV;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
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
        List eventos = gf.listar();  
        eventos.stream().forEach((evento) -> {
            System.out.println(evento);
        });        
        return eventos;
    }
    
    @RequestMapping(value = "openCSV")
    public @ResponseBody List OpenCSV() throws SQLException {
        GerenciadorDeFeriado gf = new GerenciadorDeFeriado();
        OpenCSV opencsv = new OpenCSV();
        //Tem que passar o caminho do arquivo
        //gf.importaferiado(opencsv.lerCSV(new File()));
        List eventos = gf.listar();
        eventos.stream().forEach((evento) -> {
            System.out.println(evento);
        });        
        return eventos;
    }
    
    
    @RequestMapping("importarFeriado")
    public String importarFeriado(HttpServletRequest req) throws SQLException {                
        return "importarFeriado";
    }

}
