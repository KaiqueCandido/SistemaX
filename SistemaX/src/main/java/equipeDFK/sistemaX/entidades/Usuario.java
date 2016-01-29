package equipeDFK.sistemaX.entidades;

/**
 * Classe que representa entidade Usuario
 *
 * @author Dijalma Silva <dijalmacz@gmail.com>
 */
public class Usuario {

    private Integer id;
    private String email;
    private String nome;
    private String senha;
    private String foto;
    private String tipo;
    private String matricula;
    private String status;

    public Usuario(String email, String nome, String senha, String foto, String tipo, String matricula, String status) {
        this.email = email;
        this.nome = nome;
        this.senha = senha;
        this.foto = foto;
        this.tipo = tipo;
        this.matricula = matricula;
        this.status = status;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", email=" + email + ", nome=" + nome + ", senha=" + senha + ", foto=" + foto + ", tipo=" + tipo + ", matricula=" + matricula + ", status=" + status + '}';
    }

}
