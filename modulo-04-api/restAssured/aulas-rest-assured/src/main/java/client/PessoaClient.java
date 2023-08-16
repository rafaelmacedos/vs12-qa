package client;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import model.Pessoa;
import utils.Auth;

import static io.restassured.RestAssured.*;

public class PessoaClient extends BaseClient{

    private static String token = Auth.tokenAdmin();
    private static String PESSOA = "/pessoa";

    public PessoaClient() {
        BaseClient.initConfig();
    }

    public Response cadastrarPessoa(Pessoa pessoa) {
        return
                given()
                        .header("Authorization", token)
                        .contentType(ContentType.JSON)
                        .body(pessoa)
                .when()
                        .post(PESSOA)

                ;
    }

    public Response excluirPessoa(Integer idPessoa) {
        return
                given()
                        .header("Authorization", token)
                        .pathParam("idPessoa", idPessoa)
                .when()
                        .delete(PESSOA + "/{idPessoa}")
                ;
    }

    public Response atualizarPessoa(Integer idPessoa, Pessoa pessoaAtualizada) {
        return
                given()
                        .header("Authorization", token)
                        .contentType(ContentType.JSON)
                        .body(pessoaAtualizada)
                        .pathParam("idPessoa", idPessoa)
                .when()
                        .put(PESSOA + "/{idPessoa}")

                ;
    }
}
