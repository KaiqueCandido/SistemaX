package equipeDFK.sistemaX.gerenciadores;

import equipeDFK.sistemaX.entidades.Usuario;
import equipeDFK.sistemaX.fabricas.DaoFactory;
import equipeDFK.sistemaX.fabricas.DaoFactoryIF;
import equipeDFK.sistemaX.interfaces.UsuarioDaoIF;
import java.sql.SQLException;
import java.util.List;

/**
 * Classe responsável pela regra de negócio do usuario
 *
 * @author Dijalma Silva <dijalmacz@gmail.com>
 */
public class GerenciadorDeUsuario {

    /**
     * Método que cadastra um usuário e retorna um valor booleano true para
     * sucesso false para erro
     *
     * @param u
     * @return boolean
     * @throws SQLException
     */
    public boolean cadastrar(Usuario u) throws SQLException {
        DaoFactoryIF fabrica = DaoFactory.creatFactory();
        UsuarioDaoIF usuDao = fabrica.criaUsuarioDao();
        return usuDao.cadastrar(u);
    }

    /**
     * Método que remove um usuário
     *
     * @param u
     * @throws SQLException
     */
    public void remover(Usuario u) throws SQLException {
        DaoFactoryIF fabrica = DaoFactory.creatFactory();
        UsuarioDaoIF usuDao = fabrica.criaUsuarioDao();
        usuDao.remover(u);
    }

    /**
     * Método que atualiza um usuário
     *
     * @param u
     * @throws SQLException
     */
    public void atualizar(Usuario u) throws SQLException {
        DaoFactoryIF fabrica = DaoFactory.creatFactory();
        UsuarioDaoIF usuDao = fabrica.criaUsuarioDao();
        usuDao.atualizar(u);
    }

    /**
     * Método que retorna um {@linkplain Usuario} através de uma busca feita
     * pelo nome.
     *
     * @param nome
     * @return {@linkplain Usuario}
     * @throws SQLException
     */
    public Usuario pesquisarPorNomeDeUsuario(String nome) throws SQLException {
        DaoFactoryIF fabrica = DaoFactory.creatFactory();
        UsuarioDaoIF usuDao = fabrica.criaUsuarioDao();
        return usuDao.pesquisarPorNomeDeUsuario(nome);
    }

    /**
     * Método que retorna um {@linkplain Usuario} através de uma busca feita
     * pelo email.
     *
     * @param email
     * @return {@linkplain Usuario}
     * @throws SQLException
     */
    public Usuario pesquisarPorEmail(String email) throws SQLException {
        DaoFactoryIF fabrica = DaoFactory.creatFactory();
        UsuarioDaoIF usuDao = fabrica.criaUsuarioDao();
        return usuDao.pesquisarPorEmail(email);
    }

    /**
     * Método que retorna um {@linkplain Usuario} através de uma busca feita
     * pela matrícula
     *
     * @param matricula
     * @return {@linkplain Usuario}
     * @throws SQLException
     */
    public Usuario pesquisarPorMatricula(String matricula) throws SQLException {
        DaoFactoryIF fabrica = DaoFactory.creatFactory();
        UsuarioDaoIF usuDao = fabrica.criaUsuarioDao();
        return usuDao.pesquisarPorMatricula(matricula);
    }

    /**
     * Método que retorna {@linkplain Usuario} através de uma busca feita pelo
     * id
     *
     * @param id
     * @return {@linkplain Usuario}
     * @throws SQLException
     */
    public Usuario pesquisarPorId(int id) throws SQLException {
        DaoFactoryIF fabrica = DaoFactory.creatFactory();
        UsuarioDaoIF usuDao = fabrica.criaUsuarioDao();
        return usuDao.pesquisarPorId(id);
    }

    /**
     * Função para verificar e auntenticar usuário no sistema, através do email
     * ou nome
     *
     * @param login
     * @param senha
     * @return {@linkplain Usuario}
     * @throws SQLException
     */
    public Usuario logar(String login, String senha) throws SQLException {
        DaoFactoryIF fabrica = DaoFactory.creatFactory();
        UsuarioDaoIF usuDao = fabrica.criaUsuarioDao();
        return usuDao.logar(login, senha);
    }

    /**
     * Método que retorna todos os usuários
     *
     * @return {@linkplain List}
     * @throws SQLException
     */
    public List<Usuario> listar() throws SQLException {
        DaoFactoryIF fabrica = DaoFactory.creatFactory();
        UsuarioDaoIF usuDao = fabrica.criaUsuarioDao();
        return usuDao.listar();
    }
}
