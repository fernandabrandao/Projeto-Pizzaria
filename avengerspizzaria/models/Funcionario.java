package avengerspizzaria.models;

public class Funcionario {
    private int id;
    private String nome;
    private String DataNasc;
    private String cpf;
    private String endereco;
    private String email;
    private String telefone;
    private int usuario;
    private int franquia;

    public Funcionario(String nome, String dtNasc, String cpf, String endereco, String email, String telefone, int usuario, int franquia) throws Exception {
        this.setNome(nome);
        this.setDtNasc(dtNasc);
        this.setCpf(cpf);
        this.setEndereco(endereco);
        this.setEmail(email);
        this.setTelefone(telefone);
        this.setUsuario(usuario);
        this.setFranquia(franquia);
    }

    public Funcionario(int id, String nome, String dtNasc, String cpf, String endereco, String email, String telefone, int usuario, int franquia) throws Exception {
        this(nome, dtNasc, cpf, endereco, email, telefone, usuario, franquia);
        this.setId(id);
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) throws Exception {
        if (nome.length() == 0)
            throw new Exception("Nome não pode ser vazio");

        this.nome = nome;
    }

    public String getDtNasc() {
        return DataNasc;
    }

    public void setDtNasc(String DataNasc) throws Exception {
        if (DataNasc.length() == 0)
            throw new Exception("Data de nascimento não pode ser vazio");

        this.DataNasc = DataNasc;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) throws Exception {
        if (cpf.length() == 0)
            throw new Exception("CPF não pode ser vazio");

        this.cpf = cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) throws Exception {
        if (endereco.length() == 0)
            throw new Exception("Endereço não pode ser vazio");

        this.endereco = endereco;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) throws Exception {
        if (email.length() == 0)
            throw new Exception("Email não pode ser vazio");

        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) throws Exception {
        if (telefone.length() == 0)
            throw new Exception("Telefone não pode ser vazio");

        this.telefone = telefone;
    }

    public int getUsuario() {
        return usuario;
    }

    public void setUsuario(int usuario) throws Exception{
        if (usuario == 0)
            throw new Exception("Usuário não pode ser vazio");

        this.usuario = usuario;
    }

    public int getFranquia() {
        return franquia;
    }

    public void setFranquia(int franquia) throws Exception{
        if (franquia == 0)
            throw new Exception("Franquia não pode ser vazio");

        this.franquia = franquia;
    }
}