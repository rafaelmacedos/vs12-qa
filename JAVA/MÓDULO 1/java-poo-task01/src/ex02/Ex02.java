package ex02;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ex02 {
    public static void main(String[] args) {
        // Declarando o scanner e recebendo como paramêtro a entrada do sistema
        Scanner sc = new Scanner(System.in);

        // Declarando um ArrayList de estados
        List<Estado> estados = new ArrayList<Estado>();

        // Instanciando estados e cidades e adicionando cada um
        Estado paraiba = new Estado(1,"Paraíba");
        paraiba.adicionarCidade(new Cidade(1,"Campina Grande", "Maior São João do mundo", 0.72, 402912));
        paraiba.adicionarCidade(new Cidade(2,"João Pessoa", "Veraneio", 0.763, 817511));
        estados.add(paraiba);

        Estado maranhao = new Estado(2,"Maranhão");
        maranhao.adicionarCidade(new Cidade(1,"São Luís", "Bumba-Meu-Boi", 0.768, 1109000));
        maranhao.adicionarCidade(new Cidade(2,"Imperatriz", "São João do Maranhão", 0.731, 526116));
        estados.add(maranhao);

        Estado rioGrandeDoSul = new Estado(3,"Rio Grande do Sul");
        rioGrandeDoSul.adicionarCidade(new Cidade(1,"Porto Alegre", "Semana Farroupilha", 0.805, 1500000));
        rioGrandeDoSul.adicionarCidade(new Cidade(2,"Pelotas", "Festival Internacional de Folclore e Artes Populares de Pelotas", 0.739, 343132));
        estados.add(rioGrandeDoSul);

        // Segunda ascii art para descontrair :)
        System.out.println("\n" +
                "  _______  __           ___ ____  \n" +
                " | ____\\ \\/ /          / _ \\___ \\ \n" +
                " |  _|  \\  /   _____  | | | |__) |\n" +
                " | |___ /  \\  |_____| | |_| / __/ \n" +
                " |_____/_/\\_\\          \\___/_____|\n" +
                "                                  \n");

        // Apresentando os estados e dando a opção para o usuário escolher
        System.out.println("Estados disponíveis:");

        for (Estado estado : estados) {
            System.out.println(estado.getId() + " - " + estado.getNome());
        }

        System.out.println("\nEscolha o número do estado: ");
        int estadoEscolhido = Integer.parseInt(sc.nextLine());


        // Se o estado escolhido estiver entre 1 e 3 ...
        if (estadoEscolhido >= 1 && estadoEscolhido <= 3) {
            Estado estadoSelecionado = estados.get(estadoEscolhido - 1);

            System.out.println("\nCidades disponíveis em " + estadoSelecionado.getNome() + ":");
            for (Cidade cidade : estadoSelecionado.getCidades()) {
                System.out.println(cidade.getId() + " - " + cidade.getNome());
            }

            // Aqui o usuário escolhe a cidade que quer ver as informações
            System.out.println("Escolha o número da cidade: \n");
            int cidadeEscolhida = Integer.parseInt(sc.nextLine());

            if (cidadeEscolhida >= 1 && cidadeEscolhida <= estadoSelecionado.getCidades().size()) {
                Cidade cidadeSelecionada = estadoSelecionado.getCidades().get(cidadeEscolhida - 1);

                System.out.println("\nInformações sobre " + cidadeSelecionada.getNome() + ":\n");
                System.out.println("População: " + cidadeSelecionada.getPopulacao());
                System.out.println("Principal festa: " + cidadeSelecionada.getFestaPrincipal());
                System.out.println("IDH: " + cidadeSelecionada.getIdh());
            } else {
                System.out.println("Número da cidade inválido.");
            }
        }
        // Senão...
        else {
            System.out.println("Número do estado inválido.");
        }

        sc.close();
    }
}



