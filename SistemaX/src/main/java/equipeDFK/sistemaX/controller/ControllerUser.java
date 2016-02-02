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
 * Classe responsável pelas requisições de usuário
 * @author Dijalma Silva <dijalmacz@gmail.com>
 */
@Controller
public class ControllerUser {
    
    /**
     * Método que recebe uma requisição de adicionar um novo usuário
     * @param req
     * @param u
     * @return 
     */
    @RequestMapping("addUsuario")
    public String addUsuario(HttpServletRequest req, Usuario u)  {
        GerenciadorDeUsuario gu = new GerenciadorDeUsuario();
        boolean r = false;
        try {
            r = gu.cadastrar(u);
            req.getSession().setAttribute("usuarios", gu.listar());
        } catch (SQLException ex) {
            Logger.getLogger(ControllerUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if (r){
            req.setAttribute("result", "Usuário cadastrado com sucesso!");
        }else{
            req.setAttribute("result", "Erro ao cadastrar usuário.");
        }
        
        return "managerUser";
    }
    
    /**
     *  Método que recebe uma requisição para atualizar um usuário já existente
     * @param req
     * @param u
     * @return
     * @throws SQLException 
     */
    @RequestMapping("atualizarUsuario")
    public String editUsuario(HttpServletRequest req, Usuario u) throws SQLException {
        GerenciadorDeUsuario gu = new GerenciadorDeUsuario();
        gu.atualizar(u);
        req.getSession().setAttribute("usuarios", gu.listar());
        return "managerUser";
    }

    /**
     *  Método que recebe uma requisição para remover um usuário existente
     * @param req
     * @param id
     * @return
     * @throws SQLException 
     */
    @RequestMapping("removerUsuario")
    public String removerUsuario(HttpServletRequest req, int id) throws SQLException {
        GerenciadorDeUsuario gu = new GerenciadorDeUsuario();
        Usuario u = gu.pesquisarPorId(id);
        gu.remover(u);
        req.getSession().setAttribute("usuarios", gu.listar());
        return "managerUser";
    }
    
    /**
     * Método que recebe uma requisição para atualizar o perfil do usuário
     * autenticado no sistema
     * @param req
     * @param u
     * @return
     * @throws SQLException 
     */
    @RequestMapping("atualizarPerfil")
    public String editCurrentUsuario(HttpServletRequest req, Usuario u) throws SQLException {
        GerenciadorDeUsuario gu = new GerenciadorDeUsuario();
        Usuario usuario = (Usuario) req.getSession().getAttribute("usuarioLogado");
        u.setId(usuario.getId());
        gu.atualizar(u);
        req.getSession().setAttribute("usuarioLogado", gu.pesquisarPorId(usuario.getId()));
        return "home";
    }
    
    /**
     * Método que recebe uma requisição para retornar um usuário selecionado 
     * na aplicação.
     * @param idUsuario
     * @return
     * @throws SQLException 
     */
    @RequestMapping("retornarUsuario")
    public @ResponseBody Usuario retornaUser(int idUsuario) throws SQLException{
        GerenciadorDeUsuario gu = new GerenciadorDeUsuario();
        return gu.pesquisarPorId(idUsuario);
    }
}
