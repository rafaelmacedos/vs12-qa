import java.util.Scanner;

public class ex06 {
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

            System.out.println("Eleições...\n");

            // Abaixo peço ao usuário que faça as entradas dos votos para fazer o calculo de proporção
            System.out.println("Digite o número total de eleitores: ");
            int eleitores = Integer.parseInt(sc.nextLine());

            System.out.println("Digite o número de votos em branco: ");
            int brancos = Integer.parseInt(sc.nextLine());

            System.out.println("Digite o número de votos nulos: ");
            int nulos = Integer.parseInt(sc.nextLine());

            System.out.println("Digite o número de votos válidos: ");
            int validos = Integer.parseInt(sc.nextLine());

            // Aqui calculo a porcentagem
            double porcentagemBrancos = (brancos * 100.0) / eleitores;
            double porcentagemNulos = (nulos * 100.0) / eleitores;
            double porcentagemValidos = (validos * 100.0) / eleitores;

            // Apresento as porcentagens de cada tipo de voto
            System.out.println("Porcentagem de votos em branco: " + porcentagemBrancos + "%");
            System.out.println("Porcentagem de votos nulos: " + porcentagemNulos + "%");
            System.out.println("Porcentagem de votos válidos: " + porcentagemValidos + "%");

            sc.close();
    }
}
