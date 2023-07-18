import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Ex07 {
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



        // Aqui inicio as variaveis referentes ao preço unitario e preco total
        double precoUnitario;
        double precoTotal;

        // Abaixo recebo o código do produto e quantidade comprada
        System.out.println("Digite o código do produto: ");
        String codigo = sc.nextLine().toUpperCase();

        System.out.println("Digite a quantidade comprada: ");
        int quantidade = Integer.parseInt(sc.nextLine());

        // Abaixo as condições para definir qual é o produto e atribuindo os valores
        if (codigo.equals("ABCD")) {
            precoUnitario = 5.30;
            precoTotal = precoUnitario * quantidade;
            System.out.println("Preço total: R$ " + precoTotal);
        } else if (codigo.equals("XYPK")) {
            precoUnitario = 6.00;
            precoTotal = precoUnitario * quantidade;
            System.out.println("Preço total: R$ " + precoTotal);
        } else if (codigo.equals("KLMP")) {
            precoUnitario = 3.20;
            precoTotal = precoUnitario * quantidade;
            System.out.println("Preço total: R$ " + precoTotal);
        } else if (codigo.equals("QRST")) {
            precoUnitario = 2.50;
            precoTotal = precoUnitario * quantidade;
            System.out.println("Preço total: R$ " + precoTotal);
        }

        else {
            System.out.println("Código de produto inválido!");
        }

        sc.close();

    }
}
