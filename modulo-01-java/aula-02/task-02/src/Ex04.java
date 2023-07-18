import java.util.Scanner;

public class Ex04 {
    public static void main(String[] args) {
        // Declarando o scanner e recebendo como paramêtro a entrada do sistema
        Scanner sc = new Scanner(System.in);

        System.out.println("\n" +
                "  _______  __           ___  _  _   \n" +
                " | ____\\ \\/ /          / _ \\| || |  \n" +
                " |  _|  \\  /   _____  | | | | || |_ \n" +
                " | |___ /  \\  |_____| | |_| |__   _|\n" +
                " |_____/_/\\_\\          \\___/   |_|  \n" +
                "                                    \n");

        // Declaro a matriz e as variaveis a serem registradas
        int[][] matriz = new int[5][4];
        int matriculaDaMaiorNota = 0;
        int maiorNotaFinal = 0;
        int mediaNotasFinais = 0;

        System.out.println("//// Cadastro de Alunos ////");

        // Loop for para preencher as 5 linhas matriz com as 4 colunas
        // Adicionando os valores nas devidas variaveis
        for (int i = 0; i < 5; i++) {

            System.out.printf("\nDigite o número da matricula %dº aluno: ", i + 1);
            int matricula = Integer.parseInt(sc.nextLine());
            matriz[i][0] = matricula;

            System.out.printf("Digite a média das provas do %dº aluno: ", i + 1);
            int media = Integer.parseInt(sc.nextLine());
            matriz[i][1] = media;

            System.out.printf("Digite a média dos trabalhos do %dº aluno: ", i + 1);
            int mediaTrabalhos = Integer.parseInt(sc.nextLine());
            matriz[i][2] = mediaTrabalhos;

            double notaFinal = (int) ((matriz[i][1] * 0.6) + (matriz[i][2] * 0.4));
            matriz[i][3] = matricula;

            if((int) notaFinal > maiorNotaFinal) {
                maiorNotaFinal = (int) notaFinal;
                matriculaDaMaiorNota = matricula;
            }
            mediaNotasFinais += notaFinal;
        }

        // Atribuindo o valor da variavel media e apresentando os resultados
        mediaNotasFinais = mediaNotasFinais / 5;
        System.out.printf("\nMatrícula com maior nota final: %d - Nota: %d", matriculaDaMaiorNota, maiorNotaFinal);
        System.out.printf("\nMédia das notas finais: %d", mediaNotasFinais);
    }
}
