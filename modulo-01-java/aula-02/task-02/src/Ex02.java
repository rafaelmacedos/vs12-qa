import java.util.Scanner;

public class Ex02 {
    public static void main(String[] args) {
        // Declarando o scanner e recebendo como paramêtro a entrada do sistema
        Scanner sc = new Scanner(System.in);

        System.out.println("\n" +
                "  _______  __           ___ ____  \n" +
                " | ____\\ \\/ /          / _ \\___ \\ \n" +
                " |  _|  \\  /   _____  | | | |__) |\n" +
                " | |___ /  \\  |_____| | |_| / __/ \n" +
                " |_____/_/\\_\\          \\___/_____|\n" +
                "                                  \n");

        // Abaixo declaro o número a ser adivinhado e as variaveis para tentativas
        // e a do booleano de vitoria
        int numero = 7;
        int tentativas = 0;
        boolean ganhou = false;

        System.out.println("///////// Jogo de adivinhação /////////\n");

        // Loop while para dar a opção de entrar com número até adivinhar
        while (!ganhou) {
            System.out.println("Digite um número: ");
            int palpite = Integer.parseInt(sc.nextLine());
            tentativas++;

            if (palpite == numero) {
                System.out.println("Você acertou o número e ganhou o jogo!!");
                System.out.println(tentativas + " Tentativas feitas até a vitória");
                ganhou = true;
            }
            else if (palpite < numero) {
                System.out.println("O número a ser adivinhado é maior do que você digitou.");
            }
            else {
                System.out.println("O número a ser encontrado é menor do que você digitou.");
            }
        }

        sc.close();
    }
}
