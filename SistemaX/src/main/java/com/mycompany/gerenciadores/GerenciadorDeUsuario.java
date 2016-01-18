package com.mycompany.gerenciadores;

import com.mycompany.entidades.Usuario;
import com.mycompany.fabricas.DaoFactory;
import com.mycompany.fabricas.DaoFactoryIF;
import com.mycompany.interfaces.UsuarioDaoIF;
import java.sql.SQLException;
import java.util.List;

public class GerenciadorDeUsuario {

    public void cadastrar(Usuario u) throws SQLException {
        Usuario novoUsu = new Usuario();

        novoUsu.setEmail(u.getEmail());
        novoUsu.setNome(u.getNome());
        novoUsu.setSenha(u.getSenha());
        novoUsu.setFoto(u.getFoto());
        novoUsu.setTipo(u.getTipo());
        novoUsu.setTipo(u.getMatricula());

        DaoFactoryIF fabrica = DaoFactory.creatFactory();
        UsuarioDaoIF usuDao = fabrica.criaUsuarioDao();
        usuDao.cadastrar(novoUsu);
    }

    public void remover(Usuario u) throws SQLException {
        DaoFactoryIF fabrica = DaoFactory.creatFactory();
        UsuarioDaoIF usuDao = fabrica.criaUsuarioDao();
        usuDao.remover(u);
    }

    public void atualizar(Usuario u) throws SQLException {
        DaoFactoryIF fabrica = DaoFactory.creatFactory();
        UsuarioDaoIF usuDao = fabrica.criaUsuarioDao();
        usuDao.atualizar(u);
    }

    public Usuario pesquisarPorNome(String nome) throws SQLException {
        DaoFactoryIF fabrica = DaoFactory.creatFactory();
        UsuarioDaoIF usuDao = fabrica.criaUsuarioDao();
        return usuDao.pesquisarPorNome(nome);
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

    public boolean logar(String login, String senha) throws SQLException {
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
