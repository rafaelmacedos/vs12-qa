import java.util.Scanner;

public class Ex06 {
    public static void main(String[] args) {
        // Declarando o scanner e recebendo como paramêtro a entrada do sistema
        Scanner sc = new Scanner(System.in);

        System.out.println("\n" +
                "  _______  __           ___   __   \n" +
                " | ____\\ \\/ /          / _ \\ / /_  \n" +
                " |  _|  \\  /   _____  | | | | '_ \\ \n" +
                " | |___ /  \\  |_____| | |_| | (_) |\n" +
                " |_____/_/\\_\\          \\___/ \\___/ \n" +
                "                                   \n");

        // Declarando e iniciando o vetor
        int[] vetor = {7, 7, 2, 6, 1, 10, 9, 4, 5, 10};

        // Aqui recebo a entrada
        System.out.println("Digite um número: ");
        int numero = Integer.parseInt(sc.nextLine());

        // Variaveis para contagem
        int contadorigual = 0;
        int contadorMaior = 0;
        int contadorMenor = 0;

        // Loop que percorre o vetor e registra cada ocorrencia
        for (int i = 0; i < vetor.length; i++) {
            if (numero == vetor[i]) {
                contadorigual++;
            }
            if (numero < vetor[i]) {
                contadorMaior++;
            }
            if (numero > vetor[i]) {
                contadorMenor++;
            }

        }

        // Apresentando os resultados
        System.out.printf("\nVezes que %d se repete: %d", numero, contadorigual);
        System.out.printf("\nNúmeros maiores que %d: %d", numero, contadorMaior);
        System.out.printf("\nNúmeros menores que %d: %d",numero, contadorMenor);
    }
}
