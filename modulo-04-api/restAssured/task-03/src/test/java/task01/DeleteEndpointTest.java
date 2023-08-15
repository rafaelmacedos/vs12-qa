package task01;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;

public class DeleteEndpointTest {
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

    @Test // CT-13 - Exclusão bem-sucedida
    public void testDeletarProdutoPorIdComSucesso() {
        // Id válido
        String idProduto = "U7CLKRfjgYXzT4hn";

        // Requisição
        given()
                .header("Authorization", this.token)
                .contentType(ContentType.JSON)
                .pathParam("_id", idProduto)
                .log().all()
        .when()
                .delete("produtos/{_id}")
        .then()
                .statusCode(200)
                .log().all()
        ;
    }

    @Test // CT-14 - Produto faz parte de carrinho
    public void testDeletarProdutoPorIdQueEstaNoCarrinhoSemSucesso() {
        // Id válido
        String idProduto = "BeeJh5lz3k6kSIzA";

        // Requisição
        given()
                .header("Authorization", this.token)
                .contentType(ContentType.JSON)
                .pathParam("_id", idProduto)
                .log().all()
        .when()
                .delete("produtos/{_id}")
        .then()
                .statusCode(400)
                .log().all()
        ;
    }

    @Test // CT-15 - Token inválido
    public void testDeletarProdutoPorIdComTokenInvalidoSemSucesso() {
        // Id válido
        String idProduto = "U7CLKRfjgYXzT4hn";

        // Requisição
        given()
                .header("Authorization", "dgg6765678gfjgh")
                .contentType(ContentType.JSON)
                .pathParam("_id", idProduto)
                .log().all()
        .when()
                .delete("produtos/{_id}")
        .then()
                .statusCode(401)
                .log().all()
        ;
    }
}
