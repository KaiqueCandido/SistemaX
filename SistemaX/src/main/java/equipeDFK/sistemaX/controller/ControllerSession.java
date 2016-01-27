/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package equipeDFK.sistemaX.controller;

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
     * 
     * @param usuarioOuEmail
     * @param senha 
     * @param model 
     */
    @RequestMapping("logar")
    public void login(String usuarioOuEmail, String senha, Model model){
        model.addAttribute("login", "dijalma");
    }
    
}
