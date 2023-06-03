package programaControleDeEstoque;

public class Livros extends Item{
    private String autor;

    public Livros(String descricao, float valor, int codigo, String autor) {
        super(descricao, valor, codigo);
        this.autor = autor;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    
}
