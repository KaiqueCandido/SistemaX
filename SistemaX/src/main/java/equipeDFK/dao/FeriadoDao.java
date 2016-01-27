/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package equipeDFK.dao;

import equipeDFK.conexao.ClasseConexao;
import equipeDFK.conexao.ConnectionFactory;
import equipeDFK.entidades.Feriado;
import equipeDFK.interfaces.FeriadoDaoIF;
import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author NandaPC
 */
public class FeriadoDao implements FeriadoDaoIF {

    ConnectionFactory factory = new ConnectionFactory();
    ClasseConexao co = new ClasseConexao();
    Connection con;
    PreparedStatement pstm;

    public FeriadoDao() {
        try {
            con = co.abrir();
        } catch (Exception e) {
        }
    }

    /**
     *
     * @param feriado
     * @return
     * @throws SQLException
     */
    @Override
    public boolean cadastrar(Feriado feriado) throws SQLException {
        try {

            Date data = feriado.getDataFeriado();
            java.sql.Date dataConvertida = new java.sql.Date(data.getTime());

            String SQl = "insert into Feriado(nomeFeriado, dataFeriado) values (?,?)";

            pstm = con.prepareStatement(SQl);
            pstm.setString(1, feriado.getNomeFeriado());
            pstm.setDate(2, dataConvertida);

            pstm.executeUpdate();

            return true;
        } finally {
            co.liberar();
        }
    }

    /**
     *
     * @param feriado
     * @throws SQLException
     */
    @Override
    public void remover(Feriado feriado) throws SQLException {

        try {

            Date data = feriado.getDataFeriado();
            java.sql.Date dataConvertida = new java.sql.Date(data.getTime());

            String SQL = "delete from Feriado where dataFeriado=?";

            pstm = con.prepareStatement(SQL);
            pstm.setDate(1, dataConvertida);

            pstm.executeUpdate();

        } finally {
            co.liberar();
        }

    }

    /**
     *
     * @param feriado
     * @throws SQLException
     */
    @Override
    public void atualizar(Feriado feriado) throws SQLException {
        try {

            Date data = feriado.getDataFeriado();
            java.sql.Date dataConvertida = new java.sql.Date(data.getTime());

            String SQL = "update Feriado set nomeFeriado=?, dataFeriado=? where id=? ";
            pstm = con.prepareStatement(SQL);
            pstm.setString(1, feriado.getNomeFeriado());
            pstm.setDate(2, dataConvertida);

            pstm.executeUpdate();

        } finally {
            co.liberar();
        }
    }

    @Override
    public Feriado pesquisarFeriado(String dataFeriado) throws SQLException {

        try {

            String SQL = "select * from Feriado where dataFeriado='" + dataFeriado + "'";
            pstm = con.prepareStatement(SQL);

            ResultSet result = pstm.executeQuery();

            Feriado feriado1 = new Feriado();

            while (result.next()) {
                feriado1.setIdFeriado(result.getInt("idFeriado"));
                feriado1.setNomeFeriado(result.getString("nomeFeriado"));
                feriado1.setDataFeriado(result.getDate("dataFeriado"));

                return feriado1;
            }

            return null;
        } finally {
            co.liberar();
        }
    }

}
