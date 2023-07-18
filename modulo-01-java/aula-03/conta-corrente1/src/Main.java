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
        contatoLucas1.telefone = "(83) 99858-8754";
        contatoLucas1.tipo = 1;
        contatoLucas1.descricao = "Somente chamadas rápidas";

        Contato contatoLucas2 = new Contato();
        contatoLucas2.telefone = "(83) 3322-3298";
        contatoLucas2.tipo = 2;
        contatoLucas2.descricao = "Telefone da Empresa";

        Endereco enderecoLucas1 = new Endereco();
        enderecoLucas1.logradouro = "Rua Capitão Fahrur";
        enderecoLucas1.numero = "7654";
        enderecoLucas1.complemento = "Casa de Esquina";
        enderecoLucas1.cep = "58498-089";
        enderecoLucas1.cidade = "Campina Grande";
        enderecoLucas1.estado = "Paraíba";
        enderecoLucas1.pais = "Brasil";
        enderecoLucas1.tipo = 1;

        Endereco enderecoLucas2 = new Endereco();
        enderecoLucas2.logradouro = "Avenida Talharim";
        enderecoLucas2.numero = "21";
        enderecoLucas2.complemento = "Prédio da Empresa";
        enderecoLucas2.cep = "58238-217";
        enderecoLucas2.cidade = "Campina Grande";
        enderecoLucas2.estado = "Paraíba";
        enderecoLucas2.pais = "Brasil";
        enderecoLucas2.tipo = 2;

        Contato[] contatosLucas = {contatoLucas1, contatoLucas2};
        Endereco[] enderecosLucas = {enderecoLucas1, enderecoLucas2};

        Cliente lucas = new Cliente();
        lucas.nome = "Lucas da Silva Sales";
        lucas.cpf = "002.009.234-32";
        lucas.enderecos = enderecosLucas;
        lucas.contatos = contatosLucas;

        ContaCorrente contaLucas = new ContaCorrente();
        contaLucas.cliente = lucas;
        contaLucas.numeroConta = "45684-20";
        contaLucas.agencia = 101;
        contaLucas.saldo = 1000;
        contaLucas.chequeEspecial = 1000;

        /////////////////////////////////////////////////////////////////////////

        Contato contatoFernanda1 = new Contato();
        contatoFernanda1.telefone = "(11) 8943-0002";
        contatoFernanda1.tipo = 1;
        contatoFernanda1.descricao = "Não atendo durante o dia";

        Contato contatoFernanda2 = new Contato();
        contatoFernanda2.telefone = "(11) 2001-9032";
        contatoFernanda2.tipo = 2;
        contatoFernanda2.descricao = "Contato do Primo";

        Endereco enderecoFernanda1 = new Endereco();
        enderecoFernanda1.logradouro = "Avenida Paulista";
        enderecoFernanda1.numero = "23";
        enderecoFernanda1.complemento = "Prédio de esquina";
        enderecoFernanda1.cep = "002003-102";
        enderecoFernanda1.cidade = "São Paulo";
        enderecoFernanda1.estado = "São Paulo";
        enderecoFernanda1.pais = "Brasil";
        enderecoFernanda1.tipo = 1;

        Endereco enderecoFernanda2 = new Endereco();
        enderecoFernanda2.logradouro = "Rua das Ostras";
        enderecoFernanda2.numero = "6743";
        enderecoFernanda2.complemento = "Firma do Primo";
        enderecoFernanda2.cep = "001244-102";
        enderecoFernanda2.cidade = "Campinas";
        enderecoFernanda2.estado = "São Paulo";
        enderecoFernanda2.pais = "Brasil";
        enderecoFernanda2.tipo = 2;

        Contato[] contatosFernanda = {contatoFernanda1, contatoFernanda2};
        Endereco[] enderecosFernanda = {enderecoFernanda1, enderecoFernanda2};

        Cliente fernanda = new Cliente();
        fernanda.nome = "Fernanda Socorro Maria";
        fernanda.cpf = "012.413.097-29";
        fernanda.enderecos = enderecosFernanda;
        fernanda.contatos = contatosFernanda;

        ContaCorrente contaFernanda = new ContaCorrente();
        contaFernanda.cliente = fernanda;
        contaFernanda.numeroConta = "22340-01";
        contaFernanda.agencia = 89;
        contaFernanda.saldo = 1000;
        contaFernanda.chequeEspecial = 1000;

        /////////////////////////////////////////////////////////////////////////
                                    //// Testes ////
        /////////////////////////////////////////////////////////////////////////

        System.out.println("\n---------- TESTE MÉTODOS CLIENTE 01 ----------\n");
        contaLucas.cliente.imprimirCliente();
        contaLucas.cliente.imprimirContatos();
        contaLucas.cliente.imprimirEnderecos();


        System.out.println("\n---------- TESTE MÉTODOS CLIENTE 02 ----------\n");
        contaFernanda.cliente.imprimirCliente();
        contaFernanda.cliente.imprimirContatos();
        contaFernanda.cliente.imprimirEnderecos();


        System.out.println("\n---------- TESTE TRANSAÇÕES 01 - ANTES DOS TRANSFERÊNCIA ----------");
        contaLucas.imprimirContaCorrente();
        contaFernanda.imprimirContaCorrente();


        // Caso algum de vocês queira testar a lógica de transferência só alterar o valor da variavel abaixo
        double valorTransferencia = 2000;
        System.out.printf("\nTentativa de transferência de %s para %s no valor de R$%s",
                contaLucas.cliente.nome,
                contaFernanda.cliente.nome,
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
