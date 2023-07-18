public class ContaCorrente {
    // Declarando os atributos
    public Cliente cliente;
    public String numeroConta;
    public int agencia;
    public double saldo;
    public double chequeEspecial;

    // Declarando os métodos
    public void imprimirContaCorrente() {
        System.out.println(
                "\n///// Conta Corrente ///// "
                        + ""
                        + "\nCliente: "
                        + this.cliente.nome
                        + "\nNúmero da Conta: "
                        + this.numeroConta
                        + "\nNúmero da Agência: "
                        + this.agencia
                        + "\nSaldo: R$"
                        + String.format("%.2f", this.saldo)
                        + "\nCheque Especial: R$"
                        + String.format("%.2f", this.chequeEspecial)
                        + "\nSaldo com Cheque Especial: R$"
                        + String.format("%.2f", retornarSaldoComChequeEspecial())
        );
    }


    public boolean sacar(double valor) {
        if (valor > 0 && (this.saldo + this.chequeEspecial - valor) >= 0) {
            this.saldo -= valor;
            return true;
        }
        return false;
    }

    public void depositar(double valor) {
        if (valor > 0) {
            this.saldo += valor;
        }
    }

    public double retornarSaldoComChequeEspecial() {
        return (this.saldo + this.chequeEspecial);
    }

    public boolean transferir(ContaCorrente contaCorrente, double valor) {
        if (this.sacar(valor)) {
            contaCorrente.depositar(valor);
            return true;
        }
        return false;
    }
}
