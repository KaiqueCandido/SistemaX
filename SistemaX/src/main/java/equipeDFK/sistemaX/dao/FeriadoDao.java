/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package equipeDFK.sistemaX.dao;

import equipeDFK.sistemaX.conexao.ClasseConexao;
import equipeDFK.sistemaX.conexao.ConnectionFactory;
import equipeDFK.sistemaX.entidades.Feriado;
import equipeDFK.sistemaX.interfaces.FeriadoDaoIF;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

            //Date data = feriado.getDataFeriado();
            //java.sql.Date dataConvertida = new java.sql.Date(data.getTime());
            String SQl = "insert into Feriado(nomeFeriado, dataFeriado) values (?,?)";

            pstm = con.prepareStatement(SQl);
            pstm.setString(1, feriado.getTitle());
            pstm.setString(2, feriado.getStart());

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

            //Date data = feriado.getDataFeriado();
            //java.sql.Date dataConvertida = new java.sql.Date(data.getTime());
            String SQL = "delete from Feriado where dataFeriado=?";

            pstm = con.prepareStatement(SQL);
            pstm.setString(1, feriado.getStart());

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

            //Date data = feriado.getDataFeriado();
            //java.sql.Date dataConvertida = new java.sql.Date(data.getTime());
            String SQL = "update Feriado set nomeFeriado=?, dataFeriado=? where id=? ";
            pstm = con.prepareStatement(SQL);
            pstm.setString(1, feriado.getTitle());
            pstm.setString(2, feriado.getStart());

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
                feriado1.setTitle(result.getString("nomeFeriado"));
                feriado1.setStart(result.getString("dataFeriado"));

                return feriado1;
            }

            return null;
        } finally {
            co.liberar();
        }
    }

    public List<Feriado> listar() throws SQLException {
        try {
            String SQL = "select * from feriado";

            pstm = con.prepareStatement(SQL);

            ResultSet result = pstm.executeQuery();

            List<Feriado> feriados = new ArrayList<>();

            while (result.next()) {
                Feriado feriado = new Feriado();
                
                String split[] = result.getString("dataferiado").split("-");                
                String data = split[1] + "-" + split[2] + "-" + split[0];
                System.out.println(data);
                
                feriado.setTitle(result.getString("nomeFeriado"));
                feriado.setStart(data);

                feriados.add(feriado);
            }

            return feriados.isEmpty() ? null : feriados;
        } finally {
            co.liberar();
        }
    }

}
