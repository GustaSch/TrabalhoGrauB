package Trabalho;

public class Eletronico extends Item {

	public String marca;

	public Eletronico(int codigo,String nome, double preco, int quantidade, String marca) {
		super(codigo, nome, preco, quantidade);
		this.marca = marca;
	}

	public String getMarca() {
		return marca;
	}

	@Override
	public String mostrarAtributos() {
		return "Código Produto - " + codigo + " - " + nome + "  - Preço R$ " + preco + "  - Quantidade:" + quantidade + "  - Marca: " + marca;

	    // Aqui foi criado um metodo para exibir os atributos de Eletrônico na tela quando chamado

	}
}
