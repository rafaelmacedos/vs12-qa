package basico.aula1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;

public class HelloWorldTest {

    // Antes de cada teste faça isso
    @BeforeEach
    public void setup() {
        baseURI = "https://reqres.in/api";

    }

    @Test
    public void testBuscarUsuarioPorIdComSucesso() {
        String idPessoa = "2";

        given()
                .log().all()
        .when()
                .get("/users/" + idPessoa)
        .then()
                .log().all()
                .statusCode(200)
        ;
    }
}
