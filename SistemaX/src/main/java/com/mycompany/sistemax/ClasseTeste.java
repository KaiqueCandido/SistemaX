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
        GerenciadorDeUsuario gu = new GerenciadorDeUsuario();
        
        gu.logar("NOME", "senha");
        
        gu.logar("kaique25_ci@hotmail.com", "senha");
        
        gu.logar("NOME2", "senha");
        
        gu.logar("kaique_ci@hotmail.com", "senha");
    }
}
