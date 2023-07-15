package aula01_task01;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Ex03 {
    public static void main(String[] args) {
        // Declarando o scanner e recebendo como paramêtro a entrada do sistema
        Scanner sc = new Scanner(System.in);

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

        // Aqui criei um dicionário e adicionei as palavras suas respectivas traduções
        if (palavra.equals("cachorro")) {System.out.println("Tradução para o inglês: Dog");}
        else if (palavra.equals("tempo")) {System.out.println("Tradução para o inglês: Time");}
        else if (palavra.equals("amor")) {System.out.println("Tradução para o inglês: Love");}
        else if (palavra.equals("cidade")) {System.out.println("Tradução para o inglês: City");}
        else if (palavra.equals("feliz")) {System.out.println("Tradução para o inglês: Happy");}
        else if (palavra.equals("triste")) {System.out.println("Tradução para o inglês: Sad");}
        else if (palavra.equals("deveria")) {System.out.println("Tradução para o inglês: Should");}
        else if (palavra.equals("poderia")) {System.out.println("Tradução para o inglês: Could");}

        else if (palavra.equals("dog")) {System.out.println("Tradução para o português: Cachorro");}
        else if (palavra.equals("time")) {System.out.println("Tradução para o português: Tempo");}
        else if (palavra.equals("love")) {System.out.println("Tradução para o português: Amor");}
        else if (palavra.equals("city")) {System.out.println("Tradução para o português: Cidade");}
        else if (palavra.equals("happy")) {System.out.println("Tradução para o português: Feliz");}
        else if (palavra.equals("sad")) {System.out.println("Tradução para o português: Triste");}
        else if (palavra.equals("should")) {System.out.println("Tradução para o português: Deveria");}
        else if (palavra.equals("could")) {System.out.println("Tradução para o português: Poderia");}

        else {
            System.out.println("Essa palavra não é válida.");
        }

        sc.close();
    }
}

