package aula01_task01;

import java.util.Scanner;

public class Ex10 {
    public static void main(String[] args) {
        // Declarando o scanner e recebendo como paramêtro a entrada do sistema
        Scanner sc = new Scanner(System.in);

        System.out.println("\n" +
                "  _______  __          _  ___  \n" +
                " | ____\\ \\/ /         / |/ _ \\ \n" +
                " |  _|  \\  /   _____  | | | | |\n" +
                " | |___ /  \\  |_____| | | |_| |\n" +
                " |_____/_/\\_\\         |_|\\___/ \n" +
                "                               \n");

        // Abaixo peço as entradas das notas e a média
        System.out.println("Digite o número de identificação do aluno: ");
        int id = Integer.parseInt(sc.nextLine());

        System.out.println("Digite a Nota 1: ");
        double nota1 = Double.parseDouble(sc.nextLine());

        System.out.println("Digite a Nota 2: ");
        double nota2 = Double.parseDouble(sc.nextLine());

        System.out.println("Digite a Nota 3: ");
        double nota3 = Double.parseDouble(sc.nextLine());

        System.out.println("Digite a média dos exercícios: ");
        double mediaExercicios = Double.parseDouble(sc.nextLine());

        // Cálculo da média de aproveitamento
        double aproveitamento = (nota1 + nota2 * 2 + nota3 * 3 + mediaExercicios) / 7;

        // Aqui defino o conceito
        String conceito;
        if (aproveitamento >= 9.0) {
            conceito = "A";
        } else if (aproveitamento >= 7.5 && aproveitamento < 9.0) {
            conceito = "B";
        } else if (aproveitamento >= 6.0 && aproveitamento < 7.5) {
            conceito = "C";
        } else if (aproveitamento >= 4.0 && aproveitamento < 6.0) {
            conceito = "D";
        } else {
            conceito = "E";
        }

        // Apresentando dos resultados
        System.out.println("Número de identificação do aluno: " + id);
        System.out.printf("Notas: %.2f, %.2f, %.2f%n", nota1, nota2, nota3);
        System.out.println("Média dos exercícios: " + mediaExercicios);
        System.out.println("Média de aproveitamento: " + aproveitamento);
        System.out.println("Conceito: " + conceito);

        // Por último faço a verficação dos conceitos usando o equals que é o jeito apropriado de fazer com strings ao contrario do ==
        if (conceito.equals("A") || conceito.equals("B") || conceito.equals("C")) {
            System.out.println("APROVADO");
        } else {
            System.out.println("REPROVADO");
        }


    }


}
