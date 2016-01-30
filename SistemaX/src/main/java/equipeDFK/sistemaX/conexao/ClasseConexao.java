/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package equipeDFK.sistemaX.conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author NandaPC
 */
public class ClasseConexao {

    private Connection conexao;

    public Connection abrir() throws SQLException {
        if (this.conexao == null || this.conexao.isClosed()) {
            this.conexao = ConnectionFactory.getInstance().getConnection();
        }
        return conexao; 
    }

    public void liberar() {
       
        if (this.conexao != null) {
            try {
                this.conexao.close();
            } catch (SQLException ex) {
                Logger.getLogger(ClasseConexao.class.getName()).log(Level.SEVERE, null, ex);
            }
            this.conexao = null;
        }
    }
}
