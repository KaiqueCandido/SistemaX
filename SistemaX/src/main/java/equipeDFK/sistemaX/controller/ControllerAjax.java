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
    
    @RequestMapping("ajaxUser")
    public @ResponseBody String usuarioSelecionado(int idUsuario, HttpServletRequest req){
        GerenciadorDeUsuario gu = new GerenciadorDeUsuario();
        try {
            Usuario u = gu.pesquisarPorId(idUsuario);
            req.setAttribute("usuarioSelecionado", u);
        } catch (SQLException ex) {
            Logger.getLogger(ControllerAjax.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return "Usuário retornado";
    }
}
