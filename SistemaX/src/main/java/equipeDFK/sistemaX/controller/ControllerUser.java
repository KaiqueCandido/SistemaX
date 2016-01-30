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
 *
 * @author Dijalma Silva <dijalmacz@gmail.com>
 */
@Controller
public class ControllerUser {
    
    @RequestMapping("addUsuario")
    public String addUsuario(HttpServletRequest req, Usuario u) throws SQLException {
        GerenciadorDeUsuario gu = new GerenciadorDeUsuario();
        gu.cadastrar(u);
        req.getSession().setAttribute("usuarios", gu.listar());
        return "managerUser";
    }
    
    @RequestMapping("atualizarUsuario")
    public String editUsuario(HttpServletRequest req, Usuario u) throws SQLException {
        GerenciadorDeUsuario gu = new GerenciadorDeUsuario();
        gu.atualizar(u);
        req.getSession().setAttribute("usuarios", gu.listar());
        return "managerUser";
    }
    
    @RequestMapping("removerUsuario")
    public String removerUsuario(HttpServletRequest req, Usuario u) throws SQLException {
        GerenciadorDeUsuario gu = new GerenciadorDeUsuario();
        gu.remover(u);
        req.getSession().setAttribute("usuarios", gu.listar());
        return "managerUser";
    }
    
    @RequestMapping("atualizarPerfil")
    public String editCurrentUsuario(HttpServletRequest req, Usuario u) throws SQLException {
        GerenciadorDeUsuario gu = new GerenciadorDeUsuario();
        Usuario usuario = (Usuario) req.getSession().getAttribute("usuarioLogado");
        u.setId(usuario.getId());
        gu.atualizar(u);
        req.getSession().setAttribute("usuarioLogado", gu.pesquisarPorId(usuario.getId()));
        return "home";
    }
}
