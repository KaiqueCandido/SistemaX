package com.mycompany.interfaces;

import com.mycompany.entidades.Usuario;
import java.sql.SQLException;
import java.util.List;

public interface UsuarioDaoIF {

    public void cadastrar(Usuario u) throws SQLException;

    public void remover(Usuario u) throws SQLException;

    public void atualizar(Usuario u) throws SQLException;

    public Usuario pesquisarPorNome(String nome) throws SQLException;

    public Usuario pesquisarPorEmail(String email) throws SQLException;

    public Usuario pesquisarPorMatricula(String matricula) throws SQLException;

    public boolean logar(String login, String senha) throws SQLException;

    public List<Usuario> listar() throws SQLException;

}
