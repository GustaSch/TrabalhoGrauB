package Trabalho;

public abstract class Item {
	
	public static int proximoCodigo = 1;

	public int codigo;
	public String nome;
	public double preco;
	public int quantidade;

	// Aqui foi criado um construtor 
	
    public Item(int codigo,String nome, double preco, int quantidade) {
        this.codigo = codigo;
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
    }
    
    public abstract String mostrarAtributos();

    // Aqui foi criado os gets e sets
    
    public int getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
   
	}


	}
    

