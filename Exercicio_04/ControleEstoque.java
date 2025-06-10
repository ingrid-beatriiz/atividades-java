package Exercicio_04;

import java.util.Scanner;

public class ControleEstoque {

    public static Scanner input = new Scanner(System.in);
    public static Produto[] produtos = new Produto[100];
    public static int totalProdutos = 0;

    public static void main(String[] args) {
        int opcao;

        do {
            System.out.println("\n--- MENU ---");
            System.out.println("1 - Cadastrar produto");
            System.out.println("2 - Listar produtos");
            System.out.println("3 - Filtrar por categoria");
            System.out.println("4 - Ordenar por nome");
            System.out.println("5 - Remover produto");
            System.out.println("6 - Atualizar preço");
            System.out.println("7 - Subtotal por categoria");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = input.nextInt();
            input.nextLine(); 

            switch (opcao) {
                case 1: cadastrar(); break;
                case 2: listar(); break;
                case 3: filtrarCategoria(); break;
                case 4: ordenarPorNome(); break;
                case 5: remover(); break;
                case 6: atualizarPreco(); break;
                case 7: listarComSubtotal(); break;
                case 0: System.out.println("Saindo..."); break;
                default: System.out.println("Opção inválida.");
            }
        } while (opcao != 0);
    }

    public static void cadastrar() {
        if (totalProdutos < produtos.length) {
            System.out.print("Nome: ");
            String nome = input.nextLine();
            System.out.print("Qtd estoque: ");
            int qtd = input.nextInt();
            System.out.print("Preço unitário: ");
            double preco = input.nextDouble();
            input.nextLine();
            System.out.print("Categoria: ");
            String categoria = input.nextLine();
            System.out.print("Qtd mínima: ");
            int qtdMinima = input.nextInt();
            input.nextLine(); 

            produtos[totalProdutos] = new Produto(nome, qtd, preco, categoria, qtdMinima);
            totalProdutos++;
            System.out.println("Produto cadastrado!");
        } else {
            System.out.println("Limite de produtos atingido.");
        }
    }

    public static void listar() {
        for (int i = 0; i < totalProdutos; i++) {
            produtos[i].exibir();
        }
    }

    public static void filtrarCategoria() {
        System.out.print("Informe a categoria: ");
        String cat = input.nextLine();
        for (int i = 0; i < totalProdutos; i++) {
            if (produtos[i].categoria.equalsIgnoreCase(cat)) {
                produtos[i].exibir();
            }
        }
    }

    public static void ordenarPorNome() {
        for (int i = 0; i < totalProdutos - 1; i++) {
            for (int j = i + 1; j < totalProdutos; j++) {
                if (produtos[i].nome.compareToIgnoreCase(produtos[j].nome) > 0) {
                    Produto temp = produtos[i];
                    produtos[i] = produtos[j];
                    produtos[j] = temp;
                }
            }
        }
        System.out.println("Produtos ordenados por nome!");
    }

    public static void remover() {
        System.out.print("Informe o nome do produto para remover: ");
        String nome = input.nextLine();

        int pos = -1;
        for (int i = 0; i < totalProdutos; i++) {
            if (produtos[i].nome.equalsIgnoreCase(nome)) {
                pos = i;
                break;
            }
        }

        if (pos != -1) {
            for (int i = pos; i < totalProdutos - 1; i++) {
                produtos[i] = produtos[i + 1];
            }
            totalProdutos--;
            System.out.println("Produto removido.");
        } else {
            System.out.println("Produto não encontrado.");
        }
    }

    public static void atualizarPreco() {
        System.out.print("Informe o nome do produto para atualizar preço: ");
        String nome = input.nextLine();

        for (int i = 0; i < totalProdutos; i++) {
            if (produtos[i].nome.equalsIgnoreCase(nome)) {
                System.out.print("Novo preço: ");
                produtos[i].preco = input.nextDouble();
                input.nextLine();
                System.out.println("Preço atualizado.");
                return;
            }
        }
        System.out.println("Produto não encontrado.");
    }

    public static void listarComSubtotal() {
        String[] categoriasListadas = new String[100];
        int totalCategorias = 0;
        double totalGeral = 0;

        for (int i = 0; i < totalProdutos; i++) {
            String categoriaAtual = produtos[i].categoria;
            boolean jaListada = false;

            for (int j = 0; j < totalCategorias; j++) {
                if (categoriasListadas[j].equalsIgnoreCase(categoriaAtual)) {
                    jaListada = true;
                    break;
                }
            }

            if (!jaListada) {
                categoriasListadas[totalCategorias] = categoriaAtual;
                totalCategorias++;

                System.out.println("\nCategoria: " + categoriaAtual);
                double subtotal = 0;

                for (int k = 0; k < totalProdutos; k++) {
                    if (produtos[k].categoria.equalsIgnoreCase(categoriaAtual)) {
                        produtos[k].exibir();
                        subtotal += produtos[k].qtd * produtos[k].preco;
                    }
                }

                System.out.printf("Subtotal: R$ %.2f\n", subtotal);
                totalGeral += subtotal;
            }
        }

        System.out.printf("\nTOTAL GERAL: R$ %.2f\n", totalGeral);
    }
}