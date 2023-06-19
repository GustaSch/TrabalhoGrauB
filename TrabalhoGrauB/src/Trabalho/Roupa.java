package Trabalho;

public class Roupa extends Item {
	
	public String tamanho;
	public String marca;

    public Roupa(int codigo,String nome, double preco, int quantidade, String tamanho, String marca) {
        super(codigo,nome, preco, quantidade);
        this.tamanho = tamanho;
        this.marca = marca;
    }

    public String getTamanho() {
        return tamanho;
    }
    
    public String getMarca() {
        return marca;
    }

	@Override
	public String mostrarAtributos() {
		return "Código Produto - " + codigo + " - " + nome + "  - Preço R$ " + preco + "  - Quantidade:" + quantidade + "  - Marca: " + marca;
	    // Aqui foi criado um metodo para exibir os atributos de Roupa na tela quando chamado

	}
}

