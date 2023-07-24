package br.com.dbc.vemser.model;

public class Conta implements Movimentacao{
    // Declarando os atributos
    private Cliente cliente;
    private String numeroConta;
    private int agencia;
    private double saldo;

    // Construtores
    public Conta() {}
    public Conta(Cliente cliente, String numeroConta, int agencia, double saldo) {
        this.cliente = cliente;
        this.numeroConta = numeroConta;
        this.agencia = agencia;
        this.saldo = saldo;
    }

    // Getters e Setters
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

    // Declarando métodos
    @Override
    public boolean sacar(double valor) {
        if (valor > 0 && (this.saldo - valor) >= 0) {
            this.saldo -= valor;
            return true;
        }
        return false;
    }
    @Override
    public boolean depositar(double valor) {
        if (valor > 0) {
            this.saldo += valor;
            return true;
        }
        return false;
    }

    @Override
    public boolean transferir(Conta contaDestino, double valor) {
        if (this.sacar(valor)) {
            contaDestino.depositar(valor);
            return true;
        }
        return false;
    }

}
