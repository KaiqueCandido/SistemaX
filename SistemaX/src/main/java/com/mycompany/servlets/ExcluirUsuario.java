/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.servlets;

import com.mycompany.entidades.Usuario;
import com.mycompany.gerenciadores.GerenciadorDeUsuario;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sun.text.normalizer.UBiDiProps;

/**
 *
 * @author NandaPC
 */
@WebServlet(name = "ExcluirUsuario", urlPatterns = {"/ExcluirUsuario"})
public class ExcluirUsuario extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
                doPost(request, response);
    } 
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response){
        try {
            
            Usuario user = (Usuario) request.getSession().getAttribute("user");
            
            String nome = request.getParameter("nome");
            String email = request.getParameter("email");
            String senha = request.getParameter("senha");
            String matricula = request.getParameter("matricula");
            String tipo = request.getParameter("tipo");
            String foto = request.getParameter("foto");
            
            Usuario usuario = new Usuario(email, nome, senha, foto, tipo, matricula);          
            
            GerenciadorDeUsuario gerenciadorDeUsuario = new GerenciadorDeUsuario();
            gerenciadorDeUsuario.remover(usuario);
            
        } catch (Exception e) {
        }
    }
   
}
