import java.util.Scanner;

public class ex08 {
    public static void main(String[] args) {
        // Declarando o scanner e recebendo como paramêtro a entrada do sistema
        Scanner sc = new Scanner(System.in);

        System.out.println("\n" +
                "  _______  __           ___   ___  \n" +
                " | ____\\ \\/ /          / _ \\ ( _ ) \n" +
                " |  _|  \\  /   _____  | | | |/ _ \\ \n" +
                " | |___ /  \\  |_____| | |_| | (_) |\n" +
                " |_____/_/\\_\\          \\___/ \\___/ \n" +
                "                                   \n");

        System.out.println("Aumento no salário do funcionário... \n");

        // Abaixo recebo os valores
        System.out.println("Digite o seu salário atual: ");
        double salarioAtual = Double.parseDouble(sc.nextLine());

        System.out.println("Digite o código do seu cargo: ");
        int codigoCargo = Integer.parseInt(sc.nextLine());

        // Aqui declaro a variavel sem valores e uso a estrutura switch case para atribuir o devido percentual
        double percentualAumento;
        switch (codigoCargo) {
            case 101:
                percentualAumento = 1.10;
                break;
            case 102:
                percentualAumento = 1.20;
                break;
            case 103:
                percentualAumento = 1.30;
                break;
            default:
                percentualAumento = 1.40;
                break;
        }

        // Após o percentual definido, faço a multiplicacao do salario pelo percentual
        double novoSalario = salarioAtual * percentualAumento;
        double diferenca = novoSalario - salarioAtual;

        // Apresento o salário antigo e o novo salário
        System.out.println("Salário antigo: R$ " + salarioAtual);
        System.out.println("Novo salário: R$ " + novoSalario);
        System.out.println("Diferença: R$ " + diferenca);

        sc.close();
    }
}
