import java.util.Scanner;

public class ExAula02For {
    public static void main(String[] args) {
        // Declarando o scanner e recebendo como paramêtro a entrada do sistema
        Scanner sc = new Scanner(System.in);

        // Declaro novo vetor
        int[] inteiros = new int[5];
        int soma = 0;

        System.out.printf("Digite %d números inteiros: \n", inteiros.length);

        // Loop para preencher o vetor
        for (int i = 0 ; i < inteiros.length ; i++) {
            System.out.printf("Insira o %d º número: ", i+1);
            int entrada = Integer.parseInt(sc.nextLine());
            inteiros[i] = entrada;
        }

        // Loop para somar os valores
        for (int i = 0; i < inteiros.length; i++) {
            soma += inteiros[i];
        }

        // Faço a média e apresento fiz um cast para double para precisar melhor o resultado :)
        double media = (double) soma / inteiros.length;

        System.out.println("\nMédia dos valores é: " + media);


    }
}
