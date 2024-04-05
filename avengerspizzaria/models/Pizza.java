package avengerspizzaria.models;

public class Pizza {
    private int id;
    private String nome;
    private String tamanho;
    private double preco;

    public Pizza(String nome, double preco, String tamanho) throws Exception {
        this.setNome(nome);
        this.setTamanho(tamanho);
        this.setPreco(preco);
    }

    public Pizza(int id, String nome, double preco, String tamanho) throws Exception {
        this(nome, preco, tamanho);
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

    public double getPreco() {
        return this.preco;
    }

    public void setPreco(double preco) throws Exception {
        if (preco == 0)
            throw new Exception("Preço não pode ser vazio");
        
        this.preco = preco;
    }
    
    public String getTamanho() {
        return this.tamanho;
    }

    public void setTamanho(String tamanho) throws Exception {
        if (tamanho.length() == 0)
            throw new Exception("Tamanho não pode ser vazio");
        
        this.tamanho = tamanho;
    }
}