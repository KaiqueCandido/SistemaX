/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package equipeDFK.servlets;

import equipeDFK.entidades.Usuario;
import equipeDFK.gerenciadores.GerenciadorDeUsuario;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author NandaPC
 */
@WebServlet(name = "EditarUsuario", urlPatterns = {"/EditarUsuario"})
public class EditarUsuario extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        doPost(request, response);
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response){
        try {
            
            Usuario user = (Usuario) request.getSession().getAttribute("user");
                       
            Integer id = user.getId();
            String email = request.getParameter("email");
            String nome  = request.getParameter("nome");
            String novaSenha = request.getParameter("novaSenha");
            String tipo = request.getParameter("tipo");
            String matricula = request.getParameter("matricula");
            String foto = user.getFoto();
            
            Usuario novoUsuario = new Usuario();
            
            novoUsuario.setId(id);
            novoUsuario.setEmail(email);
            novoUsuario.setNome(nome);
            novoUsuario.setSenha(novaSenha);
            novoUsuario.setTipo(tipo);
            novoUsuario.setMatricula(matricula);
            novoUsuario.setFoto(foto);
            
            GerenciadorDeUsuario gerenciadorUsuario = new GerenciadorDeUsuario();
            gerenciadorUsuario.atualizar(novoUsuario);
            
        } catch (Exception e) {
        }
    }
}
