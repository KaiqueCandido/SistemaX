/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package equipeDFK.sistemaX.controller;

import equipeDFK.sistemaX.gerenciadores.GerenciadorDeUsuario;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Classe que controla todas as requisições de BreadCrumb
 * @author Dijalma Silva <dijalmacz@gmail.com>
 */
@Controller
public class ControllerBreadCrumb {

    /**
     * Método que recebe uma requisição para retornar a página Home
     * @return String
     */
    @RequestMapping("home")
    public String retornaHome() {
        return "home";
    }

    /**
     * Método que instacia todos usuário no sistema e retorna a página 
     * manageUser
     * @param req
     * @return
     * @throws SQLException 
     */
    @RequestMapping("managerUser")
    public String managerUser(HttpServletRequest req) throws SQLException {
        GerenciadorDeUsuario gu = new GerenciadorDeUsuario();
        req.getSession().setAttribute("usuarios", gu.listar());
        return "managerUser";
    }
    
    /**
     * Método que recebe uma requisição para retornar a pagina managerHoliday
     * @param req
     * @return
     * @throws SQLException 
     */
    @RequestMapping("managerHoliday")
    public String managerHoliday(HttpServletRequest req) throws SQLException {                
        return "managerHoliday";
    }    
            
}
