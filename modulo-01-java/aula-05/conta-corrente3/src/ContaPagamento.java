public class ContaPagamento extends Conta implements Impressao{
    private static final double TAXA_SAQUE = 4.25;

    public ContaPagamento(Cliente cliente, String numeroConta, int agencia, double saldo) {
        super(cliente, numeroConta, agencia, saldo);
    }

    @Override
    public boolean sacar(double valor) {
        if (valor > 0 && ((this.getSaldo() - valor) - TAXA_SAQUE) >= 0) {
            this.setSaldo((this.getSaldo() - valor) - TAXA_SAQUE);
            return true;
        }
        return false;
    }
    @Override
    public void imprimir() {
        System.out.println(
                "\n///// Conta Pagamento ///// "
                        + ""
                        + "\nCliente: "
                        + this.getCliente().getNome()
                        + "\nNúmero da Conta: "
                        + this.getNumeroConta()
                        + "\nNúmero da Agência: "
                        + this.getAgencia()
                        + "\nSaldo: R$"
                        + String.format("%.2f", this.getSaldo())
                        + "\nTaxa de Saque: R$"
                        + String.format("%.2f", TAXA_SAQUE)
        );
    }
}
