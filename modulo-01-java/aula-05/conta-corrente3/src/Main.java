public class Main {
    public static void main(String[] args) {
        // ascii art...
        System.out.println("\n.______        ___      .__   __.   ______   ______       _______  .______     ______ \n" +
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
                "Rua Major Johnny",
                "223",
                "Prédio Azul",
                "58401-333",
                "Campina Grande",
                "Paraíba",
                "Brasil"
        );

        Endereco enderecoLucas2 = new Endereco(2,
                "Avenida Cabral",
                "56",
                "Prédio da Firma",
                "58238-609",
                "Campina Grande",
                "Paraíba",
                "Brasil"
        );

        Cliente lucas = new Cliente("Lucas da Silva Sales", "002.009.234-32");
        lucas.setContatos(contatoLucas1);
        lucas.setContatos(contatoLucas2);
        lucas.setEnderecos(enderecoLucas1);
        lucas.setEnderecos(enderecoLucas2);

        ContaCorrente contaLucas = new ContaCorrente(lucas,
                "45684-20",
                101,
                1000,
                1000
                );

        ContaPagamento contaPagamentoLucas = new ContaPagamento(lucas,
                "22314-09",
                89,
                800);

        //////////////////////////////////////////////////////////////////////////////////////////////

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

        Cliente fernanda = new Cliente("Fernanda Socorro Maria", "012.413.097-29");
        fernanda.setContatos(contatoFernanda1);
        fernanda.setContatos(contatoFernanda2);
        fernanda.setEnderecos(enderecoFernanda1);
        fernanda.setEnderecos(enderecoFernanda2);

        ContaPoupanca contaFernanda = new ContaPoupanca(fernanda,
                "22340-01",
                89,
                1000);


        //////////////////////////////////////////////////////////////////////////////////////////////
                                                //// Testes ////
        //////////////////////////////////////////////////////////////////////////////////////////////


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

        System.out.println("\n---------- TESTE TRANSAÇÕES 05 - TESTE DA NOVA CLASSE CONTA PAGAMENTO ----------");

        contaPagamentoLucas.imprimir();

        // Caso algum de vocês queira testar a lógica de saque só alterar o valor da variavel abaixo
        double valorSaqueContaPagamento = 795.75;
        System.out.printf("\nTentativa de saque de %s no valor de R$%s",
                contaPagamentoLucas.getCliente().getNome(),
                String.format("%.2f", valorSaqueContaPagamento));

        if(contaPagamentoLucas.sacar(valorSaqueContaPagamento)) {
            System.out.println("\nSaque efetuada com sucesso.");
        }
        else {
            System.out.println("\nErro ao fazer o saque. Saldo insuficiente.");
        }

        contaPagamentoLucas.depositar(500);

        // Caso algum de vocês queira testar a lógica de transferência só alterar o valor da variavel abaixo
        double valorTransferenciaPagamento = 395.75;
        System.out.printf("\nTentativa de transferência de %s para %s no valor de R$%s",
                contaPagamentoLucas.getCliente().getNome(),
                contaFernanda.getCliente().getNome(),
                String.format("%.2f", valorTransferenciaPagamento));

        if(contaPagamentoLucas.transferir(contaFernanda, valorTransferenciaPagamento)) {
            System.out.println("\nTransferência efetuada com sucesso.");
        }
        else {
            System.out.println("\nErro ao fazer a Transferência. Saldo insuficiente.");
        }

        contaPagamentoLucas.imprimir();
        contaFernanda.imprimir();

        System.out.println("\n--------------------------------------------------------------------------------");
        System.out.println("OBRIGADO POR UTILIZAR O BANCO DBC :)");
        System.out.println("--------------------------------------------------------------------------------");


    }
}
