package Trabalho;


import java.util.ArrayList;
import java.util.List;

public class Estoque {
    private List<Item> estoque;

    public Estoque() {
        this.estoque = new ArrayList<>();
    }

    public void adicionarItem(Item item) {
        estoque.add(item);
    }

    public void removerQuantidadeItem(Item item, int quantidade) {
        item.setQuantidade(item.getQuantidade() - quantidade);
    }

    public <T extends Item> List<T> getProdutosPorTipo(Class<T> tipoProduto) {
        List<T> produtosFiltrados = new ArrayList<>();
        for (Item item : estoque) {
            if (tipoProduto.isInstance(item)) {
                produtosFiltrados.add(tipoProduto.cast(item));
            }
        }
        return produtosFiltrados;
    }

    public void adicionarQuantidadeItem(Item item, int quantidade) {
        for (Item estoqueItem : estoque) {
            if (estoqueItem.getCodigo() == item.getCodigo()) {
                estoqueItem.setQuantidade(estoqueItem.getQuantidade() + quantidade);
                break;
            }
        }
    }

    // Método para adicionar a quantidade de um item de volta ao estoque
    public void adicionarQuantidadeRemovida(Item item, int quantidade) {
        for (Item estoqueItem : estoque) {
            if (estoqueItem.getCodigo() == item.getCodigo()) {
                estoqueItem.setQuantidade(estoqueItem.getQuantidade() + quantidade);
                break;
            }
        }
    }
}
