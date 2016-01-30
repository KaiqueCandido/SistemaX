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
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Dijalma Silva <dijalmacz@gmail.com>
 */
@Controller
public class ControllerAjax {
    
    @RequestMapping("/addUsuarioAjax")
    public @ResponseBody String addUser(HttpServletRequest req, String foto, String nome, String senha, String email, String matricula, String tipo) throws SQLException{
        GerenciadorDeUsuario gu = new GerenciadorDeUsuario();
        Usuario u = new Usuario(email, nome, senha, foto, tipo, matricula, "ativo");
        boolean r = gu.cadastrar(u);
 
        String  result;
        
        if (r)
            result = "Usuário cadastrado com sucesso!";
        else
            result = "Erro ao cadastrar usuário";
        
        return result;
    }
}
