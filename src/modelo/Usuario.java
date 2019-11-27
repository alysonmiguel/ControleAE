package modelo;

public class Usuario {

    private int idUsuario, senha;
    private String nome, email, funcao, login;

    public Usuario(String nome, String email, String funcao, String login, int senha) {
        this.senha = senha;
        this.nome = nome;
        this.email = email;
        this.funcao = funcao;
        this.login = login;
    }
    
public Usuario(int idUsuario, int senha,String login) {
        this.idUsuario = idUsuario;
        this.senha = senha;
        this.nome = nome;
}
    public Usuario(int idUsuario, int senha, String nome, String email, String funcao, String login) {
        this.idUsuario = idUsuario;
        this.senha = senha;
        this.nome = nome;
        this.email = email;
        this.funcao = funcao;
        this.login = login;
    }

    public Usuario(String login, int senha) {
        this.senha = senha;
        this.login = login;
    }
    
    public Usuario(String nome) {
        this.nome = nome;
    }

    public Usuario() {

    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getSenha() {
        return senha;
    }

    public void setSenha(int senha) {
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Override
    public String toString() {
        return nome;
    }

}
