package Trabalho;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Carrinho {
    private List<Item> itens;
    private float total;

    public Carrinho() {
        this.itens = new ArrayList<>();
    }

    public void adicionarItem(Item item) {
        itens.add(item);
    }

    public void removerItem(Item item, int quantidade) {
        if (itens.contains(item)) {
            int index = itens.indexOf(item);
            Item itemNoCarrinho = itens.get(index);

            if (quantidade >= itemNoCarrinho.getQuantidade()) {
                itens.remove(itemNoCarrinho);
            } else {
                itemNoCarrinho.setQuantidade(itemNoCarrinho.getQuantidade() - quantidade);
            }

            System.out.println("Item removido com sucesso.");
        } else {
            System.out.println("Item não encontrado no carrinho.");
        }
    }

    public void exibirCarrinho() {
        if (itens.isEmpty()) {
            System.out.println("\nO carrinho está vazio.\n");
        } else {
            System.out.println("----------- Seu Carrinho -----------");
            float total = 0;

            for (Item item : itens) {
                float totalProduto = (float) item.getPreco() * item.getQuantidade();
                total += totalProduto;

                System.out.printf("Código: %d | Produto: %s | Preço unitário: %.2f | Quantidade: %d | Total: R$ %.2f\n",
                        item.getCodigo(), item.getNome(), item.getPreco(), item.getQuantidade(), totalProduto);
            }

            System.out.printf("Valor final da compra: R$ %.2f\n", total);

            Scanner ler = new Scanner(System.in);
            System.out.println("\nInforme a operação desejada:");
            System.out.println("1 - Cartão de crédito");
            System.out.println("2 - Boleto");
            System.out.println("3 - Cartão de débito");
            System.out.println("4 - Remover item do carrinho");
            System.out.println("5 - Zerar carrinho");
            System.out.println("0 - Continuar comprando");
            int opcao = ler.nextInt();

            if (opcao == 1) {
                // Opção para pagamento no cartão de crédito
                System.out.println("Informe seu nome completo:");
                ler.nextLine(); // Limpa o buffer
                String nome = ler.nextLine();
                System.out.println("Informe o seu e-mail:");
                ler.nextLine(); // Limpa o buffer
                System.out.println("Digite o número do cartão de crédito:");
                ler.nextLine(); // Limpa o buffer

                System.out.println("Digite o código de segurança do cartão:");
                int codigoSeguranca = ler.nextInt();
                System.out.println("Digite a data de validade do cartão (MM/AA):");
                String dataValidade = ler.next();
                String[] partesData = dataValidade.split("/");

                int mesValidade = Integer.parseInt(partesData[0]);
                int anoValidade = Integer.parseInt(partesData[1]);

                if (anoValidade < 23 || (anoValidade == 23 && mesValidade < 6)) {
                    System.out.println("Cartão vencido. Por favor, informe uma data de válida.\n");
                    return;
                }

                System.out.println("Cartão Aceito!\n");

                System.out.println("Quantas vezes deseja parcelar? (até 6x sem juros)");
                int parcelamento = ler.nextInt();

                if (parcelamento <= 6) {
                    System.out.println("Compra realizada com sucesso!\n");
                    System.out.println("Em alguns instantes você receberá um e-mail com o código de rastreio.\n");
                } else {
                    System.out.println("Quantidade de parcelas excede o limite.\n");
                }
            } else if (opcao == 2) {
                // Opção para pagamento no boleto
                System.out.println("Informe seu nome completo:");
                ler.nextLine(); // Limpa o buffer
                String nome = ler.nextLine();
                System.out.println("Informe o seu e-mail:");
                String email = ler.next();

                System.out.println("Compra realizada com sucesso! Em alguns instantes, você receberá um e-mail com o boleto para pagar.\n");
                System.out.println("Lembrando que são 4 dias úteis para efetuar o pagamento. Caso contrário, a compra será cancelada.\n");
            } else if (opcao == 3) {
                // Opção para pagamento no cartão de débito
                System.out.println("Informe seu nome completo:");
                ler.nextLine(); // Limpa o buffer
                String nome = ler.nextLine();
                System.out.println("Informe o seu e-mail:");
                String email = ler.next();
                System.out.println("Digite o número do cartão de crédito:");
                String numeroCartao = ler.nextLine();
                ler.nextLine(); // Limpa o buffer 
                System.out.println("Digite o código de segurança do cartão:");
                int codigoSeguranca = ler.nextInt();
                System.out.println("Digite a data de validade do cartão (MM/AA):");
                String dataValidade = ler.next();
                String[] partesData = dataValidade.split("/");
                int anoValidade = Integer.parseInt(partesData[1]);

                if (anoValidade < 23) {
                    System.out.println("Cartão vencido. Por favor, informe uma data de validade válida.\n");
                    return;
                }

                System.out.println("Cartão Aceito!\n");
                System.out.println("Compra finalizada com sucesso! Em instantes o comprovante chegará ao email.\n");
                System.out.println("Sessão finalizada ....... ");
                System.out.println("");
            } else if (opcao == 4) {
                // Opção para remover item do carrinho
                System.out.println("Digite o código do item que deseja remover:");
                int codigoItem = ler.nextInt();
                System.out.println("Digite a quantidade do item que deseja remover:");
                int quantidadeRemover = ler.nextInt();

                Item itemRemover = null;
                for (Item item : itens) {
                    if (item.getCodigo() == codigoItem) {
                        itemRemover = item;
                        break;
                    }
                }

                if (itemRemover != null) {
                    removerItem(itemRemover, quantidadeRemover);
                } else {
                    System.out.println("Item não encontrado no carrinho.");
                }
            } else if (opcao == 5) {
                // Opção para zerar carrinho
                itens.clear();
                System.out.println("Carrinho zerado.");
            } else if (opcao == 0) {
                System.out.println("Continuando comprando...");
            } else {
                System.out.println("Opção inválida. Pagamento não realizado.");
            }

        }
    }

    public String getItens() {
        return null;
    }

    public Item removerItemPorCodigo(int codigo) {
        return null;
    }

    public Estoque getEstoque() {
       return null;
    }

    public Item encontrarItemPorCodigo(int codigo) {
        return null;
    }

    public void removerQuantidadeItem(Item item, int quantidade) {

	}

	public Item getItemByCodigo(int codigoItemRemover) {
		return null;
	}
}
