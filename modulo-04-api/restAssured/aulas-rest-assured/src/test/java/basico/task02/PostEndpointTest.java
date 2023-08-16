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
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.lessThan;

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
                        .body(retornarStringDeLogin())
                .when()
                        .post("/login")
                .then()
                        .extract().response().jsonPath().getString("authorization");
        ;
    }

    @Test // CT-07 - Cadastro bem-sucedido (aIh4XLbG4aNmtJb1 -> id gerado)
    public void testCadastrarProdutoComSucesso() {
        // Massa de Dados
        ProdutoPostPojo produtoEnviado = new ProdutoPostPojo();
        produtoEnviado.setNome("Polo Ralph Lauren");
        produtoEnviado.setPreco(299);
        produtoEnviado.setDescricao("Perfume");
        produtoEnviado.setQuantidade(34);

        // Cadastrando produto
        String idProdutoCadastrado =
                given()
                        .header("Authorization", this.token)
                        .contentType(ContentType.JSON)
                        .body(produtoEnviado)
                        .log().all()
                .when()
                        .post("/produtos")
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

        Assertions.assertEquals(produtoEnviado.getNome(), produtoCadastrado.getNome());
        Assertions.assertEquals(produtoEnviado.getDescricao(), produtoCadastrado.getDescricao());
        Assertions.assertEquals(produtoEnviado.getQuantidade(), produtoCadastrado.getQuantidade());
        Assertions.assertEquals(idProdutoCadastrado, produtoCadastrado.get_id());
        Assertions.assertNotNull(idProdutoCadastrado);
    }


    @Test // CT-08 - Produto já existe
    public void testCadastrarProdutoDuplicadoSemSucesso() {
        // Massa de Dados
        ProdutoPostPojo produtoPojo = new ProdutoPostPojo();
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
                .header("Content-Type", "application/json; charset=utf-8")
                .time(lessThan(500L))
                .body("message", equalTo("Já existe produto com esse nome"))
        ;
    }

    @Test // CT-09 - Acesso não autorizado
    public void testCadastrarProdutoSemAutenticacaoSemSucesso() {
        // Massa de Dados
        ProdutoPostPojo produtoPojo = new ProdutoPostPojo();
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
                .header("Content-Type", "application/json; charset=utf-8")
                .time(lessThan(500L))
                .body("message", equalTo("Token de acesso ausente, inválido, expirado ou usuário do token não existe mais"))
        ;
    }
}
