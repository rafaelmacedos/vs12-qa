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
        Contato contatoLucas1 = new Contato();
        contatoLucas1.setTelefone("(83) 99858-8754");
        contatoLucas1.setTipo(1);
        contatoLucas1.setDescricao("Somente chamadas rápidas");

        Contato contatoLucas2 = new Contato();
        contatoLucas2.setTelefone("(83) 3322-3298");
        contatoLucas2.setTipo(2);
        contatoLucas2.setDescricao("Telefone da Empresa");

        Endereco enderecoLucas1 = new Endereco();
        enderecoLucas1.setLogradouro("Avenida Talharim");
        enderecoLucas1.setEstado("21");
        enderecoLucas1.setComplemento("Prédio da Empresa");
        enderecoLucas1.setCep("58238-217");
        enderecoLucas1.setCidade("Campina Grande");
        enderecoLucas1.setEstado( "Paraíba");
        enderecoLucas1.setPais("Brasil");
        enderecoLucas1.setTipo(1);

        Endereco enderecoLucas2 = new Endereco();
        enderecoLucas2.setLogradouro("Rua Capitão Fahrur");
        enderecoLucas2.setEstado("7654");
        enderecoLucas2.setComplemento("Casa de Esquina");
        enderecoLucas2.setCep("58498-089");
        enderecoLucas2.setCidade("Campina Grande");
        enderecoLucas2.setEstado( "Paraíba");
        enderecoLucas2.setPais("Brasil");
        enderecoLucas2.setTipo(1);

        Contato[] contatosLucas = {contatoLucas1, contatoLucas2};
        Endereco[] enderecosLucas = {enderecoLucas1, enderecoLucas2};

        Cliente lucas = new Cliente();
        lucas.setNome("Lucas da Silva Sales");
        lucas.setCpf("002.009.234-32");
        lucas.setEnderecos(enderecosLucas);
        lucas.setContatos(contatosLucas);

        ContaCorrente contaLucas = new ContaCorrente();
        contaLucas.setCliente(lucas);
        contaLucas.setNumeroConta("45684-20");
        contaLucas.setAgencia(101);
        contaLucas.setSaldo(1000);
        contaLucas.setChequeEspecial(1000);

        /////////////////////////////////////////////////////////////////////////

        Contato contatoFernanda1 = new Contato();
        contatoFernanda1.setTelefone("(11) 8943-0002");
        contatoFernanda1.setTipo(1);
        contatoFernanda1.setDescricao("Não atendo durante o dia");

        Contato contatoFernanda2 = new Contato();
        contatoFernanda2.setTelefone("(11) 2001-9032");
        contatoFernanda2.setTipo(2);
        contatoFernanda2.setDescricao("Contato do Primo");

        Endereco enderecoFernanda1 = new Endereco();
        enderecoFernanda1.setLogradouro("Avenida Paulista");
        enderecoFernanda1.setNumero("23");
        enderecoFernanda1.setComplemento("Prédio de esquina");
        enderecoFernanda1.setCep("002003-102");
        enderecoFernanda1.setCidade("São Paulo");
        enderecoFernanda1.setEstado("São Paulo");
        enderecoFernanda1.setPais("Brasil");
        enderecoFernanda1.setTipo(1);

        Endereco enderecoFernanda2 = new Endereco();
        enderecoFernanda2.setLogradouro("Rua das Ostras");
        enderecoFernanda2.setNumero("6743");
        enderecoFernanda2.setComplemento("Firma do Primo");
        enderecoFernanda2.setCep("001244-102");
        enderecoFernanda2.setCidade("Campinas");
        enderecoFernanda2.setEstado("São Paulo");
        enderecoFernanda2.setPais("Brasil");
        enderecoFernanda2.setTipo(2);

        Contato[] contatosFernanda = {contatoFernanda1, contatoFernanda2};
        Endereco[] enderecosFernanda = {enderecoFernanda1, enderecoFernanda2};

        Cliente fernanda = new Cliente();
        fernanda.setNome("Fernanda Socorro Maria");
        fernanda.setCpf("012.413.097-29");
        fernanda.setEnderecos(enderecosFernanda);
        fernanda.setContatos(contatosFernanda);

        ContaCorrente contaFernanda = new ContaCorrente();
        contaFernanda.setCliente(fernanda);
        contaFernanda.setNumeroConta("22340-01");
        contaFernanda.setAgencia(89);
        contaFernanda.setSaldo(1000);
        contaFernanda.setChequeEspecial(1000);

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
        contaLucas.imprimirContaCorrente();
        contaFernanda.imprimirContaCorrente();


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

        contaLucas.imprimirContaCorrente();
        contaFernanda.imprimirContaCorrente();

        System.out.println("\n---------- TESTE TRANSAÇÕES 03 - DEPOIS DO DEPÓSITO E SAQUE ----------");
        contaLucas.depositar(150);
        contaLucas.sacar(50);

        contaFernanda.depositar(150);
        contaFernanda.sacar(50);

        contaLucas.imprimirContaCorrente();
        contaFernanda.imprimirContaCorrente();


    }
}
