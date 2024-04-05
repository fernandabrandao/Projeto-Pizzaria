package avengerspizzaria.models;

public class TipoIngrediente {
    private int id;
    private String nome;

    public TipoIngrediente(String nome) throws Exception {
        this.setNome(nome);
    }

    public TipoIngrediente(int id, String nome) throws Exception {
        this(nome);
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
}