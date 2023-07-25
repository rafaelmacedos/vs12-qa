import br.com.dbc.vemser.model.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Testes - Sistema Bancário")
public class ContaTest {
    Mocks mocks = new Mocks();
    ContaCorrente contaCorrente = mocks.contaCorrenteTeste01();
    ContaCorrente contaCorrenteSemSaldo = mocks.contaCorrenteTeste02();

    ContaPoupanca contaPoupanca = mocks.contaPoupancaTeste01();
    ContaPoupanca contaPoupancaSemSaldo = mocks.contaPoupancaTeste02();

    ContaPagamento contaPagamento = mocks.contaPagamentoTeste01();
    ContaPagamento contaPagamentoSemSaldo = mocks.contaPagamentoTeste02();

    @Test
    @DisplayName("Teste 01 - Deve testar saque ContaCorrente e verificar saldo com sucesso - Não deve dar certo caso o valor do saque (saque > saldo + ce)")
    void deveTestarSaqueContaCorrenteEVerificarSaldoComSucesso() {
        Boolean saqueEfetuado = contaCorrente.sacar(1500.0);
        Assertions.assertEquals(true, saqueEfetuado);

        Double saldoAposSaque = contaCorrente.getSaldo();
        Assertions.assertEquals(500.0, saldoAposSaque);
    }

    @Test
    @DisplayName("Teste 02 - Deve testar saque ContaCorrente sem saldo - Não deve dar certo caso o valor do saque (saque > saldo + ce)")
    void deveTestarSaqueContaCorrenteSemSaldo() {
        Boolean saqueEfetuado = contaCorrenteSemSaldo.sacar(2000.0);
        Assertions.assertEquals(false, saqueEfetuado);
    }

    @Test
    @DisplayName("Teste 03 - Deve testar saque ContaPoupanca e verificar saldo com sucesso - Deve creditar taxa antes")
    void deveTestarSaqueContaPoupancaEVerificarSaldoComSucesso() {
        contaPoupanca.creditarTaxa();
        // Saldo que era de 1000 vai para 1010

        Boolean saqueEfetuado = contaPoupanca.sacar(500.0);
        Assertions.assertEquals(true, saqueEfetuado);

        Double saldoAposSaque = contaPoupanca.getSaldo();
        Assertions.assertEquals(510.0, saldoAposSaque);
    }

    @Test
    @DisplayName("Teste 04 - Deve testar saque ContaPoupanca sem saldo- Não deve dar certo caso o valor do saque (saque > saldo)")
    void deveTestarSaqueContaPoupancaSemSaldo() {
        Boolean saqueEfetuado = contaPoupancaSemSaldo.sacar(2000.0);
        Assertions.assertEquals(false, saqueEfetuado);
    }

    @Test
    @DisplayName("Teste 05 - Deve testar saque ContaPagamento e verificar saldo com sucesso - Não deve dar certo caso o valor do saque (saque > saldo)")
    void deveTestarSaqueContaPagamentoEVerificarSaldoComSucesso() {
        // Lembrar aqui que a taxa de saque é R$4,25
        Boolean saqueEfetuado = contaPagamento.sacar(350.0);
        Assertions.assertEquals(true, saqueEfetuado);

        Double saldoAposSaque = contaPagamento.getSaldo();
        Assertions.assertEquals(445.75, saldoAposSaque);
    }

    @Test
    @DisplayName("Teste 06 - Deve testar saque ContaPagamento sem saldo - Não deve dar certo caso o valor do saque (saque > saldo)")
    void deveTestarSaqueContaPagamentoSemSaldo() {
        Boolean saqueEfetuado = contaPagamentoSemSaldo.sacar(1500.0);
        Assertions.assertEquals(false, saqueEfetuado);
    }

    @Test
    @DisplayName("Teste 07 - Deve testar transferencia e verificar saldo com sucesso - Não deve dar certo caso o valor da transferencia seja (transferencia > saldo)")
    void deveTestarTransferenciaEVerificarSaldoComSucesso() {
        // Aqui eu fiz simulando uma transferencia usando o cheque especial (condição única da contaCorrente)
        Boolean transferenciaDeuCerto = contaCorrente.transferir(contaPagamentoSemSaldo, 3000);
        Assertions.assertEquals(true, transferenciaDeuCerto);

        Double saldoAposSaque = contaCorrente.getSaldo();
        Assertions.assertEquals(-1000, saldoAposSaque);
    }

    @Test
    @DisplayName("Teste 08 - Deve testar transferencia sem saldo - Não deve dar certo caso o valor da transferencia seja (transferencia > saldo")
    void deveTestarTransferenciaSemSaldo() {
        Boolean transferenciaDeuCerto = contaPagamentoSemSaldo.transferir(contaCorrente, 500);
        Assertions.assertEquals(false, transferenciaDeuCerto);
    }

    @Test
    @DisplayName("Teste 09 - Deve testar deposito e verificar saldo com sucesso")
    void deveTestarDepositoEVerificarSaldoComSucesso() {
        Boolean transferenciaDeuCerto = contaPoupancaSemSaldo.depositar(3000);
        Assertions.assertEquals(true, transferenciaDeuCerto);

        Double saldoAposSaque = contaPoupancaSemSaldo.getSaldo();
        Assertions.assertEquals(3000, saldoAposSaque);
    }

    @Test
    @DisplayName("Teste 10 - Deve testar deposito negativo")
    void deveTestarDepositoNegativo() {
        Boolean transferenciaDeuCerto = contaPoupancaSemSaldo.depositar(-3000);
        Assertions.assertEquals(false, transferenciaDeuCerto);
    }
}
