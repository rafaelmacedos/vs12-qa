package tests.pessoa;

import client.PessoaClient;
import dataFactory.PessoaDataFactory;
import model.Pessoa;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PessoaTest {

    private PessoaClient pessoaClient = new PessoaClient();

    @Test
    public void testDeveCadastrarPessoaComSucesso(){
        Pessoa pessoa = PessoaDataFactory.pessoaValida();

        Pessoa pessoaResult = pessoaClient.cadastrarPessoa(pessoa)
                .then()
                    .statusCode(HttpStatus.SC_OK)
                    .log().all()
                    .extract()
                    .as(Pessoa.class)
                ;

        Assertions.assertAll("Asserções agrupadas de Pessoa",
                () -> Assertions.assertEquals(pessoa.getNome(), pessoaResult.getNome()),
                () -> Assertions.assertEquals(pessoa.getCpf(), pessoaResult.getCpf())
        );

        // excluir massa de dados
        pessoaClient.excluirPessoa(pessoaResult.getIdPessoa()).then().statusCode(HttpStatus.SC_OK);
    }

    @Test
    public void testDeveAtualizarPessoaComSucesso() {
        // pessoa cadastrada
        Pessoa pessoa = PessoaDataFactory.pessoaComDadosAtualizados();

        // chamada cliente
        Pessoa pessoaResult = pessoaClient.atualizarPessoa(pessoa.getIdPessoa(), pessoa)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .as(Pessoa.class)
                ;


        // validações
        Assertions.assertAll("Asserções agrupadas de Pessoa",
                () -> Assertions.assertEquals(pessoa.getNome(), pessoaResult.getNome()),
                () -> Assertions.assertEquals(pessoa.getCpf(), pessoaResult.getCpf())
        );

        // excluir massa de dados
        pessoaClient.excluirPessoa(pessoaResult.getIdPessoa()).then().statusCode(HttpStatus.SC_OK);
    }
}
