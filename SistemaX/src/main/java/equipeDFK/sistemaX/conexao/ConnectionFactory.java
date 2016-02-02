/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package equipeDFK.sistemaX.conexao;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Classe ConnectionFactory
 * @author Dijalma Silva <dijalmacz@gmail.com>
 */
public class ConnectionFactory {

    private final String url;
    private final String password;
    private final String user;
    private final String driver;
    private static ConnectionFactory instance = null;

    /**
     * Construtor
     */
    public ConnectionFactory() {
        this.url = "jdbc:postgresql://localhost:5432/SistemaX";
        this.password = "123";
        this.user = "postgres";
        this.driver = "org.postgresql.Driver";
    }

    /**
     * Método que retorna uma instance do tipo ConnectionFactory
     * @return {@linkplain ConnectionFactory}
     */
    public static ConnectionFactory getInstance() {
        if (instance == null) {
            instance = new ConnectionFactory();
        }
        return instance;
    }

    /**
     * Método que retorna um objeto do tipo Connection
     * @return {@linkplain Connection}
     * @throws SQLException 
     */
    public Connection getConnection() throws SQLException {
        try {
            Class.forName(this.driver);
            return DriverManager.getConnection(this.url, this.user, this.password);
        } catch (ClassNotFoundException ex){
            throw new SQLException(ex);
        }
    }
} 