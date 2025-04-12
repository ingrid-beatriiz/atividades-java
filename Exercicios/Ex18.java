import java.util.Scanner;

public class Ex18 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] vetor = new int[10];

        for (int i = 0; i < 10; i++) {
            System.out.print("Digite um número: ");
            vetor[i] = sc.nextInt();
        }

        System.out.print("Digite um número X: ");
        int x = sc.nextInt();

        System.out.println("Múltiplos de " + x + ":");
        for (int i = 0; i < 10; i++) {
            if (vetor[i] % x == 0) {
                System.out.println(vetor[i]);
            }
        }

        sc.close();
    }
}