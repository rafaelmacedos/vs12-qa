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

        System.out.println("Calculando área de um retângulo...\n");

        // Abaixo recebo as entradas da base e altura
        // Novamente usei cast para evitar bugs do scanner
        System.out.println("Digite a base do retângulo: ");
        double base = Double.parseDouble(sc.nextLine());

        System.out.println("Digite a altura do retângulo: ");
        double altura = Double.parseDouble(sc.nextLine());

        // Abaixo a formula do calculo da area
        double area = base * altura;

        System.out.println("A área do retângulo é: " + area);
        sc.close();
    }
}
