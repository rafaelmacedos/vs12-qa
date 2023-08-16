package dataFactory;

import client.ProdutoClient;
import model.PostResponse;
import model.Produto;
import net.datafaker.Faker;
import org.apache.http.HttpStatus;

import java.util.Locale;

public class ProdutoDataFactory {
    private static ProdutoClient produtoClient = new ProdutoClient();
    private static Faker faker = new Faker(new Locale("PT-BR"));

    public static Produto produtoValido() {
        return novoProduto();
    }

    private static Produto novoProduto() {
        // Gerando dados para um produto Livro
        String nome = faker.book().title();
        Integer preco = faker.random().nextInt(100, 10000);
        String descricao = faker.book().author();
        Integer quantidade = faker.random().nextInt(100, 10000);

        // Instanciando e retornando novo produto
        return new Produto(nome, preco, descricao, quantidade);
    }

    public static Produto produtoCadastradoAPI() {
        PostResponse postResponse = produtoClient.cadastrarProduto(produtoValido())
                .then()
                    .statusCode(HttpStatus.SC_CREATED)
                    .extract()
                    .as(PostResponse.class)
                ;
        // Realizando requisição de get pelo id para saber se o produto foi cadastrado
        Produto produtoResult = produtoClient.getPeloId(postResponse.get_id())
                .then()
                    .statusCode(HttpStatus.SC_OK)
                    .log().all()
                    .extract().as(Produto.class);

        produtoResult.set_id(postResponse.get_id());
        return produtoResult;
    }

    public static Produto produtoComDadosAtualizados() {
        Produto produtoAtualizado = produtoCadastradoAPI();
        produtoAtualizado.setNome(faker.book().title());
        produtoAtualizado.setDescricao(faker.book().author());

        return produtoAtualizado;
    }

    public static String retornarIdInvalido() {
        return "3123sdfafg234dfsf";
    }

    public static String retornarIdValidoLogitechMXVertical() {
        return "30mJcGpoeXmXmK3O";
    }

    public static String retornarIdVazio() {
        return " ";
    }

    public static String retornarNomeInvalido() {
        return "**#&4329874*&$($3858fdhga";
    }

    public static Integer retornarPrecoNegativo() {
        return faker.random().nextInt(-1, -10000);
    }

    public static String retornarIdProdutoQueEstaNoCarrinho() {
        return "BeeJh5lz3k6kSIzA";
    }

}
