package equipeDFK.sistemaX.gerenciadores;

import equipeDFK.sistemaX.entidades.Usuario;
import equipeDFK.sistemaX.fabricas.DaoFactory;
import equipeDFK.sistemaX.fabricas.DaoFactoryIF;
import equipeDFK.sistemaX.interfaces.UsuarioDaoIF;
import java.sql.SQLException;
import java.util.List;

public class GerenciadorDeUsuario {

    public boolean cadastrar(Usuario u) throws SQLException {       
        DaoFactoryIF fabrica = DaoFactory.creatFactory();
        UsuarioDaoIF usuDao = fabrica.criaUsuarioDao();
        return usuDao.cadastrar(u);
    }

    public void remover(Usuario u) throws SQLException {
        DaoFactoryIF fabrica = DaoFactory.creatFactory();
        UsuarioDaoIF usuDao = fabrica.criaUsuarioDao();
        usuDao.remover(u);
    }

    public void atualizar(Usuario u, Usuario atualizado) throws SQLException {
        DaoFactoryIF fabrica = DaoFactory.creatFactory();
        UsuarioDaoIF usuDao = fabrica.criaUsuarioDao();
        
        atualizado.setEmail(u.getEmail());
        atualizado.setFoto(u.getFoto());
        atualizado.setId(u.getId());
        atualizado.setMatricula(u.getMatricula());
        atualizado.setNome(u.getNome());
        atualizado.setSenha(u.getSenha());
        atualizado.setStatus(u.getStatus());
        atualizado.setTipo(u.getTipo());        
        
        usuDao.atualizar(atualizado);
    }

    public Usuario pesquisarPorNomeDeUsuario(String nome) throws SQLException {
        DaoFactoryIF fabrica = DaoFactory.creatFactory();
        UsuarioDaoIF usuDao = fabrica.criaUsuarioDao();
        return usuDao.pesquisarPorNomeDeUsuario(nome);
    }

    public Usuario pesquisarPorEmail(String email) throws SQLException {
        DaoFactoryIF fabrica = DaoFactory.creatFactory();
        UsuarioDaoIF usuDao = fabrica.criaUsuarioDao();
        return usuDao.pesquisarPorEmail(email);
    }

    public Usuario pesquisarPorMatricula(String matricula) throws SQLException {
        DaoFactoryIF fabrica = DaoFactory.creatFactory();
        UsuarioDaoIF usuDao = fabrica.criaUsuarioDao();
        return usuDao.pesquisarPorMatricula(matricula);
    }

    /**
     * Função para verificar e auntenticar usuário no sistema
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

    public List<Usuario> listar() throws SQLException {
        DaoFactoryIF fabrica = DaoFactory.creatFactory();
        UsuarioDaoIF usuDao = fabrica.criaUsuarioDao();
        return usuDao.listar();
    }
}
