public class ContaPoupanca extends Conta implements Impressao{
    // Declarando o atributo
    private static double JUROS_MENSAL = 1.01;

    public ContaPoupanca(Cliente cliente, String numeroConta, int agencia, double saldo) {
        super(cliente, numeroConta, agencia, saldo);
    }

    // Declarando Métodos
    public void creditarTaxa() {
        this.setSaldo(this.getSaldo() * JUROS_MENSAL);
    }

    @Override
    public void imprimir() {
        System.out.println(
                "\n///// Conta Poupança ///// "
                        + ""
                        + "\nCliente: "
                        + this.getCliente().getNome()
                        + "\nNúmero da Conta: "
                        + this.getNumeroConta()
                        + "\nNúmero da Agência: "
                        + this.getAgencia()
                        + "\nSaldo: R$"
                        + String.format("%.2f", this.getSaldo())
                        + "\nJuros Mensal: "
                        + JUROS_MENSAL + "%"
        );
    }
}
