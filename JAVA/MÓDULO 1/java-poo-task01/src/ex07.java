import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ex07 {
    public static void main(String[] args) {
        // Declarando o scanner e recebendo como paramêtro a entrada do sistema
        Scanner sc = new Scanner(System.in);

        System.out.println("\n" +
                "  _______  __           ___ _____ \n" +
                " | ____\\ \\/ /          / _ \\___  |\n" +
                " |  _|  \\  /   _____  | | | | / / \n" +
                " | |___ /  \\  |_____| | |_| |/ /  \n" +
                " |_____/_/\\_\\          \\___//_/   \n" +
                "                                  \n");

        // Usando o dicionário mais uma vez
        Map<String, Double> tabelaPrecos = new HashMap<>();
        tabelaPrecos.put("ABCD", 5.30);
        tabelaPrecos.put("XYPK", 6.00);
        tabelaPrecos.put("KLMP", 3.20);
        tabelaPrecos.put("QRST", 2.50);

        // Aqui preço o código do produto e a quantidade comprada
        System.out.println("Digite o código do produto: ");
        String codigo = sc.nextLine().toUpperCase();

        System.out.println("Digite a quantidade comprada: ");
        int quantidade = Integer.parseInt(sc.nextLine());

        // Se a quantidade for válida, faz as outras verificações
        if (quantidade > 0) {
            // Se a chave que é o código do produto estiver no dicionário, eu faço a o cálculo, se não exibe a mensagem de erro
            if (tabelaPrecos.containsKey(codigo)) {
                double precoUnitario = tabelaPrecos.get(codigo);
                double precoTotal = precoUnitario * quantidade;
                System.out.println("Preço total: R$ " + precoTotal);
            } else {
                System.out.println("Código de produto inválido!");
            }
        } else {
            System.out.println("Quantidade inválida!");
        }

        sc.close();

    }
}
