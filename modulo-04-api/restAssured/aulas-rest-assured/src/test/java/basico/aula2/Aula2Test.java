package basico.aula2;

import basico.aula1.pojo.PessoaPojoTest;
import io.restassured.http.ContentType;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class Aula2Test {
    private String token;

    // Antes de cada teste faça algo
    @BeforeEach
    public void setup() {
        // Configs dados da API
        baseURI = "http://vemser-dbc.dbccompany.com.br:39000/vemser/dbc-pessoa-api";

        // obter token
        this.token =
                given()
                        .contentType(ContentType.JSON)
                        .body("{\"login\": \"admin\" , \"senha\":\"123\"}")
                .when()
                        .post("/auth")

                .then()
                        .extract().asString();
        ;
    }

    @Test
    public void testListarPessoas() {

        given()
                .header("Authorization", this.token)
                .log().all()
        .when()
                .get("/pessoa")
        .then()
                .statusCode(200)
                .header("Content-Type", "application/json")
                .time(lessThan(400L))
                .log().all()
                .body("totalElements", greaterThan(8800))
                .body("content.nome", Matchers.hasItem("Miss Curt Fahey Wisozk"))
                .body("content[0].email", Matchers.equalTo("roberta.armstrong@hotmail.com"))

        ;
    }

    @Test
    public void testBuscarPessoaPorCpfComSucesso() {
        String cpf = "12365478963";

        PessoaPojoTest pessoa =
        given()
                .header("Authorization", this.token)
                .pathParam("cpf", cpf)
                .log().all()
        .when()
                .get("/pessoa/{cpf}/cpf")
        .then()
                .statusCode(200)
                .log().all()
                .extract().as(PessoaPojoTest.class)
        ;
        Assertions.assertEquals("Mr. Liza Keeling Skiles", pessoa.getNome());
        Assertions.assertEquals("1986-11-07", pessoa.getDataNascimento());
        Assertions.assertNotNull(pessoa.getIdPessoa());
    }
}
