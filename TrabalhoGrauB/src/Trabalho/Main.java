package Trabalho;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static Carrinho carrinho;

    public static void main(String[] args) {

        carrinho = new Carrinho();
        Estoque estoque = new Estoque();

        estoque.adicionarItem(new Livro(1, "Divergente", 35.90, 5, "Veronica Roth"));
        estoque.adicionarItem(new Livro(2, "Insurgente", 24.90, 8, "Veronica Roth"));
        estoque.adicionarItem(new Livro(3, "Convergente", 24.99, 5, "Veronica Roth"));
        estoque.adicionarItem(new Livro(4, "Quatro", 20.49, 7, "Veronica Roth"));
        estoque.adicionarItem(new Livro(5, "O Assassinato", 44.99, 10, "Agatha Christie"));

        estoque.adicionarItem(new Roupa(6, "Camiseta", 59.99, 10, "M", "Nike"));
        estoque.adicionarItem(new Roupa(7, "Calça", 129.99, 6, "G", "Adidas"));
        estoque.adicionarItem(new Roupa(8, "Bermuda", 79.99, 8, "G", "Fila"));
        estoque.adicionarItem(new Roupa(9, "Meia", 39.99, 10, "M", "Puma"));
        estoque.adicionarItem(new Roupa(10, "Polo", 99.99, 10, "GG", "Lacoste"));

        estoque.adicionarItem(new Eletrodomestico(11, "Geladeira", 1899.99, 2, "Brastemp", "110V"));
        estoque.adicionarItem(new Eletrodomestico(12, "Fogão", 1299.99, 3, "Electrolux", "220V"));
        estoque.adicionarItem(new Eletrodomestico(13, "Freezer", 1599.99, 2, "Brastemp", "110V"));
        estoque.adicionarItem(new Eletrodomestico(14, "Forno Microondas", 799.99, 3, "Philco", "220V"));
        estoque.adicionarItem(new Eletrodomestico(15, "Forno Elétrico", 499.99, 5, "Philco", "220V"));

        estoque.adicionarItem(new Eletronico(16, "Iphone x", 1999.90, 5, "Apple"));
        estoque.adicionarItem(new Eletronico(17, "Iphone 11", 2499.90, 7, "Apple"));
        estoque.adicionarItem(new Eletronico(18, "Iphone 12", 3999.90, 10, "Apple"));
        estoque.adicionarItem(new Eletronico(19, "Iphone 13", 5499.90, 3, "Apple"));
        estoque.adicionarItem(new Eletronico(20, "20 - Air pods", 999.90, 4, "Apple"));

        Scanner scanner = new Scanner(System.in);

        while (true) {
            exibirMenu();

            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer do teclado

            switch (opcao) {
                case 1:
                    exibirProdutos(estoque, Livro.class);
                    break;
                case 2:
                    exibirProdutos(estoque, Roupa.class);
                    break;
                case 3:
                    exibirProdutos(estoque, Eletrodomestico.class);
                    break;
                case 4:
                    exibirProdutos(estoque, Eletronico.class);
                    break;
                case 5:
                    System.out.println("Encerrando o programa...");
                    return;
                case 0:
                    carrinho.exibirCarrinho();
                    break;
                case 6:
                    retirarItemCarrinho(estoque);
                    break;
                case 7:
                    retirarQuantidadeCarrinho(estoque);
                    break;
                default:
                    System.out.println("Opção inválida. Por favor, tente novamente.");
            }
        }
    }

    public static void exibirMenu() {
        System.out.println("----- Menu -----");
        System.out.println("Selecione a categoria de produtos:");
        System.out.println("1. Livros");
        System.out.println("2. Roupas");
        System.out.println("3. Eletrodomésticos");
        System.out.println("4. Eletrônicos");
        System.out.println("5. Encerrar programa");
        System.out.println("6. Retirar item do carrinho");
        System.out.println("7. Retirar quantidade do carrinho");
        System.out.println("0. Exibir carrinho");

        System.out.print("Opção: ");
    }

    public static void exibirProdutos(Estoque estoque, Class<? extends Item> tipoProduto) {
        List<? extends Item> produtos = estoque.getProdutosPorTipo(tipoProduto);

        System.out.println("\n----- Produtos disponíveis -----");

        if (produtos.isEmpty()) {
            System.out.println("Nenhum produto disponível.");
        } else {
            for (Item produto : produtos) {
                System.out.println(produto.mostrarAtributos());
            }

            System.out.print("\nDigite o código do produto desejado (ou 0 para voltar):\n");

            Scanner scanner = new Scanner(System.in);
            int codigo = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer do teclado

            if (codigo != 0) {
                System.out.print("Digite a quantidade desejada:\n");
                int quantidade = scanner.nextInt();
                scanner.nextLine(); // Limpar o buffer do teclado

                Item produtoSelecionado = encontrarProdutoPorCodigo(produtos, codigo);

                if (produtoSelecionado != null) {
                    if (quantidade <= produtoSelecionado.getQuantidade()) {
                        Item itemCarrinho = criarItemCarrinho(produtoSelecionado, quantidade);
                        carrinho.adicionarItem(itemCarrinho);
                        estoque.removerQuantidadeItem(produtoSelecionado, quantidade);
                        System.out.println("Produto adicionado ao carrinho!\n");
                    } else {
                        System.out.println("Quantidade insuficiente em estoque!\n");
                    }
                } else {
                    System.out.println("Código do produto inválido!\n");
                }
            }
        }
    }

    public static Item encontrarProdutoPorCodigo(List<? extends Item> produtos, int codigo) {
        for (Item produto : produtos) {
            if (produto.getCodigo() == codigo) {
                return produto;
            }
        }
        return null;
    }

    public static Item criarItemCarrinho(Item produto, int quantidade) {
        Item itemCarrinho = null;

        if (produto instanceof Livro) {
            itemCarrinho = new Livro(produto.getCodigo(), produto.getNome(), produto.getPreco(), quantidade, ((Livro) produto).getAutor());
        } else if (produto instanceof Roupa) {
            itemCarrinho = new Roupa(produto.getCodigo(), produto.getNome(), produto.getPreco(), quantidade, ((Roupa) produto).getTamanho(), ((Roupa) produto).getMarca());
        } else if (produto instanceof Eletrodomestico) {
            itemCarrinho = new Eletrodomestico(produto.getCodigo(), produto.getNome(), produto.getPreco(), quantidade, ((Eletrodomestico) produto).getMarca(), ((Eletrodomestico) produto).getVoltagem());
        } else if (produto instanceof Eletronico) {
            itemCarrinho = new Eletronico(produto.getCodigo(), produto.getNome(), produto.getPreco(), quantidade, ((Eletronico) produto).getMarca());
        }

        return itemCarrinho;
    }
    
    public static void retirarItemCarrinho(Estoque estoque) {
        if (carrinho.getItens().isEmpty()) {
            System.out.println("O carrinho está vazio!");
            return;
        }
        
        System.out.print("Digite o código do item a ser retirado (ou 0 para voltar):\n");

        Scanner scanner = new Scanner(System.in);
        int codigo = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer do teclado

        if (codigo != 0) {
            Item itemRemovido = carrinho.removerItemPorCodigo(codigo);

            if (itemRemovido != null) {
                estoque.adicionarQuantidadeItem(itemRemovido, itemRemovido.getQuantidade());
                System.out.println("Item removido do carrinho!\n");
            } else {
                System.out.println("Código do item inválido!\n");
            }
        }
    }
    
    public static void retirarQuantidadeCarrinho(Estoque estoque) {
        if (carrinho.getItens().isEmpty()) {
            System.out.println("O carrinho está vazio!");
            return;
        }
        
        System.out.print("Digite o código do item para retirar quantidade (ou 0 para voltar):\n");

        Scanner scanner = new Scanner(System.in);
        int codigo = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer do teclado

        if (codigo != 0) {
            Item item = carrinho.encontrarItemPorCodigo(codigo);

            if (item != null) {
                System.out.print("Digite a quantidade a ser retirada:\n");
                int quantidade = scanner.nextInt();
                scanner.nextLine(); // Limpar o buffer do teclado

                if (quantidade <= item.getQuantidade()) {
                    carrinho.removerQuantidadeItem(item, quantidade);
                    estoque.adicionarQuantidadeItem(item, quantidade);
                    System.out.println("Quantidade retirada do carrinho!\n");
                } else {
                    System.out.println("Quantidade inválida!\n");
                }
            } else {
                System.out.println("Código do item inválido!\n");
            }
        }
    }
}
