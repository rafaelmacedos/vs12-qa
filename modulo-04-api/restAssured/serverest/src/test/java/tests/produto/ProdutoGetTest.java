package tests.produto;

import client.ProdutoClient;
import dataFactory.ProdutoDataFactory;
import model.ApiResponse;
import org.apache.http.HttpStatus;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.*;

public class ProdutoGetTest {

    private ProdutoClient produtoClient = new ProdutoClient();

    @Test // CT-04 - Busca sem parâmetros bem-sucedida
    public void testDeveBuscarTodosProdutosComSucesso(){
        ApiResponse getResponse = produtoClient.getTodos()
                .then()
                    .statusCode(HttpStatus.SC_OK)
                    .log().all()
                    .body("produtos.nome", Matchers.hasItem("Logitech G29"))
                    .extract()
                    .as(ApiResponse.class)
                ;

        // Validações
        Assertions.assertAll("Asserções para Get Produtos",
                () -> Assertions.assertEquals(getResponse.getProdutos().length, getResponse.getQuantidade()),
                () -> Assertions.assertNotNull(getResponse.getProdutos())
                );
    }

    @Test // CT-05 - Exceção de Parâmetro "nome" Inválido
    public void testDeveBuscarComParametroNomeSemSucesso() {
        String nome = ProdutoDataFactory.retornarNomeInvalido();

        ApiResponse getResponse = produtoClient.getPeloNome(nome)
                .then()
                    .statusCode(HttpStatus.SC_OK)
                    .time(lessThan(500L))
                    .log().all()
                    .extract()
                    .as(ApiResponse.class)
                ;

        Assertions.assertAll("Asserções para Get Produtos",
                () -> Assertions.assertEquals(0, getResponse.getQuantidade()),
                () -> Assertions.assertEquals(0, getResponse.getProdutos().length)
        );
    }

    @Test // CT-06 - Exceção de Parâmetro "preço" negativo
    public void testDeveBuscarComParametroPrecoNegativoSemSucesso() {
        Integer preco = ProdutoDataFactory.retornarPrecoNegativo();

        ApiResponse getResponse = produtoClient.getPeloPreco(preco)
                .then()
                    .statusCode(HttpStatus.SC_BAD_REQUEST)
                    .time(lessThan(500L))
                    .log().all()
                    .extract()
                    .as(ApiResponse.class)
                ;

        Assertions.assertEquals("preco deve ser um número positivo", getResponse.getPreco());
    }

    @Test // CT-07 - Busca bem-sucedida por ID
    public void testDeveBuscarPorIdComSucesso() {
        String _id = ProdutoDataFactory.retornarIdValidoLogitechMXVertical();

        ApiResponse getResponse = produtoClient.getPeloId(_id)
                .then()
                    .statusCode(HttpStatus.SC_OK)
                    .time(lessThan(500L))
                    .log().all()
                    .extract()
                    .as(ApiResponse.class)
                ;

        Assertions.assertAll("Asserções para Get Produtos",
                () -> Assertions.assertEquals(381, getResponse.getQuantidade()),
                () -> Assertions.assertEquals(470, getResponse.getPreco()),
                () -> Assertions.assertEquals("Mouse", getResponse.getDescricao()),
                () -> Assertions.assertEquals("Logitech MX Vertical", getResponse.getNome()),
                () -> Assertions.assertEquals("30mJcGpoeXmXmK3O", getResponse.get_id())
        );
    }

    @Test // CT-08 - Produto não encontrado
    public void testDeveBuscarPorIdSemSucesso() {
        String _id = ProdutoDataFactory.retornarIdInvalido();

        produtoClient.getPeloId(_id)
                .then()
                    .statusCode(HttpStatus.SC_BAD_REQUEST)
                    .time(lessThan(500L))
                    .log().all()
                    .body("message", Matchers.equalTo("Produto não encontrado"))
                ;

    }

    @Test // CT-09 - Requisição com ID Vazio
    public void testBuscaPorIdVazioSemSucesso() {
        // Aqui coloquei um espaço, caso contrário não iria funiconar
        String _id = ProdutoDataFactory.retornarIdVazio();

        produtoClient.getPeloId(_id)
                .then()
                    .statusCode(HttpStatus.SC_BAD_REQUEST)
                    .time(lessThan(500L))
                    .log().all()
                    .body("message", Matchers.equalTo("Produto não encontrado"))
        ;

    }
}
