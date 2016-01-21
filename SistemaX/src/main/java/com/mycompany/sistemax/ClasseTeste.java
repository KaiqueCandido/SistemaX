/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sistemax;

import com.mycompany.entidades.Usuario;
import com.mycompany.gerenciadores.GerenciadorDeUsuario;
import java.sql.SQLException;

/**
 *
 * @author kaique
 */
public class ClasseTeste {

    public static void main(String[] args) throws SQLException {
        //GerenciadorDeUsuario gu = new GerenciadorDeUsuario();
        //gu.cadastrar(new Usuario("email", "kaique Candido", "senha", "foto", "tipo", "matri"));

        String nome = "kaiQue";
        for (int i = 0; i < nome.length(); i++) {
            String aux = "" + nome.charAt(i);
            
            if (aux.toUpperCase().equals(aux)){
                System.out.println(aux + " - Maiuscula");
            }
            else
                System.out.println(aux + " - Minuscula");
        }
        

    }
}
