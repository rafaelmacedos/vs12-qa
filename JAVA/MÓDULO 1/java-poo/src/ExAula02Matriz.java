public class ExAula02Matriz {
    public static void main(String[] args) {
        int[][] matriz = {
                {10, 10},
                {10, 5}
        };
        int somaTodos = (matriz[0][0] + matriz[0][1]) + (matriz[1][0] + matriz[1][1]);
        System.out.println("Soma: " + somaTodos);

        int somaPrimeiraLinha = matriz[0][0] + matriz[0][1];
        System.out.println("Soma primeira linha: " + somaPrimeiraLinha);

        int somaSegundaLinha = matriz[1][0] + matriz[1][1];
        System.out.println("Soma segunda linha: " + somaSegundaLinha);

        int subtracao = (matriz[0][0] + matriz[0][1]) - (matriz[1][0] + matriz[1][1]);
        System.out.println("Subtração da primeira linha pela segunda linha: " + subtracao);

        int[][] matriz3 = {
                {10, 3, 74},
                {23, 4, 84},
                {43, 5, 92}
        };

    }
}
