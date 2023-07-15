package aula01_task01;

public class Ex04 {
    public static void main(String[] args) {
        System.out.println("\n" +
                "  _______  __           ___  _  _   \n" +
                " | ____\\ \\/ /          / _ \\| || |  \n" +
                " |  _|  \\  /   _____  | | | | || |_ \n" +
                " | |___ /  \\  |_____| | |_| |__   _|\n" +
                " |_____/_/\\_\\          \\___/   |_|  \n" +
                "                                    \n");

        int A = 10;
        int B = 20;

        // Abaixo apresento as variaveis com valor original
        System.out.println("Valores originais:");
        System.out.println("Valor em A: " + A);
        System.out.println("Valor em B: " + B);

        // Abaixo faço a troca de valores usando uma variável auxiliar
        int temporaria = A;
        A = B;
        B = temporaria;

        // Abaixo apresento as variaveis com novo valor atribuido
        System.out.println("\nValores invertidos:");
        System.out.println("Valor em A: " + A);
        System.out.println("Valor em B: " + B);
    }
}
