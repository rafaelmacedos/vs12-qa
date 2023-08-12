package task03;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import task03.pojo.ProdutoPojo;

import static io.restassured.RestAssured.*;

public class PutEndpointTest {
    String token;

    // Antes de cada teste obtém o token de autenticação e seta na variavel global
    @BeforeEach
    public void setup() {
        // Configs dados da API
        baseURI = "http://localhost:3000/";

        this.token =
                given()
                        .contentType(ContentType.JSON)
                        .body("{\"email\": \"fulano@qa.com\", \"password\": \"teste\"}")
                .when()
                        .post("/login")
                .then()
                        .extract().response().jsonPath().getString("authorization");
        ;
    }

    @Test // CT-10 - Atualização bem-sucedida
    public void testAtualizarProdutoPorIdComSucesso() {
        // Id válido
        String idProduto = "U7CLKRfjgYXzT4hn";

        // Massa de Dados
        ProdutoPojo produtoPojo = new ProdutoPojo();
        produtoPojo.setNome("Amazon SmartVacuum");
        produtoPojo.setPreco(449);
        produtoPojo.setDescricao("Aspirador inteligente da Amazon");
        produtoPojo.setQuantidade(89);

        // Requisição
        given()
                .header("Authorization", this.token)
                .contentType(ContentType.JSON)
                .pathParam("_id", idProduto)
                .body(produtoPojo)
                .log().all()
        .when()
                .put("/produtos/{_id}")
        .then()
                .statusCode(200)
                .log().all()
        ;
    }

    @Test // CT-11 - Cadastro bem-sucedido (usuário não encontrado)
    public void testCadastrarProdutoPorIdQueNaoExisteComSucesso() {
        // Id válido
        String idProduto = "gdfsgsd453535245";

        // Massa de Dados
        ProdutoPojo produtoAtualizadoPojo = new ProdutoPojo();
        produtoAtualizadoPojo.setNome("Aoc Agon 31.5pol");
        produtoAtualizadoPojo.setPreco(1559);
        produtoAtualizadoPojo.setDescricao("Monitor Gamer");
        produtoAtualizadoPojo.setQuantidade(93);

        // Requisição
        given()
                .header("Authorization", this.token)
                .contentType(ContentType.JSON)
                .pathParam("_id", idProduto)
                .body(produtoAtualizadoPojo)
                .log().all()
        .when()
                .put("/produtos/{_id}")
        .then()
                .statusCode(201)
                .log().all()
        ;
    }

    @Test // CT-12 - Token inválido
    public void testAtualizarProdutoPorIdComTokenInvalidoSemSucesso() {
        // Id válido
        String idProduto = "gdfsgsd453535245";

        // Massa de Dados
        ProdutoPojo produtoAtualizadoPojo = new ProdutoPojo();
        produtoAtualizadoPojo.setNome("Aoc Agon 31.5pol");
        produtoAtualizadoPojo.setPreco(1559);
        produtoAtualizadoPojo.setDescricao("Monitor Gamer");
        produtoAtualizadoPojo.setQuantidade(93);

        // Requisição
        given()
                .header("Authorization", "dffswe54523gdsg4532")
                .contentType(ContentType.JSON)
                .pathParam("_id", idProduto)
                .body(produtoAtualizadoPojo)
                .log().all()
        .when()
                .put("/produtos/{_id}")
        .then()
                .statusCode(401)
                .log().all()
        ;
    }

}
