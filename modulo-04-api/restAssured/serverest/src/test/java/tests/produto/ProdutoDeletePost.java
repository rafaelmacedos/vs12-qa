package tests.produto;

import client.ProdutoClient;
import dataFactory.ProdutoDataFactory;
import model.ApiResponse;
import model.Produto;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.lessThan;

public class ProdutoDeletePost {
    private ProdutoClient produtoClient = new ProdutoClient();

    @Test // CT-13 - Exclusão bem-sucedida
    public void testDeveDeletarProdutoPorIdComSucesso() {
        // Gerando massa de dados
        Produto produto = ProdutoDataFactory.produtoValido();
        String _id  = produtoClient.cadastrarProduto(produto).then().extract().as(ApiResponse.class).get_id();

        // Realizando requisição de delete
        ApiResponse deleteResponse = produtoClient.excluirProduto(_id)
                .then()
                    .statusCode(HttpStatus.SC_OK)
                    .header("Content-Type", "application/json; charset=utf-8")
                    .time(lessThan(500L))
                    .extract().as(ApiResponse.class)
                ;

        // Realizando validação
        Assertions.assertEquals("Registro excluído com sucesso", deleteResponse.getMessage());
    }

    @Test // CT-14 - Produto faz parte de carrinho
    public void testDeveDeletarProdutoPorIdQueEstaNoCarrinhoSemSucesso() {
        String _id  = ProdutoDataFactory.retornarIdProdutoQueEstaNoCarrinho();

        // Realizando requisição de delete
        ApiResponse deleteResponse = produtoClient.excluirProduto(_id)
                .then()
                    .statusCode(HttpStatus.SC_BAD_REQUEST)
                    .header("Content-Type", "application/json; charset=utf-8")
                    .time(lessThan(500L))
                    .body("idCarrinhos", hasItem("qbMqntef4iTOwWfg"))
                    .extract().as(ApiResponse.class)
                ;

        // Realizando validação
        Assertions.assertEquals("Não é permitido excluir produto que faz parte de carrinho", deleteResponse.getMessage());
    }

    @Test // CT-15 - Token inválido
    public void testDeveDeletarProdutoPorIdComTokenInvalidoSemSucesso() {
        // Gerando massa de dados
        Produto produto = ProdutoDataFactory.produtoValido();
        String _id  = produtoClient.cadastrarProduto(produto).then().extract().as(ApiResponse.class).get_id();

        // Realizando requisição de delete
        ApiResponse deleteResponse = produtoClient.excluirProdutoComTokenInvalido(_id)
                .then()
                    .statusCode(HttpStatus.SC_UNAUTHORIZED)
                    .header("Content-Type", "application/json; charset=utf-8")
                    .time(lessThan(500L))
                    .extract().as(ApiResponse.class)
                ;

        // Realizando validação
        Assertions.assertEquals("Token de acesso ausente, inválido, expirado ou usuário do token não existe mais", deleteResponse.getMessage());
    }

}
