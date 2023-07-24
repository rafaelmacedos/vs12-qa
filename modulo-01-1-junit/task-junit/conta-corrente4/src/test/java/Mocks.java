import br.com.dbc.vemser.model.*;

import java.util.ArrayList;

public class Mocks {
    public ContaCorrente contaCorrenteTeste01() {
        Contato contatoLucas1 = new Contato("Somente chamadas rápidas", "(83) 99858-8754", 1);

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
                2000,
                1000
        );

        return contaLucas;
    }

    public ContaCorrente contaCorrenteTeste02() {
        Contato contatoLucas1 = new Contato("Somente chamadas rápidas", "(83) 99858-8754", 1);

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
                0,
                1000
        );

        return contaLucas;
    }

    public ContaPoupanca contaPoupancaTeste01() {
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

        return contaFernanda;
    }

    public ContaPoupanca contaPoupancaTeste02() {
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
                0);

        return contaFernanda;
    }

    public ContaPagamento contaPagamentoTeste01() {
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

        return contaPagamentoLucas;
    }

    public ContaPagamento contaPagamentoTeste02() {
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

        ContaPagamento contaPagamentoLucas = new ContaPagamento(lucas,
                "22314-09",
                89,
                0);

        return contaPagamentoLucas;
    }
}