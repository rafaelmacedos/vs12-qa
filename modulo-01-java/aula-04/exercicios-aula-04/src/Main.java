// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Pessoa pessoa1 = new Pessoa("Rafael", "rafaelzin", "senha123");
        System.out.println();

        Gato gato1 = new Gato("Felix");
        System.out.println("Gato: " + gato1.getNome());
        System.out.println(gato1.mia());
        System.out.println(gato1.caminha());

        System.out.println();
        Cachorro cachorro = new Cachorro("Wolf");
        System.out.println("Cachorro: " + cachorro .getNome());
        System.out.println(cachorro.late());
        System.out.println(cachorro.caminha());
    }
}