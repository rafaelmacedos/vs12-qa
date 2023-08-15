package basico.task02;

import basico.task02.pojo.ProdutoPojo;
import basico.task02.pojo.ProdutoPostPojo;
import io.restassured.http.ContentType;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static basico.task02.data.LoginDetails.retornarStringDeLogin;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

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
                        .body(retornarStringDeLogin())
                .when()
                        .post("/login")
                .then()
                        .extract().response().jsonPath().getString("authorization");
        ;
    }

    @Test // CT-10 - Atualização bem-sucedida
    public void testAtualizarProdutoPorIdComSucesso() {
        // Id válido
        String idProduto = "vlkzOOBArtbjxM2G";

        // Massa de Dados
        ProdutoPostPojo produtoPojo = new ProdutoPostPojo();
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
                .time(lessThan(400L))
                .log().all()
                .body("message", equalTo("Registro alterado com sucesso"))
        ;
    }

    @Test // CT-11 - Cadastro bem-sucedido (usuário não encontrado)
    public void testCadastrarProdutoPorIdQueNaoExisteComSucesso() {
        // Id válido
        String idProduto = "gdfsgsd453535245";

        // Massa de Dados
        ProdutoPostPojo produtoAtualizadoPojo = new ProdutoPostPojo();
        produtoAtualizadoPojo.setNome("Aoc Agon 27.5pol");
        produtoAtualizadoPojo.setPreco(1559);
        produtoAtualizadoPojo.setDescricao("Monitor Gamer");
        produtoAtualizadoPojo.setQuantidade(93);

        // Requisição
        String idProdutoCadastrado =
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
                    .header("Content-Type", "application/json; charset=utf-8")
                    .time(lessThan(500L))
                    .body("message", Matchers.equalTo("Cadastro realizado com sucesso"))
                    .extract().response().jsonPath().getString("_id");

        // Consultando produto cadastrado e fazendo validações
        ProdutoPojo produtoCadastrado =
                given()
                        .header("Authorization", this.token)
                        .pathParam("_id", idProdutoCadastrado)
                        .log().all()
                .when()
                        .get("/produtos/{_id}")
                .then()
                        .statusCode(200)
                        .log().all()
                        .extract().as(ProdutoPojo.class);
        ;

        Assertions.assertEquals(produtoAtualizadoPojo.getNome(), produtoCadastrado.getNome());
        Assertions.assertEquals(produtoAtualizadoPojo.getDescricao(), produtoCadastrado.getDescricao());
        Assertions.assertEquals(produtoAtualizadoPojo.getQuantidade(), produtoCadastrado.getQuantidade());
        Assertions.assertEquals(idProdutoCadastrado, produtoCadastrado.get_id());
        Assertions.assertNotNull(idProdutoCadastrado);
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
                .header("Content-Type", "application/json; charset=utf-8")
                .time(lessThan(500L))
                .body("message", equalTo("Token de acesso ausente, inválido, expirado ou usuário do token não existe mais"))
        ;
    }

}
