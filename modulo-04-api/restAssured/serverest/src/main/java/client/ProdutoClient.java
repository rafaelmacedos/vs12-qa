package client;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import model.Produto;
import utils.Login;

import static io.restassured.RestAssured.*;

public class ProdutoClient extends BaseClient {
    private static final String token = Login.tokenAdmin();
    private static final String tokenInvalido = "Bearer sfdakjfhj324124h3j4kg43fdsagf";
    private static final String PRODUTOS = "/produtos";

    public ProdutoClient() {
        BaseClient.initConfig();
    }

    public Response cadastrarProduto(Produto produto) {
        return
                given()
                        .header("Authorization", token)
                        .contentType(ContentType.JSON)
                        .body(produto)
                .when()
                        .post(PRODUTOS)

                ;
    }
    public Response cadastrarProdutoComTokenInvalido(Produto produto) {
        return
                given()
                        .header("Authorization",tokenInvalido)
                        .contentType(ContentType.JSON)
                        .body(produto)
                .when()
                        .post(PRODUTOS)

                ;
    }

    public Response excluirProduto(String _id) {
        return
                given()
                        .header("Authorization", token)
                        .pathParam("_id", _id)
                .when()
                        .delete(PRODUTOS + "/{_id}")
                ;
    }

    public Response excluirProdutoComTokenInvalido(String _id) {
        return
                given()
                        .header("Authorization", tokenInvalido)
                        .pathParam("_id", _id)
                        .when()
                        .delete(PRODUTOS + "/{_id}")
                ;
    }

    public Response atualizarProduto(String _id, Produto produtoAtualizado) {
        return
                given()
                        .header("Authorization", token)
                        .contentType(ContentType.JSON)
                        .body(produtoAtualizado)
                        .pathParam("_id", _id)
                .when()
                        .put(PRODUTOS + "/{_id}")

                ;
    }
    public Response atualizarProdutoComTokenInvalido(String _id, Produto produtoAtualizado) {
        return
                given()
                        .header("Authorization", "Bearer sfdakjfhj324124h3j4kg43fdsagf")
                        .contentType(ContentType.JSON)
                        .body(produtoAtualizado)
                        .pathParam("_id", _id)
                        .when()
                        .put(PRODUTOS + "/{_id}")

                ;
    }
    public Response getTodos() {
        return
                given()
                        .header("Authorization", token)
                .when()
                        .get(PRODUTOS)
                ;
    }

    public Response getPeloId(String _id) {
        return
            given()
                    .header("Authorization", token)
                    .pathParam("_id", _id)
                    .log().all()
            .when()
                    .get("/produtos/{_id}");
    }

    public Response getPeloNome(String nome) {
        return
                given()
                        .header("Authorization", token)
                        .queryParam("nome", nome)
                .when()
                        .get(PRODUTOS)
                ;
    }

    public Response getPeloPreco(Integer preco) {
        return
                given()
                        .header("Authorization", token)
                        .queryParam("preco", preco)
                        .when()
                        .get(PRODUTOS)
                ;
    }

}
