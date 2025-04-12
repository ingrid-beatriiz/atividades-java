import java.util.Scanner;

public class Ex08 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] vetor = new int[6];

        for (int i = 0; i < 6; i++) {
            System.out.print("Digite o valor " + (i + 1) + ": ");
            vetor[i] = sc.nextInt();
        }

        System.out.println("Valores em ordem inversa:");
        for (int i = 5; i >= 0; i--) {
            System.out.println(vetor[i]);
        }

        sc.close();
    }
}