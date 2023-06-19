package Trabalho;

public class Eletrodomestico extends Item {

    public String marca;
    public String voltagem;

    public Eletrodomestico(int codigo,String nome, double preco, int quantidade, String marca, String voltagem) {
        super(codigo,nome, preco, quantidade);
        this.marca = marca;
        this.voltagem = voltagem;
    }
    

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getVoltagem() {
        return voltagem;
    }

    public void setVoltagem(String voltagem) {
        this.voltagem = voltagem;
    }

    @Override
	public String mostrarAtributos() {
		return "Código Produto - " + codigo + " - " + nome + "  - Preço R$ " + preco + "  - Quantidade:" + quantidade + "  - Marca: " + marca;
	    // Aqui foi criado um metodo para exibir os atributos de Eletrodoméstico na tela quando chamado

	}
}
