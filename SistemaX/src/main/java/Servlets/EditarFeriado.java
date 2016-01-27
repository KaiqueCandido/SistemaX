/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import com.mycompany.entidades.Feriado;
import com.mycompany.gerenciadores.GerenciadorDeFeriado;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author NandaPC
 */
@WebServlet(name = "EditarFeriado", urlPatterns = {"/EditarFeriado"})
public class EditarFeriado extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException{
        
        doPost(request, response);
        
    }
    /**
     * 
     * @param request
     * @param response 
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response){
        try {
            
            String nomeFeriado = request.getParameter("nomeFeriado");
            String dataFeriado = request.getParameter("dataFeriado");
            
            DateFormat formate = new SimpleDateFormat("dd/MM/yyyy");
            Date dataConvertida = (Date) formate.parse(dataFeriado);
            
            Feriado novoFeriado = new Feriado();
            
            novoFeriado.setNomeFeriado(nomeFeriado);
            novoFeriado.setDataFeriado(dataConvertida);
            
            GerenciadorDeFeriado gerenFeriado = new GerenciadorDeFeriado();
            gerenFeriado.atualizar(novoFeriado);
            
        } catch (Exception e) {
        }
    }
}
