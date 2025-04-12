import java.util.Scanner;

public class Ex02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] valores = new int[6];

        for (int i = 0; i < 6; i++) {
            System.out.print("Digite o valor " + (i+1) + ": ");
            valores[i] = sc.nextInt();
        }

        System.out.println("Valores lidos:");
        for (int valor : valores) {
            System.out.println(valor);
        }

        sc.close();
    }
}