package aula02_task02;

public class ExAula02Matriz {
    public static void main(String[] args) {
        int[][] matriz = {
                {10, 10},
                {10, 5}
        };

        // Abaixo faço o loop para a soma de todos
        int somaTodos = 0;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                somaTodos += matriz[i][j];
            }
        }
        System.out.println("Soma: " + somaTodos);

        // Abaixo faço o loop para a soma da primeira linha
        int somaPrimeiraLinha = 0;
        for (int j = 0; j < 2; j++) {
            somaPrimeiraLinha += matriz[0][j];
        }
        System.out.println("Soma primeira linha: " + somaPrimeiraLinha);

        // Abaixo faço o loop para a soma da segunda linha
        int somaSegundaLinha = 0;
        for (int j = 0; j < 2; j++) {
            somaSegundaLinha += matriz[1][j];
        }
        System.out.println("Soma segunda linha: " + somaSegundaLinha);

        // Subtração e apresento o último valor :)
        int subtracao = somaPrimeiraLinha - somaSegundaLinha;
        System.out.println("Subtração da primeira linha pela segunda linha: " + subtracao);


    }
}
