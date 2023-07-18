import java.util.Scanner;

public class Ex03 {
    public static void main(String[] args) {
        // Declarando o scanner e recebendo como paramêtro a entrada do sistema
        Scanner sc = new Scanner(System.in);

        System.out.println("\n" +
                "  _______  __           ___ _____ \n" +
                " | ____\\ \\/ /          / _ \\___ / \n" +
                " |  _|  \\  /   _____  | | | ||_ \\ \n" +
                " | |___ /  \\  |_____| | |_| |__) |\n" +
                " |_____/_/\\_\\          \\___/____/ \n" +
                "                                  \n");

        // Aqui as variaveis referentes a entrada
        String nome;
        double altura;
        int idade;
        double peso;

        // Abaixo as variaveis referentes aos números e nomes a serem registrados
        String nomeJogadorMaisAlto = "Nenhum";
        double maiorAltura = 0;

        String nomeJogadorMaisVelho = "Nenhum";
        int maiorIdade = 0;

        String nomeJogadorMaisPesado = "Nenhum";
        double maiorPeso = 0;

        int jogadores = 0;
        double somaAlturas = 0;

        System.out.println("///// Cadastro de Jogadores de Basquete /////");

        // loop para enquanto a entrada nao for sair, receber as entradas e registrar os resultados maiores
        while (true) {
            System.out.println("Nome do jogador (ou SAIR para sair): ");
            nome = sc.nextLine();

            if (nome.equalsIgnoreCase("SAIR")) {
                break;
            }

            System.out.println("Altura do jogador (em metros): ");
            altura = Double.parseDouble(sc.nextLine());

            System.out.println("Idade do jogador: ");
            idade = Integer.parseInt(sc.nextLine());

            System.out.println("Peso do jogador (em kg): ");
            peso = Double.parseDouble(sc.nextLine());

            jogadores++;
            somaAlturas += altura;

            if (altura > maiorAltura) {
                maiorAltura = altura;
                nomeJogadorMaisAlto = nome;
            }

            if (idade > maiorIdade) {
                maiorIdade = idade;
                nomeJogadorMaisVelho = nome;
            }

            if (peso > maiorPeso) {
                maiorPeso = peso;
                nomeJogadorMaisPesado = nome;
            }
        }

        // calculando a media e apresentando os resultados
        double mediaAlturas = somaAlturas / jogadores;

        System.out.println("\n//// Resultado ////");
        System.out.println("Quantidade de jogadores cadastrados: " + jogadores);
        System.out.println("Jogador mais alto: " + nomeJogadorMaisAlto + " (" + maiorAltura + " metros)");
        System.out.println("Jogador mais velho: " + nomeJogadorMaisVelho + " (" + maiorIdade + " anos)");
        System.out.println("Jogador mais pesado: " + nomeJogadorMaisPesado + " (" + maiorPeso + " kg)");
        System.out.println("Média das alturas dos jogadores: " + mediaAlturas + " metros");

        sc.close();

    }


}
