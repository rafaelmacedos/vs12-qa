public class ContaCorrente {
    // Declarando os atributos
    private Cliente cliente;
    private String numeroConta;
    private int agencia;
    private double saldo;
    private double chequeEspecial;

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(String numeroConta) {
        this.numeroConta = numeroConta;
    }

    public int getAgencia() {
        return agencia;
    }

    public void setAgencia(int agencia) {
        this.agencia = agencia;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public double getChequeEspecial() {
        return chequeEspecial;
    }

    public void setChequeEspecial(double chequeEspecial) {
        this.chequeEspecial = chequeEspecial;
    }

    // Declarando os métodos
    public void imprimirContaCorrente() {
        System.out.println(
                "\n///// Conta Corrente ///// "
                        + ""
                        + "\nCliente: "
                        + this.cliente.getNome()
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
