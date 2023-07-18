public class Main {
    public static void main(String[] args) {
        //////////////////////////
        System.out.println("TESTE 1: \n");
        //////////////////////////

        Pessoa alyson = new Pessoa();
        alyson.nome = "Ályson";
        alyson.sobrenome = "Campos";
        alyson.idade = 17;
        alyson.whatsapp = "(81) 98888-0302";

        Pessoa mayra = new Pessoa();
        mayra.nome = "Mayra";
        mayra.sobrenome = "Amaral";
        mayra.idade = 23;
        mayra.whatsapp = "(83) 99999-0101";

        alyson.conversar(mayra);
        System.out.println("Nome completo: " + alyson.retornarNomeCompleto());

        alyson.mandarWhatsApp(mayra, "Olá tudo bem");

        if (alyson.ehMaiorDeIdade()) {
            System.out.println(alyson.nome + " é maior de idade");
        }
        else {
            System.out.println(alyson.nome + " é menor de idade");
        }

        //////////////////////////
        System.out.println("\nTESTE 2: \n");
        //////////////////////////



        mayra.conversar(alyson);
        System.out.println("Nome completo: " + mayra.retornarNomeCompleto());

        mayra.mandarWhatsApp(alyson, "Java é vida");

        if (mayra.ehMaiorDeIdade()) {
            System.out.println(mayra.nome + " é maior de idade");
        }
        else {
            System.out.println(mayra.nome + " é menor de idade");
        }


    }
}
