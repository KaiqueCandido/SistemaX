/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package equipeDFK.sistemaX.controller;

import equipeDFK.sistemaX.entidades.Usuario;
import equipeDFK.sistemaX.gerenciadores.GerenciadorDeUsuario;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *  Classe que controla todas as requisições feitas na sessão de login
 * @author Dijalma Silva <dijalmacz@gmail.com>
 */
@Controller
public class ControllerSession {
   
    /**
     * Controla o login no sistema
     * @param usuarioOuEmail
     * @param senha 
     * @param req 
     * @return  
     * @throws java.sql.SQLException  
     */
    @RequestMapping("logar")
    public String login(String usuarioOuEmail, String senha, HttpServletRequest req) throws SQLException{
        GerenciadorDeUsuario gu = new GerenciadorDeUsuario();
        Usuario u = gu.logar(usuarioOuEmail, senha);
        
        if (u == null){
            req.setAttribute("erro", "Usuário ou senha inválidos");
            return "index";
        }
        req.getSession().setAttribute("usuarioLogado", u);
        return "home";
    }
    
    @RequestMapping("deslogar")
    public String logout(HttpServletRequest req) throws SQLException{                    
        req.getSession().setAttribute("usuario", null);
        return "index";
    }
    
}
