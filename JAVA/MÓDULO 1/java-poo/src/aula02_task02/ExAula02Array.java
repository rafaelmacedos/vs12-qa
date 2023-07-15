package aula02_task02;

public class ExAula02Array {
    public static void main(String[] args) {
        int inteiros[] = {12, 55, 33};
        int soma = (inteiros[0] + inteiros[1] + inteiros[2]);
        int media = (inteiros[0] + inteiros[1] + inteiros[2]) / inteiros.length;
        System.out.printf("Soma = %d", soma);
        System.out.printf("\nMédia = %d", media);
    }
}
