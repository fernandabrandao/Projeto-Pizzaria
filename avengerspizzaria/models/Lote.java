package avengerspizzaria.models;

public class Lote {
    private int id;
    private String dtCompra;
    private String dtValidade;
    private int qtd;
    private double preco;
    private int ingrediente;

    public Lote(String dtCompra, String dtValidade, int qtd, double preco, int ingrediente) throws Exception {
        this.setDtCompra(dtCompra);
        this.setDtValidade(dtValidade);
        this.setQtd(qtd);
        this.setPreco(preco);
        this.setIngrediente(ingrediente);
    }

    public Lote(int id, String dtCompra, String dtValidade, int qtd, double preco, int ingrediente) throws Exception {
        this(dtCompra, dtValidade, qtd, preco, ingrediente);
        this.setId(id);
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDtCompra() {
        return this.dtCompra;
    }

    public void setDtCompra(String dtCompra) throws Exception {
        if (dtCompra.length() == 0)
            throw new Exception("Data da compra não pode ser vazio");
        
        this.dtCompra = dtCompra;
    }

    public String getDtValidade() {
        return dtValidade;
    }

    public void setDtValidade(String dtValidade) throws Exception {
        if (dtValidade.length() == 0)
            throw new Exception("Data da validade não pode ser vazio");
                
        this.dtValidade = dtValidade;
    }

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) throws Exception {
        if (qtd == 0)
            throw new Exception("Quantidade não pode ser vazio");
        
        this.qtd = qtd;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) throws Exception {
        if (preco == 0)
            throw new Exception("Preço não pode ser vazio");
        
        this.preco = preco;
    }
    
    public int getIngrediente() {
        return ingrediente;
    }
    
    public void setIngrediente(int ingrediente) {
        this.ingrediente = ingrediente;
    }
}