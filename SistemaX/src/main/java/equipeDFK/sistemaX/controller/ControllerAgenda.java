/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package equipeDFK.sistemaX.controller;

import equipeDFK.sistemaX.entidades.Feriado;
import equipeDFK.sistemaX.gerenciadores.GerenciadorDeFeriado;
import equipeDFK.sistemaX.openCSV.OpenCSV;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
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
    public @ResponseBody
    List GetEventos() throws SQLException {
        GerenciadorDeFeriado gf = new GerenciadorDeFeriado();
        List eventos = gf.listar();
        
        return eventos;
    }

    @RequestMapping("openCSV")
    public @ResponseBody
    List OpenCSV(MultipartFile arquivoCSV) throws SQLException {
        GerenciadorDeFeriado gf = new GerenciadorDeFeriado();
        if (!arquivoCSV.isEmpty()){
            try{
                byte[] b = arquivoCSV.getBytes();
                System.out.println();
                BufferedOutputStream stream = 
                        new BufferedOutputStream(new FileOutputStream(new File(arquivoCSV.getOriginalFilename())));
                stream.write(b);
                stream.close();
                OpenCSV opencsv = new OpenCSV();
                //Tem que passar o caminho do arquivo
                gf.importaferiado(opencsv.lerCSV(new File(arquivoCSV.getOriginalFilename())));
                List eventos = gf.listar();
                eventos.stream().forEach((evento) -> {
                    System.out.println(evento);
                });
                return eventos;
            }catch (Exception ex){
                ex.printStackTrace();
            }
        }
        
        return new ArrayList();
        
    }

    @RequestMapping("importarFeriado")
    public String importarFeriado(HttpServletRequest req, String caminhoArquivo) throws SQLException {
        return "importarFeriado";
    }

    @RequestMapping("novoFeriado")
    public String novoFeriado(HttpServletRequest req) throws SQLException {
        GerenciadorDeFeriado gf = new GerenciadorDeFeriado();
        Feriado f = new Feriado(req.getParameter("title"), req.getParameter("start"), null, null);
        gf.cadastrar(f);
        return "managerHoliday";
    }

}
