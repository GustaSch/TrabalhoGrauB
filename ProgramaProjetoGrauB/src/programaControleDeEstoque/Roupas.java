package programaControleDeEstoque;

public class Roupas extends Item{
    
    private String tamanho;
    private String marca;
    
    public Roupas(String descricao, float valor, int codigo, String tamanho, String marca) {
        super(descricao, valor, codigo);
        this.tamanho = tamanho;
        this.marca = marca;
    }
    
    public String getTamanho() {
        return tamanho;
    }
    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }
    public String getMarca() {
        return marca;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }

    
}
