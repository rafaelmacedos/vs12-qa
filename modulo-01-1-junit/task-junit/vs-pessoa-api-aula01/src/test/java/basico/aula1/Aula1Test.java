package basico.aula1;

import basico.aula1.pojo.PessoaPojo;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;

import static io.restassured.RestAssured.baseURI;

public class Aula1Test {

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
                .log().all()
        ;
    }

    @Test
    public void testBuscarPessoaPorCpfComSucesso() {
        String cpf = "12365478963";
        given()
                .header("Authorization", this.token)
                .pathParam("cpf", cpf)
                .log().all()
        .when()
                .get("/pessoa/{cpf}/cpf")
        .then()
                .statusCode(200)
                .log().all()
        ;
    }

    @Test
    public void testBuscarPessoaPorNomeComSucesso() {
        String nome = "Joseph Safra da Silva";

        given()
                .header("Authorization", this.token)
                .queryParam("nome", nome)
                .log().all()
        .when()
                .get("/pessoa/byname")
        .then()
                .statusCode(200)
                .log().all()
        ;
    }

    @Test
     public void testAdicionarPessoaComSucesso() {
        // Massa de Dados
        PessoaPojo pessoaPojo = new PessoaPojo();
        pessoaPojo.setNome("Joseph Safra Correias");
        pessoaPojo.setDataNascimento("1995-09-03");
        pessoaPojo.setCpf("95847345631");
        pessoaPojo.setEmail("alyson@email.com");

        // Preciso de um body com dados válidos
        given()
                .header("Authorization", this.token)
                .contentType(ContentType.JSON)
                .body(pessoaPojo)
                .log().all()
        .when()
                .post("/pessoa")
        .then()
                .statusCode(200)
                .log().all()
        ;
    }

    @Test
    public void testAtualizarPessoaPorIdComSucesso() {
        // Id válido
        String idPessoa = "23853";

        // Massa de Dados
        PessoaPojo pessoaAtualizadaPojo = new PessoaPojo();
        pessoaAtualizadaPojo.setNome("Joseph Safra da Silva");
        pessoaAtualizadaPojo.setDataNascimento("1995-09-03");
        pessoaAtualizadaPojo.setCpf("95847345631");
        pessoaAtualizadaPojo.setEmail("joseph@email.com");

        // Requisição
        given()
                .header("Authorization", this.token)
                .contentType(ContentType.JSON)
                .pathParam("idPessoa", idPessoa)
                .body(pessoaAtualizadaPojo)
                .log().all()
        .when()
                .put("/pessoa/{idPessoa}")
        .then()
                .statusCode(200)
                .log().all()
        ;
    }

    @Test
    public void testDeletarPessoaPorIdComSucesso() {
        // Id válido
        String idPessoa = "23853";

        // Requisição
        given()
                .header("Authorization", this.token)
                .contentType(ContentType.JSON)
                .pathParam("idPessoa", idPessoa)
                .log().all()
        .when()
                .delete("/delete/{idPessoa}")
        .then()
                .statusCode(200)
                .log().all()
        ;
    }
}
