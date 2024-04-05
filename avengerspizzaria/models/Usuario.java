package avengerspizzaria.models;

public class Usuario {
    private int id;
    private String email;
    private String login;
    private String senha;

    public Usuario(String email, String login, String senha) throws Exception {
        this.setEmail(email);
        this.setLogin(login);
        this.setSenha(senha);
    }

    public Usuario(int id, String email, String login, String senha) throws Exception {
        this(email, login, senha);
        this.setId(id);
    }
    
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) throws Exception {
        if (email.length() == 0)
            throw new Exception("Email não pode ser vazio");
        
        this.email = email;
    }

    public String getLogin() {
        return this.login;
    }

    public void setLogin(String login) throws Exception {
        if (login.length() == 0)
            throw new Exception("Login não pode ser vazio");
        
        this.login = login;
    }

    public String getSenha() {
        return this.senha;
    }

    public void setSenha(String senha) throws Exception {
        if (senha.length() == 0)
            throw new Exception("Senha não pode ser vazio");
        
        this.senha = senha;
    }
}