package com.mycompany.gerenciadores;

import Convercoes.Data;
import com.mycompany.entidades.Usuario;
import com.mycompany.fabricas.DaoFactory;
import com.mycompany.fabricas.DaoFactoryIF;
import Interfaces.UsuarioDaoIF;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class GerenciadorDeUsuario {

    public void adicionarUsuario(String email, String nome, String apelido, String senha, String cidade, String estado, String dataNasc, String fot, boolean tipo) throws SQLException {
        Usuario novoUsu = new Usuario();
        Convercoes.Data data = new Data();
        novoUsu.setEmail(email);
        novoUsu.setNome(nome);
        novoUsu.setApelido(apelido);
        novoUsu.setSenha(senha);
        novoUsu.setCidade(cidade);
        novoUsu.setEstado(estado);
        novoUsu.setDataNasc(data.stringParaDate(dataNasc));
        novoUsu.setFoto(fot);
        novoUsu.setTipo(tipo);

        DaoFactoryIF fabrica = DaoFactory.creatFactory();
        UsuarioDaoIF usuDao = fabrica.criaUsuarioDao();
        usuDao.cadastrar(novoUsu);
    }

    public void removerUsuario(Usuario u) throws SQLException {
        DaoFactoryIF fabrica = DaoFactory.creatFactory();
        UsuarioDaoIF usuDao = fabrica.criaUsuarioDao();
        usuDao.remover(u);
    }

    public void atualizaUsuario(Usuario u) throws SQLException {
        DaoFactoryIF fabrica = DaoFactory.creatFactory();
        UsuarioDaoIF usuDao = fabrica.criaUsuarioDao();
        usuDao.atualizar(u);
    }

    public Usuario pesquisarUsuario(String nome) throws SQLException {
        DaoFactoryIF fabrica = DaoFactory.creatFactory();
        UsuarioDaoIF usuDao = fabrica.criaUsuarioDao();
        return usuDao.pesquisar(nome);
    }
    public Usuario pesquisarPorEmail(String email) throws SQLException{
        DaoFactoryIF fabrica = DaoFactory.creatFactory();
        UsuarioDaoIF usuDao = fabrica.criaUsuarioDao();
        return usuDao.pesquisarPorEmail(email);
    }

    public boolean logar(String nome, String senha) throws SQLException {
        DaoFactoryIF fabrica = DaoFactory.creatFactory();
        UsuarioDaoIF usuDao = fabrica.criaUsuarioDao();
        return usuDao.logar(nome, senha);
    }

    public List<Usuario> pesquisarUsuarios(String nome) throws SQLException {
        DaoFactoryIF fabrica = DaoFactory.creatFactory();
        UsuarioDaoIF usuDao = fabrica.criaUsuarioDao();
        return usuDao.pesquisarUsuarios(nome);
    }

    public Usuario pesquisarPorId(Integer id) throws SQLException {
        DaoFactoryIF fabrica = DaoFactory.creatFactory();
        UsuarioDaoIF usuDao = fabrica.criaUsuarioDao();
        return usuDao.pesquisarPorId(id);
    }
    
    public void uploadFotoDePerfil(String caminho, Integer id) throws SQLException, IOException{
        DaoFactoryIF fabrica = DaoFactory.creatFactory();
        UsuarioDaoIF usuDao = fabrica.criaUsuarioDao();
        usuDao.uploadFotoDePerfil(caminho, id);
    }
    
    public void transformaEmAdiministrador(Integer idUsuario, Integer idAmigo) throws SQLException, IOException{
        DaoFactoryIF fabrica = DaoFactory.creatFactory();
        UsuarioDaoIF usuDao = fabrica.criaUsuarioDao();
        usuDao.transformaEmAdiministrador(idUsuario, idAmigo);
    }
}
