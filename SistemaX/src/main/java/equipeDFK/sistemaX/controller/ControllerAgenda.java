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
import java.sql.SQLException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

/**
 * Classe que trata todas as requisições para gerenciar os feriados
 * @author kaique
 */
@Controller
public class ControllerAgenda {

    /**
     * Método que recebe uma requisição para retornar a página managerHoliday
     * @return {@linkplain ModelAndView}
     */
    @RequestMapping(value = "montaAgenda")
    public ModelAndView MontaAgenda() {

        ModelAndView mv = new ModelAndView("managerHoliday");

        return mv;
    }

    /**
     * Método que recebe uma requisição para retornar a lista de feriados
     * cadastrados
     * @return {@linkplain List}
     * @throws SQLException 
     */
    @RequestMapping(value = "getEventos.json")
    public @ResponseBody
    List GetEventos() throws SQLException {
        GerenciadorDeFeriado gf = new GerenciadorDeFeriado();
        List eventos = gf.listar();

        return eventos;
    }

    /**
     * Método que recebe uma requisição para importar os feriados,
     * então ler o arquivo CSV e depois persistir os dados no banco
     * @param arquivoCSV
     * @param sobrescrever
     * @param req
     * @return String
     * @throws SQLException 
     */
    @RequestMapping("openCSV")
    public String OpenCSV(MultipartFile arquivoCSV, boolean sobrescrever, HttpServletRequest req) throws SQLException {
        GerenciadorDeFeriado gf = new GerenciadorDeFeriado();
        if (!arquivoCSV.isEmpty()) {
            try {
                byte[] b = arquivoCSV.getBytes();
                String caminho = req.getServletContext().getRealPath("/") + arquivoCSV.getOriginalFilename();
                System.out.println(caminho);
                BufferedOutputStream stream
                        = new BufferedOutputStream(new FileOutputStream(new File(caminho)));
                stream.write(b);
                stream.close();
                OpenCSV opencsv = new OpenCSV();
                if (sobrescrever) {

                } else {

                }
                gf.importaferiado(opencsv.lerCSV(new File(caminho)), sobrescrever);
                List eventos = gf.listar();
                eventos.stream().forEach((evento) -> {
                    System.out.println(evento);
                });
                req.getSession().setAttribute("feriados", eventos);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return "managerHoliday";
    }

    /**
     * Método que recebe uma requisição para importar os feriados
     * Obs: Não utilizado
     * @param req
     * @param caminhoArquivo
     * @return
     * @throws SQLException 
     */
    @RequestMapping("importarFeriado")
    public String importarFeriado(HttpServletRequest req, String caminhoArquivo) throws SQLException {
        return "importarFeriado";
    }

    /**
     * Método que rebece um novo feriado pela requisição e depois cadastrada
     * esse feriado no banco de dados, e após isso retorna a página
     * managerHoliday.
     * @param req
     * @return String
     * @throws SQLException 
     */
    @RequestMapping("novoFeriado")
    public String novoFeriado(HttpServletRequest req) throws SQLException {
        GerenciadorDeFeriado gf = new GerenciadorDeFeriado();
        Feriado f = new Feriado(req.getParameter("title"), req.getParameter("start"), null, null);
        gf.cadastrar(f);
        return "managerHoliday";
    }

    
    /**
     *  Método que recebe uma requisição para editar um feriado já existente, e 
     * depois retorna a página managerHoliday.
     * @param req
     * @param f
     * @return
     * @throws SQLException 
     */
    @RequestMapping("editarFeriado")
    public String editarFeriado(HttpServletRequest req, Feriado f ) throws SQLException{
        GerenciadorDeFeriado gf = new GerenciadorDeFeriado();
        gf.atualizar(f);
        return "managerHoliday";
    }
    
    /**
     * Método que recebe uma requisição para remover um feriado existente, e 
     * depois retorna a página managerHoliday.
     * @param req
     * @param f
     * @return
     * @throws SQLException 
     */
    @RequestMapping("removerFeriado")
    public String removerFeriado(HttpServletRequest req, Feriado f) throws SQLException{
        GerenciadorDeFeriado gf = new GerenciadorDeFeriado();
        gf.remover(f);
        return "managerHoliday";
    }
    
}
