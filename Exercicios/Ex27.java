import java.util.Scanner;

public class Ex27 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] vetor = new int[10];

        for (int i = 0; i < 10; i++) {
            System.out.print("Digite o número " + (i+1) + ": ");
            vetor[i] = sc.nextInt();
        }

        System.out.println("Números primos e suas posições:");
        for (int i = 0; i < 10; i++) {
            if (isPrimo(vetor[i])) {
                System.out.println("Valor " + vetor[i] + " na posição " + i);
            }
        }

        sc.close();
    }

    public static boolean isPrimo(int n) {
        if (n <= 1) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}