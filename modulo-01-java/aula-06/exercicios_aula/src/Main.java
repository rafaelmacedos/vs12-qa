// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        Calculo soma = new Calculo() {
            @Override
            public int calcular(int n1, int n2) {
                return n1 + n2;
            }
        };

        Calculo multiplicacao = new Calculo() {
            @Override
            public int calcular(int n1, int n2) {
                return n1 * n2;
            }
        };

        System.out.println("Soma: " + soma.calcular(15, 5));
        System.out.println("Multiplicação: " + multiplicacao.calcular(5, 10));
    }
}