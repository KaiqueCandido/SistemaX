package com.mycompany.dao;

import com.mycompany.conexao.ClasseConexao;
import com.mycompany.conexao.ConnectionFactory;
import com.mycompany.entidades.Usuario;
import com.mycompany.interfaces.UsuarioDaoIF;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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

    @Override
    public void cadastrar(Usuario u) throws SQLException {
        try {
            String SQL = "insert into usuario(email, nome, senha, foto, tipo, matricula) values (?,?,?,?,?,?)";

            pstm = con.prepareStatement(SQL);
            pstm.setString(1, u.getEmail());
            pstm.setString(2, u.getNome());
            pstm.setString(3, u.getSenha());
            pstm.setString(4, u.getFoto());
            pstm.setString(5, u.getTipo());
            pstm.setString(6, u.getMatricula());

            pstm.executeUpdate();
        } finally {
            co.liberar();
        }

    }

    @Override
    public void remover(Usuario u) throws SQLException {
        try {
            String SQL = "delete from usuario where email=?";

            pstm = con.prepareStatement(SQL);
            pstm.setString(1, u.getEmail());

            pstm.executeUpdate();
        } finally {
            co.liberar();
        }
    }

    @Override
    public void atualizar(Usuario u) throws SQLException {
        try {

            String SQL = "update usuario set email=?, nome=? senha=?, foto=?, matricula=? where id=?";

            pstm = con.prepareStatement(SQL);
            pstm.setString(1, u.getEmail());
            pstm.setString(2, u.getNome());
            pstm.setString(3, u.getSenha());
            pstm.setString(4, u.getFoto());
            pstm.setString(5, u.getTipo());
            pstm.setString(6, u.getMatricula());

            pstm.executeUpdate();
        } finally {
            co.liberar();
        }
    }

    @Override
    public Usuario pesquisarPorNome(String nome) throws SQLException {
        try {
            String SQL = "select * from usuario where nome ilike '%" + nome + "%'";

            pstm = con.prepareStatement(SQL);
            ResultSet result = pstm.executeQuery();

            Usuario usuario = new Usuario();

            while (result.next()) {
                usuario.setId(result.getInt("id"));
                usuario.setEmail(result.getString("email"));
                usuario.setNome(result.getString("nome"));
                usuario.setSenha(result.getString("senha"));
                usuario.setFoto(result.getString("foto"));
                usuario.setTipo(result.getString("tipo"));
                usuario.setMatricula(result.getString("matricula"));
            }

            return usuario;
        } finally {
            co.liberar();
        }
    }

    @Override
    public Usuario pesquisarPorEmail(String email) throws SQLException {
        try {
            String SQL = "select * from usuario where email ilike '%" + email + "%'";

            pstm = con.prepareStatement(SQL);
            ResultSet result = pstm.executeQuery();

            Usuario usuario = new Usuario();

            while (result.next()) {
                usuario.setId(result.getInt("id"));
                usuario.setEmail(result.getString("email"));
                usuario.setNome(result.getString("nome"));
                usuario.setSenha(result.getString("senha"));
                usuario.setFoto(result.getString("foto"));
                usuario.setTipo(result.getString("tipo"));
                usuario.setMatricula(result.getString("matricula"));
            }

            return usuario;
        } finally {
            co.liberar();
        }
    }

    @Override
    public Usuario pesquisarPorMatricula(String matricula) throws SQLException {
        try {
            String SQL = "select * from usuario where matricula ilike '%" + matricula + "%'";

            pstm = con.prepareStatement(SQL);
            ResultSet result = pstm.executeQuery();

            Usuario usuario = new Usuario();

            while (result.next()) {
                usuario.setId(result.getInt("id"));
                usuario.setEmail(result.getString("email"));
                usuario.setNome(result.getString("nome"));
                usuario.setSenha(result.getString("senha"));
                usuario.setFoto(result.getString("foto"));
                usuario.setTipo(result.getString("tipo"));
                usuario.setMatricula(result.getString("matricula"));
            }

            return usuario;
        } finally {
            co.liberar();
        }
    }

    @Override
    public boolean logar(String login, String senha) throws SQLException {
        return true;
    }

    @Override
    public List<Usuario> listar() throws SQLException {
        try {
            String SQL = "select * from usuario";

            pstm = con.prepareStatement(SQL);

            ResultSet result = pstm.executeQuery();

            List<Usuario> usuarios = new ArrayList<>();

            while (result.next()) {
                Usuario usuario = new Usuario();

                usuario.setId(result.getInt("id"));
                usuario.setEmail(result.getString("email"));
                usuario.setNome(result.getString("nome"));
                usuario.setSenha(result.getString("senha"));
                usuario.setFoto(result.getString("foto"));
                usuario.setTipo(result.getString("tipo"));
                usuario.setMatricula(result.getString("matricula"));

                usuarios.add(usuario);
            }

            return usuarios.isEmpty() ? null : usuarios;
        } finally {
            co.liberar();
        }
    }
}
