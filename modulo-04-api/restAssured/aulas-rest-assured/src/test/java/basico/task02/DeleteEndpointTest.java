package basico.task02;

import io.restassured.http.ContentType;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static basico.task02.data.LoginDetails.retornarStringDeLogin;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

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
                        .body(retornarStringDeLogin())
                .when()
                        .post("/login")
                .then()
                        .extract().response().jsonPath().getString("authorization");
        ;
    }

    @Test // CT-13 - Exclusão bem-sucedida
    public void testDeletarProdutoPorIdComSucesso() {
        // Id válido
        String idProduto = "lA9UG0lCZd9yCp3w";

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
                .header("Content-Type", "application/json; charset=utf-8")
                .time(lessThan(500L))
                .body("message", Matchers.equalTo("Registro excluído com sucesso"))
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
                .log().all()
                .header("Content-Type", "application/json; charset=utf-8")
                .time(lessThan(500L))
                .body("message", equalTo("Não é permitido excluir produto que faz parte de carrinho"))
                .body("idCarrinhos", hasItem("qbMqntef4iTOwWfg"))
        ;
    }

    @Test // CT-15 - Token inválido
    public void testDeletarProdutoPorIdComTokenInvalidoSemSucesso() {
        // Id válido
        String idProduto = "mI424wFAzEUsoZyO";

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
                .header("Content-Type", "application/json; charset=utf-8")
                .time(lessThan(500L))
                .body("message", equalTo("Token de acesso ausente, inválido, expirado ou usuário do token não existe mais"))
        ;
    }
}
