package dataFactory;

import client.PessoaClient;
import model.Pessoa;
import net.datafaker.Faker;
import org.apache.http.HttpStatus;

import java.text.SimpleDateFormat;
import java.util.Locale;

public class PessoaDataFactory {

    private static PessoaClient pessoaClient = new PessoaClient();
    private static Faker faker = new Faker(new Locale("PT-BR"));
    private static SimpleDateFormat data = new SimpleDateFormat("yyyy-MM-dd");

    public static Pessoa pessoaValida() {
        return novaPessoa();
    }

    public static Pessoa pessoaCadastradaAPI() {
        Pessoa pessoa = pessoaClient.cadastrarPessoa(pessoaValida())
                .then()
                    .statusCode(HttpStatus.SC_OK)
                    .extract()
                    .as(Pessoa.class)
                ;
        return pessoa;
    }

    public static Pessoa pessoaComDadosAtualizados() {
        Pessoa pessoaAtualizada = pessoaCadastradaAPI();
        pessoaAtualizada.setNome(faker.name().nameWithMiddle());
        pessoaAtualizada.setEmail(faker.internet().emailAddress());

        return pessoaAtualizada;
    }

    public static Pessoa pessoaComCpfInvalido() {
        Pessoa pessoaCpfInvalido = novaPessoa();
        pessoaCpfInvalido.setCpf(faker.cpf().invalid());
        return pessoaCpfInvalido;
    }

    private static Pessoa novaPessoa() {
        Pessoa novaPessoa = new Pessoa();
        novaPessoa.setNome(faker.name().nameWithMiddle());
        novaPessoa.setDataNascimento(data.format(faker.date().birthday()));
        novaPessoa.setCpf(faker.cpf().valid(false));
        novaPessoa.setEmail(faker.internet().emailAddress());
        return novaPessoa;
    }
}
