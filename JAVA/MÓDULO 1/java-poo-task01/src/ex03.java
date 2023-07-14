import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ex03 {
    public static void main(String[] args) {
        // Declarando o scanner e recebendo como paramêtro a entrada do sistema
        Scanner sc = new Scanner(System.in);

        // Aqui criei um dicionário e adicionei as palavras suas respectivas traduções
        Map<String, String> traducoes = new HashMap<>();
        traducoes.put("cachorro", "dog");
        traducoes.put("tempo", "time");
        traducoes.put("amor", "love");
        traducoes.put("cidade", "city");
        traducoes.put("feliz", "happy");
        traducoes.put("triste", "sad");
        traducoes.put("deveria", "should");
        traducoes.put("poderia", "could");


        System.out.println("\n" +
                "  _______  __           ___ _____ \n" +
                " | ____\\ \\/ /          / _ \\___ / \n" +
                " |  _|  \\  /   _____  | | | ||_ \\ \n" +
                " | |___ /  \\  |_____| | |_| |__) |\n" +
                " |_____/_/\\_\\          \\___/____/ \n" +
                "                                  \n");

        // Abaixo peço a palavra ao usuário
        System.out.println("Digite uma palavra: ");
        String palavra = sc.nextLine().toLowerCase();

        // Abaixo verifico se a palavra está no dicionário
        if (traducoes.containsKey(palavra)) {
            // Tradução de português para inglês
            // Aqui pego apenas o valor da chave que é a palavra em inglês
            String traducaoPtBr = traducoes.get(palavra);
            System.out.println("Tradução para o inglês: " + traducaoPtBr);

        }
        // Senão for a chave então verifico se é valor
        else if (traducoes.containsValue(palavra)) {
            // Tradução de inglês para português
            // Percorro todas as entradas do dicionário para encontrar a palavra relacionada a entrada do usuário
            // Pra essa lógica tive que recorrer ao chatGPT, pois não tenho conhecimento suficiente nessa estrutura de dados
            for (Map.Entry<String, String> entry : traducoes.entrySet()) {
                if (entry.getValue().equals(palavra)) {
                    String traducaoPtBr = entry.getKey();
                    System.out.println("Tradução para o português: " + traducaoPtBr);
                    break;
                }

            }
        }
        else {
            System.out.println("Essa palavra não é válida.");
        }

        sc.close();
    }
}

