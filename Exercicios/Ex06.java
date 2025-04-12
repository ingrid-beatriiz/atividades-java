import java.util.Scanner;

public class Ex06 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] vetor = new int[10];

        for (int i = 0; i < 10; i++) {
            System.out.print("Digite um número: ");
            vetor[i] = sc.nextInt();
        }

        int maior = vetor[0];
        int menor = vetor[0];

        for (int i = 1; i < 10; i++) {
            if (vetor[i] > maior) maior = vetor[i];
            if (vetor[i] < menor) menor = vetor[i];
        }

        System.out.println("Maior valor: " + maior);
        System.out.println("Menor valor: " + menor);

        sc.close();
    }
}