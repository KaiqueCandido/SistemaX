package equipeDFK.sistemaX.interfaces;

import equipeDFK.sistemaX.entidades.Usuario;
import java.sql.SQLException;
import java.util.List;

/**
 * Interface UsuarioDaoIF
 * 
 * @author Dijalma Silva <dijalmacz@gmail.com>
 */
public interface UsuarioDaoIF {

    public boolean cadastrar(Usuario u) throws SQLException;

    public void remover(Usuario u) throws SQLException;

    public void atualizar(Usuario u) throws SQLException;

    public Usuario pesquisarPorNomeDeUsuario(String nome) throws SQLException;

    public Usuario pesquisarPorEmail(String email) throws SQLException;

    public Usuario pesquisarPorMatricula(String matricula) throws SQLException;
    
    public Usuario pesquisarPorId(int id) throws SQLException;

    public Usuario logar(String login, String senha) throws SQLException;

    public List<Usuario> listar() throws SQLException;

}
