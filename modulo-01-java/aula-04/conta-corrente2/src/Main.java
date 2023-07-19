public class Main {
    public static void main(String[] args) {
        // ascii art...
        System.out.println(".______        ___      .__   __.   ______   ______       _______  .______     ______ \n" +
                "|   _  \\      /   \\     |  \\ |  |  /      | /  __  \\     |       \\ |   _  \\   /      |\n" +
                "|  |_)  |    /  ^  \\    |   \\|  | |  ,----'|  |  |  |    |  .--.  ||  |_)  | |  ,----'\n" +
                "|   _  <    /  /_\\  \\   |  . `  | |  |     |  |  |  |    |  |  |  ||   _  <  |  |     \n" +
                "|  |_)  |  /  _____  \\  |  |\\   | |  `----.|  `--'  |    |  '--'  ||  |_)  | |  `----.\n" +
                "|______/  /__/     \\__\\ |__| \\__|  \\______| \\______/     |_______/ |______/   \\______|\n" +
                "                                                                                      \n");


        // Fazendo as instâncias dos dois clientes e duas contas
        Contato contatoLucas1 = new Contato("Somente chamadas rápidas","(83) 99858-8754", 1);

        Contato contatoLucas2 = new Contato("Telefone da Empresa", "(83) 3322-3298", 2);

        Endereco enderecoLucas1 = new Endereco(1,
                "Rua Capitão Fahrur",
                "7654",
                "Casa de Esquina",
                "58498-089",
                "Campina Grande",
                "Paraíba",
                "Brasil"
        );

        Endereco enderecoLucas2 = new Endereco(2,
                "Avenida Talharim",
                "21",
                "Prédio da Empresa",
                "58238-217",
                "Campina Grande",
                "Paraíba",
                "Brasil"
        );

        Contato[] contatosLucas = {contatoLucas1, contatoLucas2};
        Endereco[] enderecosLucas = {enderecoLucas1, enderecoLucas2};

        Cliente lucas = new Cliente("Lucas da Silva Sales", "002.009.234-32", contatosLucas, enderecosLucas);

        ContaCorrente contaLucas = new ContaCorrente(lucas,
                "45684-20",
                101,
                1000,
                1000
                );

        /////////////////////////////////////////////////////////////////////////

        Contato contatoFernanda1 = new Contato("Não atendo durante o dia", "(11) 98943-0002", 1);

        Contato contatoFernanda2 = new Contato("Contato do Primo", "(11) 2001-9032", 2);

        Endereco enderecoFernanda1 = new Endereco(1,
                "Avenida Paulista",
                "23",
                "Prédio de esquina",
                "002003-102",
                "São Paulo",
                "São Paulo",
                "Brasil"
        );

        Endereco enderecoFernanda2 = new Endereco(2,
                "Rua das Ostras",
                "6743",
                "Firma do Primo",
                "001244-102",
                "Campinas",
                "São Paulo",
                "Brasil"
        );

        Contato[] contatosFernanda = {contatoFernanda1, contatoFernanda2};
        Endereco[] enderecosFernanda = {enderecoFernanda1, enderecoFernanda2};

        Cliente fernanda = new Cliente("Fernanda Socorro Maria", "012.413.097-29", contatosFernanda, enderecosFernanda);

        ContaPoupanca contaFernanda = new ContaPoupanca(fernanda,
                "22340-01",
                89,
                1000);


        /////////////////////////////////////////////////////////////////////////
                                    //// Testes ////
        /////////////////////////////////////////////////////////////////////////


        System.out.println("\n---------- TESTE MÉTODOS CLIENTE 01 ----------\n");
        contaLucas.getCliente().imprimirCliente();
        contaLucas.getCliente().imprimirContatos();
        contaLucas.getCliente().imprimirEnderecos();


        System.out.println("\n---------- TESTE MÉTODOS CLIENTE 02 ----------\n");
        contaFernanda.getCliente().imprimirCliente();
        contaFernanda.getCliente().imprimirContatos();
        contaFernanda.getCliente().imprimirEnderecos();


        System.out.println("\n---------- TESTE TRANSAÇÕES 01 - ANTES DOS TRANSFERÊNCIA ----------");
        contaLucas.imprimir();
        contaFernanda.imprimir();


        // Caso algum de vocês queira testar a lógica de transferência só alterar o valor da variavel abaixo
        double valorTransferencia = 2000;
        System.out.printf("\nTentativa de transferência de %s para %s no valor de R$%s",
                contaLucas.getCliente().getNome(),
                contaFernanda.getCliente().getNome(),
                String.format("%.2f", valorTransferencia));

        if(contaLucas.transferir(contaFernanda, valorTransferencia)) {
            System.out.println("\nTransferência efetuada com sucesso.");
        }
        else {
            System.out.println("\nErro ao fazer a Transferência. Saldo insuficiente.");
        }


        System.out.println("\n---------- TESTE TRANSAÇÕES 02 - APÓS TRANSFERÊNCIA ----------");

        contaLucas.imprimir();
        contaFernanda.imprimir();

        System.out.println("\n---------- TESTE TRANSAÇÕES 03 - DEPOIS DO DEPÓSITO E SAQUE ----------");

        contaLucas.depositar(150);
        contaLucas.sacar(50);

        contaFernanda.depositar(150);
        contaFernanda.sacar(50);

        contaLucas.imprimir();
        contaFernanda.imprimir();

        System.out.println("\n---------- TESTE TRANSAÇÕES 04 - TESTE DA NOVA CLASSE CONTA POUPANÇA ----------");

        // Caso algum de vocês queira testar a lógica de saque só alterar o valor da variavel abaixo
        double valorSaque = 2600;
        System.out.printf("\nTentativa de saque de %s no valor de R$%s",
                contaFernanda.getCliente().getNome(),
                String.format("%.2f", valorSaque));

        if(contaFernanda.sacar(valorSaque)) {
            System.out.println("\nSaque efetuada com sucesso.");
        }
        else {
            System.out.println("\nErro ao fazer o saque. Saldo insuficiente.");
        }
        contaFernanda.sacar(2600);
        contaFernanda.creditarTaxa();
        contaFernanda.imprimir();


    }
}
