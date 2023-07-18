import java.time.Duration;
import java.time.LocalTime;
import java.util.Scanner;

public class Ex09 {
    public static void main(String[] args) {
        // Declarando o scanner e recebendo como paramêtro a entrada do sistema
        Scanner sc = new Scanner(System.in);

        System.out.println("\n" +
                "  _______  __           ___   ___  \n" +
                " | ____\\ \\/ /          / _ \\ / _ \\ \n" +
                " |  _|  \\  /   _____  | | | | (_) |\n" +
                " | |___ /  \\  |_____| | |_| |\\__, |\n" +
                " |_____/_/\\_\\          \\___/   /_/ \n" +
                "                                   \n");

        // Aqui tive que usar a biblioteca time, poís não lembro como calcular hora na raça kkkkkk
        // Abaixo recebo a hora de inicio do jogo em seguida instancio o horário de inicio com LocalTime
        System.out.println("Informe o horário de início do jogo: \n");
        System.out.println("Horas: ");
        int horaInicio = sc.nextInt();
        System.out.println("Minutos: ");
        int minutoInicio = sc.nextInt();
        LocalTime inicio = LocalTime.of(horaInicio, minutoInicio);


        // Abaixo recebo a hora do final do jogo em seguida instancio o horário do final com LocalTime
        System.out.println("Informe o horário do final do jogo: ");
        System.out.println("Horas: ");
        int horaFinal = sc.nextInt();
        System.out.println("Minutos: ");
        int minutoFinal = sc.nextInt();
        LocalTime termino = LocalTime.of(horaFinal, minutoFinal);

        // Aqui uso o duration e seus metódos para tirar a duração
        Duration duracao = Duration.between(inicio, termino);
        long horas = duracao.toHours();
        long minutos = duracao.toMinutes() % 60;

        System.out.printf("Duração do jogo: %d horas e %d minutos\n", horas, minutos);

        sc.close();
    }
}
