package Exercicio_04;

public class Produto {
    String nome;
    int qtd;
    double preco;
    String categoria;
    int qtdMinima;

    public Produto(String nome, int qtd, double preco, String categoria, int qtdMinima) {
        this.nome = nome;
        this.qtd = qtd;
        this.preco = preco;
        this.categoria = categoria;
        this.qtdMinima = qtdMinima;
    }

    public void exibir() {
        System.out.printf("%s - %d unidades - R$ %.2f - %s - mín: %d\n",
            nome, qtd, preco, categoria, qtdMinima);
    }
}


