package aula02_task02;

import java.util.Scanner;

public class ExAula02For {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] inteiros = new int[5];
        int soma = 0;

        System.out.printf("Digite %d números inteiros: \n", inteiros.length);

        for (int i = 0 ; i < inteiros.length ; i++) {
            System.out.printf("Insira o %d º número: ", i+1);
            int entrada = Integer.parseInt(sc.nextLine());
            inteiros[i] = entrada;
        }

        for (int i = 0; i < inteiros.length; i++) {
            soma += inteiros[i];
        }

        double media = soma / inteiros.length;

        System.out.println("\nMédia dos valores é: " + media);


    }
}
