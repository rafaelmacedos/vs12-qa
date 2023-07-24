package br.com.dbc.vemser.model;

public class ContaCorrente extends Conta implements Impressao {
    // Declarando os atributos
    private double chequeEspecial;

    // Construtor
    public ContaCorrente(Cliente cliente, String numeroConta, int agencia, double saldo, double chequeEspecial) {
        super(cliente, numeroConta, agencia, saldo);
        this.chequeEspecial = chequeEspecial;
    }

    // Getters e setters
    public double getChequeEspecial() {
        return chequeEspecial;
    }

    public void setChequeEspecial(double chequeEspecial) {
        this.chequeEspecial = chequeEspecial;
    }

    // Declarando Métodos

    @Override
    public void imprimir() {
        System.out.println(
                "\n///// Conta Corrente ///// "
                + ""
                + "\nCliente: " + this.getCliente().getNome()
                + "\nNúmero da Conta: " + this.getNumeroConta()
                + "\nNúmero da Agência: " + this.getAgencia()
                + "\nSaldo: R$" + String.format("%.2f", this.getSaldo())
                + "\nCheque Especial: R$" + String.format("%.2f", this.chequeEspecial)
                + "\nSaldo com Cheque Especial: R$" + String.format("%.2f", retornarSaldoComChequeEspecial())
        );
    }

    public double retornarSaldoComChequeEspecial() {
        return (this.getSaldo() + this.chequeEspecial);
    }

    @Override
    public boolean sacar(double valor) {
        if (valor > 0 && (this.getSaldo() + this.chequeEspecial - valor) >= 0) {
            this.setSaldo(this.getSaldo() - valor);
            return true;
        }
        return false;
    }

}
