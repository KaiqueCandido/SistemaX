package com.mycompany.dao;

import com.mycompany.conexao.ClasseConexao;
import com.mycompany.conexao.ConnectionFactory;
import com.mycompany.entidades.Usuario;
import Interfaces.UsuarioDaoIF;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UsuarioDao implements UsuarioDaoIF {

    ConnectionFactory factory = new ConnectionFactory();
    ClasseConexao co = new ClasseConexao();
    Connection con;
    PreparedStatement pstm;

    public UsuarioDao() {
        try {
            con = co.abrir();
        } catch (Exception e) {
        }
    }

    public void cadastrar(Usuario entidade) throws SQLException {
        Date dataNascimento = entidade.getDataNasc();
        java.sql.Date dataConvertida = new java.sql.Date(dataNascimento.getTime());

        String SQL = "insert into usuario(email, nome, apelido, senha, cidade, estado, dataNasc, foto, tipo) values (?,?,?,?,?,?,?,?,?)";
        pstm = con.prepareStatement(SQL);
        pstm.setString(1, entidade.getEmail());
        pstm.setString(2, entidade.getNome());
        pstm.setString(3, entidade.getApelido());
        pstm.setString(4, entidade.getSenha());
        pstm.setString(5, entidade.getCidade());
        pstm.setString(6, entidade.getEstado());
        pstm.setDate(7, dataConvertida);
        pstm.setString(8, entidade.getFoto());
        pstm.setBoolean(9, entidade.getTipo());
        pstm.executeUpdate();
    }

    public void remover(Usuario entidade) throws SQLException {
        try {

            String SQL = "delete from usuario where email=?";

            pstm = con.prepareStatement(SQL);
            pstm.setString(1, entidade.getEmail());

            pstm.executeUpdate();
        } finally {
            co.liberar();
        }
    }

    public void atualizar(Usuario entidade) throws SQLException {
        Date dataNascimento = entidade.getDataNasc();
        java.sql.Date dataConvertida = new java.sql.Date(dataNascimento.getTime());

        try {

            String SQL = "update Usuario set email=?, nome=?, apelido=?, senha=?, cidade=?, estado=?,"
                    + "dataNasc=?, foto=? where id=?";

            pstm = con.prepareStatement(SQL);
            pstm.setString(1, entidade.getEmail());
            pstm.setString(2, entidade.getNome());
            pstm.setString(3, entidade.getApelido());
            pstm.setString(4, entidade.getSenha());
            pstm.setString(5, entidade.getCidade());
            pstm.setString(6, entidade.getEstado());
            pstm.setDate(7, dataConvertida);
            pstm.setString(8, entidade.getFoto());
            pstm.setInt(9, entidade.getId());

            pstm.executeUpdate();
        } catch (Exception E) {
            E.printStackTrace();
        } finally {
            co.liberar();
        }
    }

    public Usuario pesquisar(String nome) throws SQLException {
        try {

            String SQL = "select * from Usuario where nome ilike '%" + nome + "%'";

            pstm = con.prepareStatement(SQL);

            ResultSet result = pstm.executeQuery();

            Usuario usuario = new Usuario();

            while (result.next()) {
                usuario.setId(result.getInt("id"));
                usuario.setEmail(result.getString("email"));
                usuario.setNome(result.getString("nome"));
                usuario.setApelido(result.getString("apelido"));
                usuario.setSenha(result.getString("senha"));
                usuario.setCidade(result.getString("cidade"));
                usuario.setEstado(result.getString("estado"));
                usuario.setDataNasc(result.getDate("datanasc"));
                usuario.setFoto(result.getString("foto"));
                usuario.setTipo(result.getBoolean("tipo"));
            }
            return usuario;

        } catch (Exception E) {
            E.printStackTrace();
        } finally {
            co.liberar();
        }
        return null;
    }

    public Usuario pesquisarPorEmail(String email) throws SQLException {
        try {

            String SQL = "select * from Usuario where email ilike '%" + email + "%'";

            pstm = con.prepareStatement(SQL);

            ResultSet result = pstm.executeQuery();

            Usuario usuario = new Usuario();

            while (result.next()) {
                usuario.setId(result.getInt("id"));
                usuario.setEmail(result.getString("email"));
                usuario.setNome(result.getString("nome"));
                usuario.setApelido(result.getString("apelido"));
                usuario.setSenha(result.getString("senha"));
                usuario.setCidade(result.getString("cidade"));
                usuario.setEstado(result.getString("estado"));
                usuario.setDataNasc(result.getDate("datanasc"));
                usuario.setFoto(result.getString("foto"));
                usuario.setTipo(result.getBoolean("tipo"));
            }
            return usuario;

        } catch (Exception E) {
            E.printStackTrace();
        } finally {
            co.liberar();
        }
        return null;
    }

    public boolean logar(String email, String senha) throws SQLException {
        try {

            String SQL = "select * from Usuario where email ilike '%" + email + "%'";
            pstm = con.prepareStatement(SQL);

            ResultSet result = pstm.executeQuery();

            Usuario usuario = new Usuario();

            while (result.next()) {
                usuario.setId(result.getInt("id"));
                usuario.setEmail(result.getString("email"));
                usuario.setNome(result.getString("nome"));
                usuario.setApelido(result.getString("apelido"));
                usuario.setSenha(result.getString("senha"));
                usuario.setCidade(result.getString("cidade"));
                usuario.setEstado(result.getString("estado"));
                usuario.setDataNasc(result.getDate("datanasc"));
                usuario.setTipo(result.getBoolean("tipo"));
            }

            if (usuario.getEmail() != null && usuario.getSenha() != null) {
                if (usuario.getEmail().equalsIgnoreCase(email)
                        && usuario.getSenha().equalsIgnoreCase(senha)) {
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        } catch (Exception E) {
            E.printStackTrace();
        } finally {
            co.liberar();
        }
        return false;
    }

    public List<Usuario> pesquisarUsuarios(String nome) throws SQLException {
        try {

            String SQL = "select id, nome, foto from Usuario where nome ilike '%" + nome + "%' or apelido ilike '%" + nome + "%'";

            pstm = con.prepareStatement(SQL);

            ResultSet result = pstm.executeQuery();

            List<Usuario> usuarios = new ArrayList<Usuario>();

            while (result.next()) {
                Usuario usuario = new Usuario();
                usuario.setNome(result.getString("nome"));
                usuario.setId(result.getInt("id"));
                usuario.setFoto(result.getString("foto"));
                usuarios.add(usuario);
            }
            return usuarios.isEmpty() ? null : usuarios;
        } catch (Exception E) {
            E.printStackTrace();
        } finally {
            co.liberar();
            System.out.println("LIBEROU A CONEXÃO");
        }
        return null;
    }

    public Usuario pesquisarPorId(Integer id) throws SQLException {
        try {

            String SQL = "select * from Usuario where id = ?";

            pstm = con.prepareStatement(SQL);
            pstm.setInt(1, id);

            ResultSet result = pstm.executeQuery();

            Usuario usuario = new Usuario();

            while (result.next()) {
                usuario.setId(result.getInt("id"));
                usuario.setEmail(result.getString("email"));
                usuario.setNome(result.getString("nome"));
                usuario.setApelido(result.getString("apelido"));
                usuario.setSenha(result.getString("senha"));
                usuario.setCidade(result.getString("cidade"));
                usuario.setEstado(result.getString("estado"));
                usuario.setDataNasc(result.getDate("datanasc"));
                usuario.setFoto(result.getString("foto"));
                usuario.setTipo(result.getBoolean("tipo"));
            }
            return usuario;

        } catch (Exception E) {
            E.printStackTrace();
        } finally {
            co.liberar();
        }
        return null;
    }

    public void uploadFotoDePerfil(String caminho, Integer id) throws SQLException, IOException {
        try {

            String SQL = "update Usuario set foto=? where id = ?";

            pstm = con.prepareStatement(SQL);
            pstm.setString(1, caminho);
            pstm.setInt(2, id);

            pstm.executeUpdate();

        } finally {
            co.liberar();
        }
    }

    public void transformaEmAdiministrador(Integer idUsuario, Integer idAmigo) throws SQLException, IOException {
        try {

            String SQL = "update Usuario set tipo='true' where id = ?";

            pstm = con.prepareStatement(SQL);
            pstm.setInt(1, idAmigo);
            pstm.executeUpdate();

        } finally {
            co.liberar();
        }
    }
}
