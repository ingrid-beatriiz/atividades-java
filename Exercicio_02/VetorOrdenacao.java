import java.util.Scanner;

public class VetorOrdenacao {
    public static void preencherVetor(int[] v, int n) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < n; i++) {
            System.out.print("Digite o valor da posição " + i + ": ");
            v[i] = sc.nextInt();
        }
    }

    public static void imprimirVetor(int[] v, int n) {
        System.out.print("{ ");
        for (int i = 0; i < n; i++) {
            System.out.print(v[i]);
            if (i < n - 1) {
                System.out.print(", ");
            }
        }
        System.out.println(" }");
    }

    public static void ordenar(int[] v, int n) {
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (v[j] > v[j + 1]) {
                    int temp = v[j];
                    v[j] = v[j + 1];
                    v[j + 1] = temp;
                }
            }
        }
    }

    public static void imprimirMaiorImpar(int[] v, int n) {
        int maiorImpar = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (v[i] % 2 != 0 && v[i] > maiorImpar) {
                maiorImpar = v[i];
            }
        }
        if (maiorImpar == Integer.MIN_VALUE) {
            System.out.println("Não há números ímpares no vetor.");
        } else {
            System.out.println("Maior número ímpar: " + maiorImpar);
        }
    }

    public static void criarParesImpares(int[] v, int n, int[] pares, int[] impares) {
        int p = 0, im = 0;
        for (int i = 0; i < n; i++) {
            if (v[i] % 2 == 0) {
                pares[p++] = v[i];
            } else {
                impares[im++] = v[i];
            }
        }
        while (p < n) {
            pares[p++] = -1;
        }
        while (im < n) {
            impares[im++] = -1;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite o tamanho do vetor: ");
        int n = sc.nextInt();
        int[] vetor = new int[n];
        int[] pares = new int[n];
        int[] impares = new int[n];

        preencherVetor(vetor, n);
        System.out.println("Vetor original:");
        imprimirVetor(vetor, n);

        ordenar(vetor, n);
        System.out.println("Vetor ordenado:");
        imprimirVetor(vetor, n);

        imprimirMaiorImpar(vetor, n);

        criarParesImpares(vetor, n, pares, impares);
        System.out.println("Vetor de pares:");
        imprimirVetor(pares, n);
        System.out.println("Vetor de ímpares:");
        imprimirVetor(impares, n);

        sc.close();
    }
}