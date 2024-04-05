package avengerspizzaria.models;

public class Ingrediente {
    private int id;
    private String nome;
    private int tipo;

    public Ingrediente(String nome, int tipo) throws Exception {
        this.setNome(nome);
        this.setTipo(tipo);
    }

    public Ingrediente(int id, String nome, int tipo) throws Exception {
        this(nome, tipo);
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
    
    public int getTipo() {
        return tipo;
    }
    
    public void setTipo(int tipo) throws Exception {
        if (tipo == 0)
            throw new Exception("Tipo não pode ser vazio");
        
        this.tipo = tipo;
    }

    public Object[] adctabela(){
        return new Object[] { nome };
    }
    
}
