import br.com.dbccompany.model.Funcionario;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Classe Funcionario")
public class Teste01 {
    Funcionario funcionarioTeste = new Funcionario("Teste", "2001-04-04", "2022-01-03", 3000.0);

    @Test
    @DisplayName("Deveria retornar 22 se o usuário nasceu em 04/04/2001")
    void calcularIdade() {
        int idadeFuncionarioTeste = funcionarioTeste.calcularIdade();
        Assertions.assertEquals(22, idadeFuncionarioTeste);
    }

    @Test
    @DisplayName("Não deve retornar 30")
    void calcularIdadeNaoEh30() {
        int idadeFuncionarioTeste = funcionarioTeste.calcularIdade();
        Assertions.assertNotEquals(39, idadeFuncionarioTeste);
    }

    @Test
    @DisplayName("Deveria retornar 1 se o usuário foi contratado em 01/03/2022")
    void calcularTempoDeEmpresa() {
        int tempoDeEmpresa = funcionarioTeste.calcularTempoDeEmpresa();
        Assertions.assertEquals(1, tempoDeEmpresa);
    }
}
