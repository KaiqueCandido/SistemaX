package equipeDFK.sistemaX.dao;

import equipeDFK.sistemaX.conexao.ClasseConexao;
import equipeDFK.sistemaX.conexao.ConnectionFactory;
import equipeDFK.sistemaX.entidades.Usuario;
import equipeDFK.sistemaX.interfaces.UsuarioDaoIF;
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
    public boolean cadastrar(Usuario u) throws SQLException {
        try {

            String SQL = "insert into usuario(email, nomedeusuario, senha, foto, tipo, matricula, status) values (?,?,?,?,?,?,?)";

            pstm = con.prepareStatement(SQL);
            pstm.setString(1, u.getEmail());
            pstm.setString(2, u.getNome());
            pstm.setString(3, u.getSenha());
            pstm.setString(4, u.getFoto());
            pstm.setString(5, u.getTipo());
            pstm.setString(6, u.getMatricula());
            pstm.setString(7, "Ativo");

            pstm.executeUpdate();
            return true;
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

            String SQL = "update usuario set email=?, nomedeusuario=?, senha=?, foto=?, matricula=?, tipo=? where id=?";

            pstm = con.prepareStatement(SQL);
            pstm.setString(1, u.getEmail());
            pstm.setString(2, u.getNome());
            pstm.setString(3, u.getSenha());
            pstm.setString(4, u.getFoto());
            pstm.setString(5, u.getMatricula());
            pstm.setString(6, u.getTipo());            
            pstm.setInt(7, u.getId());

            pstm.executeUpdate();
        } finally {
            co.liberar();
        }
    }

    @Override
    public Usuario pesquisarPorNomeDeUsuario(String nome) throws SQLException {
        try {
            String SQL = "select * from usuario where nomedeusuario ilike '%" + nome + "%'";

            pstm = con.prepareStatement(SQL);
            ResultSet result = pstm.executeQuery();

            Usuario usuario = new Usuario();

            while (result.next()) {
                usuario.setId(result.getInt("id"));
                usuario.setEmail(result.getString("email"));
                usuario.setNome(result.getString("nomedeusuario"));
                usuario.setSenha(result.getString("senha"));
                usuario.setFoto(result.getString("foto"));
                usuario.setTipo(result.getString("tipo"));
                usuario.setMatricula(result.getString("matricula"));
                usuario.setStatus(result.getString("status"));

                return usuario;
            }

            return null;
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
                usuario.setNome(result.getString("nomedeusuario"));
                usuario.setSenha(result.getString("senha"));
                usuario.setFoto(result.getString("foto"));
                usuario.setTipo(result.getString("tipo"));
                usuario.setMatricula(result.getString("matricula"));
                usuario.setStatus(result.getString("status"));

                return usuario;
            }

            return null;
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
                usuario.setNome(result.getString("nomedeusuario"));
                usuario.setSenha(result.getString("senha"));
                usuario.setFoto(result.getString("foto"));
                usuario.setTipo(result.getString("tipo"));
                usuario.setMatricula(result.getString("matricula"));
                usuario.setStatus(result.getString("status"));

                return usuario;
            }

            return null;
        } finally {
            co.liberar();
        }
    }

    @Override
    public Usuario logar(String login, String senha) throws SQLException {
        try {
            if (login.contains("@")) {
                Usuario u = this.pesquisarPorEmail(login);
                if (u != null) {
                    if (u.getSenha().equalsIgnoreCase(senha)) {
                        return u;
                    } else {
                        return null;
                    }
                } else {
                    return null;
                }

            } else {
                Usuario u = this.pesquisarPorNomeDeUsuario(login);
                if (u != null) {
                    if (u.getSenha().equalsIgnoreCase(senha)) {
                        return u;
                    } else {
                        return null;
                    }
                } else {
                    return null;
                }
            }

        } finally {
            co.liberar();
        }
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
                usuario.setNome(result.getString("nomedeusuario"));
                usuario.setSenha(result.getString("senha"));
                usuario.setFoto(result.getString("foto"));
                usuario.setTipo(result.getString("tipo"));
                usuario.setMatricula(result.getString("matricula"));
                usuario.setStatus(result.getString("status"));

                usuarios.add(usuario);
            }

            return usuarios.isEmpty() ? null : usuarios;
        } finally {
            co.liberar();
        }
    }
}
