package programaControleDeEstoque;

public class Eletronicos extends Item {
    
    private String marca;
    
    public Eletronicos(String descricao, float valor, int codigo, String marca) {
        super(descricao, valor, codigo);
        this.marca = marca;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    
}
