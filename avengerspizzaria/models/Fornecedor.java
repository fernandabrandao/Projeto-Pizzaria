package avengerspizzaria.models;

public class Fornecedor {
    private int id;
    private String nome;
    private String cnpj;
    private String telefone;
    private String email;

    public Fornecedor(String nome, String cnpj, String telefone, String email) throws Exception {
        this.setNome(nome);
        this.setCnpj(cnpj);
        this.setTelefone(telefone);
        this.setEmail(email);
    }

    public Fornecedor(int id, String nome, String cnpj, String telefone, String email) throws Exception {
        this(nome, cnpj, telefone, email);
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

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) throws Exception{
        if (cnpj.length() == 0)
            throw new Exception("CNPJ não pode ser vazio");
        
        this.cnpj = cnpj;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) throws Exception {
        if (telefone.length() == 0)
            throw new Exception("Telefone não pode ser vazio");
        
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) throws Exception {
        if (email.length() == 0)
            throw new Exception("Email não pode ser vazio");
        
        this.email = email;
    } 
}