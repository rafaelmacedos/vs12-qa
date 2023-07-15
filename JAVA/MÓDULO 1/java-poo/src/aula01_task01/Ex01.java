package aula01_task01;

import java.util.Scanner;

public class Ex01 {
    public static void main(String[] args) {
        // Declarando o scanner e recebendo como paramêtro a entrada do sistema
        Scanner sc = new Scanner(System.in);

        // Uma ascii art para descontrair :)
        System.out.println("\n" +
                "  _______  __           ___  _ \n" +
                " | ____\\ \\/ /          / _ \\/ |\n" +
                " |  _|  \\  /   _____  | | | | |\n" +
                " | |___ /  \\  |_____| | |_| | |\n" +
                " |_____/_/\\_\\          \\___/|_|\n" +
                "                               \n");

        // Abaixo recebo os faço os prints das mensagens e recebo os respectivos valores
        System.out.println("Digite seu nome: ");
        String nome = sc.nextLine();

        // obs aqui: faço um cast da entrada em string para inteiro para evitar conflitos com o scanner
        System.out.println("Digite sua idade (apenas o número): ");
        int idade = Integer.parseInt(sc.nextLine());

        System.out.println("Digite o nome sua cidade: ");
        String cidade = sc.nextLine();

        System.out.println("Digite o nome completo seu estado: ");
        String estado = sc.nextLine();

        // Abaixo exibo a mensagem que é solicitada pelo enunciado da task :)
        System.out.printf("Olá seu nome é %s, você tem %d anos, é da cidade de %s, situada no estado de %s.", nome, idade, cidade, estado);
        sc.close();
    }
}
