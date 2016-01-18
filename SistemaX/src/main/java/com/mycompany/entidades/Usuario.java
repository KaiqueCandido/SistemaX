package com.mycompany.entidades;

import java.util.Objects;

public class Usuario {

    private Integer id;
    private String email;
    private String nome;
    private String senha;
    private String foto;
    private String tipo;
    private String matricula;

    public Usuario(Integer id, String email, String nome, String senha, String foto, String tipo, String matricula) {
        this.id = id;
        this.email = email;
        this.nome = nome;
        this.senha = senha;
        this.foto = foto;
        this.tipo = tipo;
        this.matricula = matricula;
    }

    public Usuario() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

}
