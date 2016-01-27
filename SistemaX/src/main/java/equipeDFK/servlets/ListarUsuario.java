/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package equipeDFK.servlets;

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
@WebServlet(name = "ListarUsuario", urlPatterns = {"/ListarUsuario"})
public class ListarUsuario extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        doPost(request, response);
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response){
        
        try {
            GerenciadorDeUsuario gerenciadorDeUsuario = new GerenciadorDeUsuario();
            gerenciadorDeUsuario.listar();
                        
        } catch (Exception e) {
        }
    }
}
