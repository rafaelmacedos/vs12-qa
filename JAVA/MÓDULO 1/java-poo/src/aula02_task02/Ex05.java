package aula02_task02;

import java.util.Scanner;

public class Ex05 {
    public static void main(String[] args) {
        // Declarando o scanner e recebendo como paramêtro a entrada do sistema
        Scanner sc = new Scanner(System.in);

        System.out.println("\n" +
                "  _______  __           ___  ____  \n" +
                " | ____\\ \\/ /          / _ \\| ___| \n" +
                " |  _|  \\  /   _____  | | | |___ \\ \n" +
                " | |___ /  \\  |_____| | |_| |___) |\n" +
                " |_____/_/\\_\\          \\___/|____/ \n" +
                "                                   \n");

        // Abaixo declaro a matriz
        double[][] matriz = new double[10][3];

        // Aqui é o primeiro loop para preencher a matriz
        // Nele tem o print para apresentar o número do item
        for (int i = 0; i < 10; i++) {
            System.out.println("Item " + (i + 1));

            // Esse segundo loop serve para preencher as 3 colunas referentes aos preços nos 3 mercados distintos
            for (int j = 0; j < 3; j++) {
                System.out.printf("Preço no mercado %d: ",  j + 1);
                matriz[i][j] = Double.parseDouble(sc.nextLine());
            }

            System.out.println("");
        }

        // Segundo loop verifico em qual mercado o item é mais barato percorrendo as 3 colunas das 10 linhas
        // Aqui tive uma certa dificuldade para entender o funcionamento e o que a questão pede
        // Pesquisei um pouco e vi que se colocar o menor preço
        // e o mercado mais barato como o primeiro, é só comparar os outros dois que vem em seguida
        for (int i = 0; i < 10; i++) {
            double menorPreco = matriz[i][0];
            int mercadoMaisBarato = 1;

            // Esse loop começa em 1 pq só quero percorrer os proximos dois mercados e comparar com o primeiro.
            for (int j = 1; j < 3; j++) {
                if (matriz[i][j] < menorPreco) {
                    menorPreco = matriz[i][j];
                    mercadoMaisBarato = j + 1;
                }
            }

            System.out.printf("Item %d - Mercado mais barato: %d - Preço: R$%s\n",(i + 1), mercadoMaisBarato, String.format("%.2f", menorPreco));
        }

    }
}
