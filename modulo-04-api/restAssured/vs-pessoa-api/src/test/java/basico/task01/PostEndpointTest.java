package basico.task01;

import basico.task01.pojo.ProdutoPojo;
import io.restassured.http.ContentType;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class PostEndpointTest {
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

    @Test // CT-07 - Cadastro bem-sucedido (Qk4OLh2VfXWnuY0v -> id gerado)
    public void testCadastrarProdutoComSucesso() {
        // Massa de Dados
        ProdutoPojo produtoPojo = new ProdutoPojo();
        produtoPojo.setNome("Electrolux SmartVacuum");
        produtoPojo.setPreco(349);
        produtoPojo.setDescricao("Aspirador inteligente");
        produtoPojo.setQuantidade(89);

        given()
                .header("Authorization", this.token)
                .contentType(ContentType.JSON)
                .body(produtoPojo)
                .log().all()
        .when()
                .post("/produtos")
        .then()
                .statusCode(201)
                .log().all()
        ;
    }

    @Test // CT-08 - Produto já existe
    public void testCadastrarProdutoDuplicadoSemSucesso() {
        // Massa de Dados
        ProdutoPojo produtoPojo = new ProdutoPojo();
        produtoPojo.setNome("Electrolux SmartVacuum");
        produtoPojo.setPreco(349);
        produtoPojo.setDescricao("Aspirador inteligente");
        produtoPojo.setQuantidade(89);

        given()
                .header("Authorization", this.token)
                .contentType(ContentType.JSON)
                .body(produtoPojo)
                .log().all()
        .when()
                .post("/produtos")
        .then()
                .statusCode(400)
                .log().all()
        ;
    }

    @Test // CT-09 - Acesso não autorizado
    public void testCadastrarProdutoSemAutenticacaoSemSucesso() {
        // Massa de Dados
        ProdutoPojo produtoPojo = new ProdutoPojo();
        produtoPojo.setNome("RedDragon Kumara");
        produtoPojo.setPreco(199);
        produtoPojo.setDescricao("Teclado Mecânico");
        produtoPojo.setQuantidade(674);

        given()
                .header("Authorization", "bearer 8034huhioerfh4324ihugoiafiu")
                .contentType(ContentType.JSON)
                .body(produtoPojo)
                .log().all()
        .when()
                .post("/produtos")
        .then()
                .statusCode(401)
                .log().all()
        ;
    }
}
