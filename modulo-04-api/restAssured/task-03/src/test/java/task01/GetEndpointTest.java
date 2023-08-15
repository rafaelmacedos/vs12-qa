package task01;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;

public class GetEndpointTest {
    private String token;

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

    @Test // CT-01 - Busca sem parâmetros bem-sucedida
    public void testBuscaSemParametrosComSucesso() {
        given()
                .header("Authorization", this.token)
                .log().all()
        .when()
                .get("/produtos")
        .then()
                .statusCode(200)
                .log().all()
        ;
    }

    @Test // CT-02 - Exceção de Parâmetro "nome" Inválido
    public void testBuscaComParametroNomeSemSucesso() {
        String nome = "**#&4329874*&$($3858fdhga";

        given()
                .header("Authorization", this.token)
                .queryParam("nome", nome)
                .log().all()
        .when()
                .get("/produtos")
        .then()
                .statusCode(200)
                .log().all()
        ;
    }

    @Test // CT-03 - Exceção de Parâmetro "preço" negativo
    public void testBuscaComParametroPrecoSemSucesso() {
        Integer preco = -50;

        given()
                .header("Authorization", this.token)
                .queryParam("preco", preco)
                .log().all()
        .when()
                .get("/produtos")
        .then()
                .statusCode(400)
                .log().all()
        ;
    }

    @Test // CT-04 - Busca bem-sucedida por ID
    public void testBuscaPorIdComSucesso() {
        String id = "BeeJh5lz3k6kSIzA";

        given()
                .header("Authorization", this.token)
                .pathParam("_id", id)
                .log().all()
        .when()
                .get("/produtos/{_id}")
        .then()
                .statusCode(200)
                .log().all()
        ;
    }

    @Test // CT-05 - Produto não encontrado
    public void testBuscaPorIdSemSucesso() {
        String id = "3123sdfafg234dfsf";

        given()
                .header("Authorization", this.token)
                .pathParam("_id", id)
                .log().all()
        .when()
                .get("/produtos/{_id}")
        .then()
                .statusCode(400)
                .log().all()
        ;
    }

    @Test // CT-06 - Requisição com ID Vazio
    public void testBuscaPorIdVazioSemSucesso() {
        // Aqui coloquei um espaço, caso contrário não iria funiconar
        String id = " ";

        given()
                .header("Authorization", this.token)
                .pathParam("_id", id)
                .log().all()
        .when()
                .get("/produtos/{_id}")
        .then()
                .statusCode(400)
                .log().all()
        ;
    }


}
