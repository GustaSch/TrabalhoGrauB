package programaControleDeEstoque;

public class Eletrodomesticos extends Item{
    private int voltagem;
    private String marca;
    
    public Eletrodomesticos(String descricao, float valor, int codigo, int voltagem, String marca) {
        super(descricao, valor, codigo);
        this.voltagem = voltagem;
        this.marca = marca;
    }

    public int getVoltagem() {
        return voltagem;
    }

    public void setVoltagem(int voltagem) {
        this.voltagem = voltagem;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    
    
}
