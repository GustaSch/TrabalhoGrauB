package programaControleDeEstoque;


public class Item {
    
    private String descricao;
    private float valor;
    private int codigo;
    private int quantidade;
    
    public Item(String descricao, float valor, int codigo, int quantidade) {
        this.descricao = descricao;
        this.valor = valor;
        this.codigo = codigo;
        this.quantidade = quantidade;
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

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        return "Item: \n" +
                "descricao = " + descricao +  "\n" +
                "valor = " + valor + "\n" +
                "codigo=" + codigo;
    }

    
}
