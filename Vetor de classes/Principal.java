import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        Aluno[] alunos = new Aluno[10];
        Aluno[] aprovados = new Aluno[10];
        Aluno[] reprovados = new Aluno[10];
        int countAprovados = 0;
        int countReprovados = 0;

        
        for (int i = 0; i < 10; i++) {
            System.out.println("Digite os dados do aluno " + (i + 1) + ":");
            System.out.print("Nome: ");
            String nome = input.nextLine();

            System.out.print("Matrícula: ");
            String matricula = input.nextLine();

            System.out.print("Média Final: ");
            double mediaFinal = input.nextDouble();
            input.nextLine(); // limpar o buffer

            alunos[i] = new Aluno(nome, matricula, mediaFinal);

            // classificação
            if (mediaFinal >= 5.0) {
                aprovados[countAprovados] = alunos[i];
                countAprovados++;
            } else {
                reprovados[countReprovados] = alunos[i];
                countReprovados++;
            }
        }

        // exibir aprovados
        System.out.println("\n--- Alunos Aprovados ---");
        for (int i = 0; i < countAprovados; i++) {
            aprovados[i].exibirDados();
        }

        // exibir reprovados
        System.out.println("\n--- Alunos Reprovados ---");
        for (int i = 0; i < countReprovados; i++) {
            reprovados[i].exibirDados();
        }

        input.close();
    }
}
