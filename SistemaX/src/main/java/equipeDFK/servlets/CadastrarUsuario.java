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
import javax.servlet.http.HttpSession;

/**
 *
 * @author NandaPC
 */
@WebServlet(name = "CadastrarUsuario", urlPatterns = {"/CadastrarUsuario"})
public class CadastrarUsuario extends HttpServlet {

    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        
        doPost(request, response);
    }
    protected void doPost(HttpServletRequest request,  HttpServletResponse response){
        try {
                        
            HttpSession session = request.getSession();
            Usuario user = (Usuario) request.getSession().getAttribute("user");
            session.setAttribute("user", user);
            
                       
                String nome = request.getParameter("nome");
                String email = request.getParameter("email");
                String matricula = request.getParameter("matricula");
                String tipo = request.getParameter("tipo");
                String senha = request.getParameter("senha");
                String foto = request.getParameter("foto");
            
                GerenciadorDeUsuario GerenUsuario = new GerenciadorDeUsuario();
                Usuario usuario = new Usuario(email, nome, senha, foto, tipo, matricula);
                GerenUsuario.cadastrar(usuario);
            
        }catch (Exception e) {
        }
        
    }
}