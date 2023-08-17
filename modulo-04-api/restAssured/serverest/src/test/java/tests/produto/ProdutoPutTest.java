package tests.produto;

import client.ProdutoClient;
import dataFactory.ProdutoDataFactory;
import model.ApiResponse;
import model.Produto;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProdutoPutTest {

    private ProdutoClient produtoClient = new ProdutoClient();

    @Test// CT-10 - Atualização bem-sucedida
    public void testDeveAtualizarProdutoComSucesso() {
        // Gerando massa de dados
        Produto produto = ProdutoDataFactory.produtoComDadosAtualizados();

        // Realizando requisição de put
        ApiResponse putResponse = produtoClient.atualizarProduto(produto.get_id(), produto)
                .then()
                    .statusCode(HttpStatus.SC_OK)
                    .extract()
                    .as(ApiResponse.class)
                ;

        // Realizando validação
        Assertions.assertEquals("Registro alterado com sucesso", putResponse.getMessage());

        // Excluir massa de dados
        produtoClient.excluirProduto(produto.get_id()).then().statusCode(HttpStatus.SC_OK);
    }

    @Test // CT-11 - Cadastro bem-sucedido (usuário não encontrado)
    public void testDeveCadastrarProdutoPorIdQueNaoExisteComSucesso() {
        // Gerando massa de dados
        Produto produto = ProdutoDataFactory.produtoValido();
        produto.set_id(ProdutoDataFactory.retornarIdInvalido());

        // Realizando requisição de put
        ApiResponse putResponse = produtoClient.atualizarProduto(produto.get_id(), produto)
                .then()
                    .statusCode(HttpStatus.SC_CREATED)
                    .extract()
                    .as(ApiResponse.class)
                ;


        // Realizando validação
        Assertions.assertEquals("Cadastro realizado com sucesso", putResponse.getMessage());

        // excluir massa de dados
        produtoClient.excluirProduto(putResponse.get_id()).then().statusCode(HttpStatus.SC_OK);
    }

    @Test // CT-12 - Token inválido
    public void testAtualizarProdutoPorIdComTokenInvalidoSemSucesso() {
        // Gerando massa de dados
        Produto produto = ProdutoDataFactory.produtoComDadosAtualizados();

        // Realizando requisição de put
        ApiResponse putResponse = produtoClient.atualizarProdutoComTokenInvalido(produto.get_id(), produto)
                .then()
                    .statusCode(HttpStatus.SC_UNAUTHORIZED)
                    .extract()
                    .as(ApiResponse.class)
                ;


        // Realizando validação
        Assertions.assertEquals("Token de acesso ausente, inválido, expirado ou usuário do token não existe mais", putResponse.getMessage());
    }
}
