package com.mycompany.interfaces;

import com.mycompany.entidades.Usuario;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface UsuarioDaoIF {
    
    public void cadastrar(Usuario u)throws SQLException;
    
    public void remover(Usuario u)throws SQLException;
    
    public void atualizar(Usuario u)throws SQLException;
    
    public Usuario pesquisar(String nome)throws SQLException;
    
    public Usuario pesquisarPorEmail(String email) throws SQLException;
    
    public boolean logar(String nome, String senha)throws SQLException;
    
    public List<Usuario> pesquisarUsuarios(String nome) throws SQLException;
    
    public Usuario pesquisarPorId(Integer id) throws SQLException;
    
    public void uploadFotoDePerfil(String caminho, Integer id) throws SQLException, IOException;
    
    public void transformaEmAdiministrador(Integer idUsuario, Integer idAmigo) throws SQLException, IOException;

}
