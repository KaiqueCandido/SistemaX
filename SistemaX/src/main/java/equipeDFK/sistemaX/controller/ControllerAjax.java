/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package equipeDFK.sistemaX.controller;

import equipeDFK.sistemaX.entidades.Usuario;
import equipeDFK.sistemaX.gerenciadores.GerenciadorDeUsuario;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Dijalma Silva <dijalmacz@gmail.com>
 */
@Controller
public class ControllerAjax {
    
    @RequestMapping("addUsuarioAjax")
    public @ResponseBody String addUser(HttpServletRequest req, Usuario u) {
        GerenciadorDeUsuario gu = new GerenciadorDeUsuario();
        boolean r = false;
        
        try {
            r = gu.cadastrar(u);
        } catch (SQLException ex) {
            Logger.getLogger(ControllerAjax.class.getName()).log(Level.SEVERE, null, ex);
        }
 
        String  result;
        
        if (r)
            result = "Usuário cadastrado com sucesso!";
        else
            result = "Erro ao cadastrar usuário";
        
        return result;
    }
}
