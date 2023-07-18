import java.util.Scanner;

public class Ex01 {
    public static void main(String[] args) {
        // Declarando o scanner e recebendo como paramêtro a entrada do sistema
        Scanner sc = new Scanner(System.in);

        System.out.println("\n" +
                "  _______  __           ___  _ \n" +
                " | ____\\ \\/ /          / _ \\/ |\n" +
                " |  _|  \\  /   _____  | | | | |\n" +
                " | |___ /  \\  |_____| | |_| | |\n" +
                " |_____/_/\\_\\          \\___/|_|\n" +
                "                               \n");

        // Aqui recebo as entradas
        System.out.println("Digite o nome do produto: ");
        String nome = sc.nextLine();


        System.out.println("Digite o valor do produto: ");
        double valor = Double.parseDouble(sc.nextLine());

        System.out.println(
                "\nProduto: "
                        + nome
                        + "\nPreço: R$"
                        + valor
                        + "\nPromoção: "
                        + nome
                        + "\n---------------------------"
        );

        // Aqui declaro o desconto e faço o loop para calcular o desconto e printar devidamente formatado
        double desconto = 0.05;
        for (int i = 1; i < 11; i++) {
            double valorComDesconto = valor - (valor * desconto);
            System.out.println(i + "X R$ " + String.format("%.2f", valorComDesconto) + " = R$" + String.format("%.2f", (valorComDesconto * i)));
            desconto += 0.05;
        }

        sc.close();

    }
}
