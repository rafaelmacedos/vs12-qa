package tests.produto;

import client.ProdutoClient;
import dataFactory.ProdutoDataFactory;
import model.ApiResponse;
import model.Produto;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.lessThan;

public class ProdutoPostTest {

    private ProdutoClient produtoClient = new ProdutoClient();

    @Test   // CT-01 - Cadastro bem-sucedido
    public void testDeveCadastrarProdutoComSucesso(){
        // Gerando massa de dados
        Produto produto = ProdutoDataFactory.produtoValido();

        // Realizando requisição de post
        ApiResponse postResponse = produtoClient.cadastrarProduto(produto)
                .then()
                    .statusCode(HttpStatus.SC_CREATED)
                    .header("Content-Type", "application/json; charset=utf-8")
                    .time(lessThan(500L))
                    .extract().as(ApiResponse.class)
                ;

        // Realizando requisição de get pelo id para saber se o produto foi cadastrado
        Produto produtoResult = produtoClient.getPeloId(postResponse.get_id())
                .then()
                    .statusCode(HttpStatus.SC_OK)
                    .header("Content-Type", "application/json; charset=utf-8")
                    .time(lessThan(500L))
                    .extract().as(Produto.class);


        // Realizando validações
        Assertions.assertAll("Asserções agrupadas de Produto",
            () -> Assertions.assertEquals(produto.getNome(), produtoResult.getNome()),
            () -> Assertions.assertEquals(produto.getDescricao(), produtoResult.getDescricao())
        );

        // Excluindo massa de dados
        produtoClient.excluirProduto(postResponse.get_id()).then().log().all().statusCode(HttpStatus.SC_OK);
    }

    @Test // CT-02 - Produto já existe
    public void testDeveCadastrarProdutoDuplicadoSemSucesso() {
        String idExistente = ProdutoDataFactory.retornarIdValidoLogitechMXVertical();

        // Gerando massa de dados a partir de produto já existente
        Produto produtoDuplicado = produtoClient.getPeloId(idExistente).then().extract().as(Produto.class);

        // Realizando requisição de post
        ApiResponse postResponse = produtoClient.cadastrarProduto(produtoDuplicado)
                .then()
                    .statusCode(HttpStatus.SC_BAD_REQUEST)
                    .header("Content-Type", "application/json; charset=utf-8")
                    .time(lessThan(500L))
                    .extract().as(ApiResponse.class)
                    ;

        // Realizando validação
        Assertions.assertEquals("Já existe produto com esse nome", postResponse.getMessage());
    }

    @Test // CT-03 - Acesso não autorizado
    public void testCadastrarProdutoSemAutenticacaoSemSucesso() {
        // Gerando massa de dados
        Produto produto = ProdutoDataFactory.produtoValido();

        // Realizando requisição de post
        ApiResponse postResponse = produtoClient.cadastrarProdutoComTokenInvalido(produto)
                .then()
                    .statusCode(HttpStatus.SC_UNAUTHORIZED)
                    .header("Content-Type", "application/json; charset=utf-8")
                    .time(lessThan(500L))
                    .extract().as(ApiResponse.class)
                    ;

        // Realizando validação
        Assertions.assertEquals("Token de acesso ausente, inválido, expirado ou usuário do token não existe mais", postResponse.getMessage());
    }


}
