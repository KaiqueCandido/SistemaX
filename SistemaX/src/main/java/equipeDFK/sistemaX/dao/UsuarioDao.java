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

/**
 * Classe entidade Usuario que persiste seus dados no banco de dados
 * @author Dijalma Silva <dijalmacz@gmail.com>
 */
public class UsuarioDao implements UsuarioDaoIF {

    ConnectionFactory factory = new ConnectionFactory();
    ClasseConexao co = new ClasseConexao();
    Connection con;
    PreparedStatement pstm;

    /**
     * Construtor Default
     */
    public UsuarioDao() {
        try {
            con = co.abrir();
        } catch (Exception e) {
        }
    }

    /**
     * Método que persiste um novo usuário no banco de dados.
     * @param u
     * @return boolean
     * @throws SQLException 
     */
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

    /**
     * Método que remove um usuário do banco de dados.
     * @param u
     * @throws SQLException 
     */
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

    /**
     * Método que atualiza as informações do usuário no banco de dados.
     * @param u
     * @throws SQLException 
     */
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

    /**
     * Método que retorna um usuário a partir de uma busca pelo nome do usuario 
     * no banco de dados.
     * @param nome
     * @return {@linkplain Usuario}
     * @throws SQLException 
     */
    @Override
    public Usuario pesquisarPorNomeDeUsuario(String nome) throws SQLException {
        try {
            String SQL = "select * from usuario where nomedeusuario = '" + nome + "'";

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

    /**
     * Método que retorna um usuário a partir de uma busca pelo email do usuario 
     * no banco de dados.
     * @param email
     * @return {@linkplain Usuario}
     * @throws SQLException 
     */
    @Override
    public Usuario pesquisarPorEmail(String email) throws SQLException {
        try {
            String SQL = "select * from usuario where email ='" + email + "'";

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

    /**
     * Método que retorna um usuário a partir de uma busca pela matrícula do usuario 
     * no banco de dados.
     * @param matricula
     * @return {@linkplain Usuario}
     * @throws SQLException 
     */
    @Override
    public Usuario pesquisarPorMatricula(String matricula) throws SQLException {
        try {
            String SQL = "select * from usuario where matricula='" + matricula + "'";

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
    
    /**
     * Método que retorna um usuário a partir de uma busca pelo id do usuario 
     * no banco de dados.
     * @param id
     * @return {@linkplain Usuario}
     * @throws SQLException 
     */
    @Override
    public Usuario pesquisarPorId(int id) throws SQLException {
        try {
            String SQL = "select * from usuario where id = '" + id + "'";

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

    /**
     * Faz uma busca no banco de dados afim de achar um usuário com os
     * parâmetros passados, e então retorná-lo, e ainda pode ser feita tanto 
     * pelo nome ou email do usuário.
     * @param login
     * @param senha
     * @return {@linkplain Usuario}
     * @throws SQLException 
     */
    @Override
    public Usuario logar(String login, String senha) throws SQLException {
        try {
            if (login.contains("@")) {
                Usuario u = this.pesquisarPorEmail(login);
                if (u != null) {
                    if (u.getSenha().equals(senha)) {
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
                    if (u.getSenha().equals(senha)) {
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

    /**
     * Método que retorna todos os usuários guardados no banco de dados.
     * @return {@linkplain List<Usuario>}
     * @throws SQLException 
     */
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
