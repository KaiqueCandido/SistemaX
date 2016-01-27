/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package equipeDFK.sistemaX.controller;

import equipeDFK.sistemaX.entidades.Usuario;
import equipeDFK.sistemaX.gerenciadores.GerenciadorDeUsuario;
import java.sql.SQLException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
     * @param model 
     * @return  
     */
    @RequestMapping("logar")
    public String login(String usuarioOuEmail, String senha, Model model) throws SQLException{
        GerenciadorDeUsuario gu = new GerenciadorDeUsuario();
        Usuario u = gu.logar(usuarioOuEmail, senha);
        
        if (u == null){
            model.addAttribute("erro", "Usuário ou senha inválidos");
            return "index";
        }
        model.addAttribute("usuario", u);
        return "home";
    }
    
}
