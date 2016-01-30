/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package equipeDFK.sistemaX.controller;

import equipeDFK.sistemaX.entidades.Usuario;
import equipeDFK.sistemaX.gerenciadores.GerenciadorDeUsuario;
import equipeDFK.sistemaX.validacao.ValidaUsuario;
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
    public String editUsuario(HttpServletRequest req, Usuario atualizado) throws SQLException {
        GerenciadorDeUsuario gu = new GerenciadorDeUsuario();
        // tem que ajeitar
        gu.atualizar(atualizado, atualizado);
        req.getSession().setAttribute("usuarios", gu.listar());
        return "managerUser";
    }

    @RequestMapping("atualizarUsuarioAtual")
    public String editCurrentUsuario(HttpServletRequest req, Usuario atualizado) throws SQLException {
        GerenciadorDeUsuario gu = new GerenciadorDeUsuario();
        Usuario usuarioAtual = (Usuario) req.getSession().getAttribute("usuario");
        gu.atualizar(usuarioAtual, atualizado);
        req.getSession().setAttribute("usuario", gu.pesquisarPorNomeDeUsuario(atualizado.getEmail()));
        return "managerUser";
    }

    @RequestMapping("removerUsuario")
    public String removerUsuario(HttpServletRequest req, Usuario u) throws SQLException {
        GerenciadorDeUsuario gu = new GerenciadorDeUsuario();
        gu.remover(u);
        req.getSession().setAttribute("usuarios", gu.listar());
        return "managerUser";
    }
}
