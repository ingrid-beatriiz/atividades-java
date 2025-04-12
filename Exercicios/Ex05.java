import java.util.Scanner;

public class Ex05 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] vetor = new int[10];
        int pares = 0;

        for (int i = 0; i < 10; i++) {
            System.out.print("Digite um número: ");
            vetor[i] = sc.nextInt();
            if (vetor[i] % 2 == 0) pares++;
        }

        System.out.println("Quantidade de números pares: " + pares);
        sc.close();
    }
}