package Trabalho;

import java.util.ArrayList;
import java.util.List;

public class Livro extends Item {
	
    public String autor;

    public Livro(int codigo,String nome, double preco, int quantidade, String autor) {
        super(codigo, nome, preco, quantidade);
        this.autor = autor;
    }

    public String getAutor() {
    	   return autor;
    }

	@Override
	public String mostrarAtributos() {
		return "Código Produto - " + codigo + " - " + nome + "  - Preço R$ " + preco + "  - Quantidade:" + quantidade + "  - Autor: " + autor;
    // Aqui foi criado um metodo para exibir os atributos de Livro na tela quando chamado
	}
    
}

