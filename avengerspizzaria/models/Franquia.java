package avengerspizzaria.models;

public class Franquia {
    private int id;
    private String nome;
    private String endereco;
    private int fornecedor;

    public Franquia(String nome, String endereco, int fornecedor) throws Exception {
        this.setNome(nome);
        this.setEndereco(endereco);
        this.setFornecedor(fornecedor);
    }

    public Franquia(int id, String nome, String endereco, int fornecedor) throws Exception {
        this(nome, endereco, fornecedor);
        this.setId(id);
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) throws Exception {
        if (nome.length() == 0)
            throw new Exception("Nome não pode ser vazio");

        this.nome = nome;
    }

    public String getEndereco() {
        return this.endereco;
    }

    public void setEndereco(String endereco) throws Exception {
        if (endereco.length()== 0)
            throw new Exception("Endereço não pode ser vazio");

        this.endereco = endereco;
    }

    public int getFornecedor() {
        return this.fornecedor;
    }

    public void setFornecedor(int fornecedor) throws Exception {
        if (fornecedor == -1)
            throw new Exception("Fornecedor não pode ser vazio");

        this.fornecedor = fornecedor;
    }
}