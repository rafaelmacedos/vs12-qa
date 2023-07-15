package aula01_task01;

import java.util.Scanner;

public class Ex02 {
    public static void main(String[] args) {
        // Declarando o scanner e recebendo como paramêtro a entrada do sistema
        Scanner sc = new Scanner(System.in);

        // Segunda ascii art para descontrair :)
        System.out.println("\n" +
                "  _______  __           ___ ____  \n" +
                " | ____\\ \\/ /          / _ \\___ \\ \n" +
                " |  _|  \\  /   _____  | | | |__) |\n" +
                " | |___ /  \\  |_____| | |_| / __/ \n" +
                " |_____/_/\\_\\          \\___/_____|\n" +
                "                                  \n");

        // Apresentando os estados e dando a opção para o usuário escolher
        System.out.println("Estados disponíveis:" +
                "\n1 - Paraíba" +
                "\n2 - Maranhão" +
                "\n3 - Rio Grande do Sul\n");

        System.out.println("\nEscolha o número do estado: ");
        int estadoEscolhido = Integer.parseInt(sc.nextLine());

        if (estadoEscolhido == 1) {
            System.out.println("Cidades disponíveis na Paraíba:" +
                    "\n1 - Campina Grande" +
                    "\n2 - João Pessoa\n");

            System.out.println("\nEscolha o número da cidade: ");
            int cidadeEscolhida = Integer.parseInt(sc.nextLine());

            if (cidadeEscolhida == 1) {
                System.out.println("\nCidade: Campina Grande" +
                        "\nFesta principal: Maior São João do Mundo" +
                        "\nIDH: 0.72" +
                        "\nPopulação: 402912\n");
            } else if (cidadeEscolhida == 2) {
                System.out.println(
                        "\nCidade: João Pessoa" +
                        "\nFesta principal: Veraneio" +
                        "\nIDH: 0.763" +
                        "\nPopulação: 817511\n");
            }
        }

        else if (estadoEscolhido == 2) {
            System.out.println("Cidades disponíveis no Maranhão:" +
                    "\n1 - São Luís" +
                    "\n2 - Imperatriz\n");

            System.out.println("\nEscolha o número da cidade: ");
            int cidadeEscolhida = Integer.parseInt(sc.nextLine());

            if (cidadeEscolhida == 1) {
                System.out.println(
                        "\nCidade: São Luís" +
                        "\nFesta principal: Bumba-Meu-Boi" +
                        "\nIDH: 0.768" +
                        "\nPopulação: 1109000\n");

            } else if (cidadeEscolhida == 2) {
                System.out.println(
                        "\nCidade: Imperatriz" +
                        "\nFesta principal: São João do Maranhão" +
                        "\nIDH: 0.731" +
                        "\nPopulação: 526116\n");

            }
        }

        else if (estadoEscolhido == 3) {
            System.out.println("Cidades disponíveis no Rio Grande do Sul:" +
                    "\n1 - Porto Alegre" +
                    "\n2 - Pelotas\n");

            System.out.println("\nEscolha o número da cidade: ");
            int cidadeEscolhida = Integer.parseInt(sc.nextLine());

            if (cidadeEscolhida == 1) {
                System.out.println(
                        "\nCidade: Porto Alegre" +
                        "\nFesta principal: Semana Farroupilha" +
                        "\nIDH: 0.805" +
                        "\nPopulação: 1500000\n");

            } else if (cidadeEscolhida == 2) {
                System.out.println(
                        "\nCidade: Pelotas" +
                        "\nFesta principal: Festival Internacional de Folclore e Artes Populares de Pelotas" +
                        "\nIDH: 0.739" +
                        "\nPopulação: 343132\n");

            }
        }

    }
}
