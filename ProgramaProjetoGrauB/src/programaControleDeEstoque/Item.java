package programaControleDeEstoque;


public class Item {
    
    private String descricao;
    private float valor;
    private int codigo;
    
    public Item(String descricao, float valor, int codigo) {
        this.descricao = descricao;
        this.valor = valor;
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    @Override
    public String toString() {
        return "Item: \n" +
                "descricao = " + descricao +  "\n" +
                "valor = " + valor + "\n" +
                "codigo=" + codigo;
    }

    
}
