public class ExAula02Array {
    public static void main(String[] args) {
        // Abaixo declaro o vetor e a variavel soma
        int inteiros[] = {10, 50, 70};
        int soma = 0;

        // Loop para somar
        for (int i = 0; i < inteiros.length; i++) {
            soma += inteiros[i];
        }

        // Calculo da média e apresentação :)
        int media = soma / inteiros.length;
        System.out.printf("Soma = %d", soma);
        System.out.printf("\nMédia = %d", media);
    }
}
