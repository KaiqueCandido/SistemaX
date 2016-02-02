/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package equipeDFK.sistemaX.conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *Classe responsável pela conexão com o banco de dados
 * @author NandaPC
 */
public class ClasseConexao {

    private Connection conexao;
    private PreparedStatement statment;

    /**
     * Método que faz a conexão com o banco de dados.
     * @return {@linkplain Connection}
     * @throws SQLException 
     */
    public Connection abrir() throws SQLException {
        if (this.conexao == null || this.conexao.isClosed()) {
            this.conexao = ConnectionFactory.getInstance().getConnection();
            this.statment = null;
        }
        return conexao; 
    }

    public void liberar() throws SQLException {
        if (this.statment != null) {
            this.statment.close();
            this.statment = null;
        }
        if (this.conexao != null) {
            this.conexao.close();
            this.conexao = null;
        }
    }
}
