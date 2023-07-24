package br.com.dbccompany.model;

import java.time.LocalDate;
import java.time.Period;

public class Funcionario {
    private String nome;
    private LocalDate dataNascimento;

    private LocalDate dataAdmissao;

    private double salario;


    public Funcionario(String nome, String dataNascimento, String dataAdmissao, Double salario) {
        this.nome = nome;
        this.dataNascimento = LocalDate.parse(dataNascimento);
        this.dataAdmissao = LocalDate.parse(dataAdmissao);
        this.salario = salario;
    }

    public int calcularIdade() {
        return Period.between(dataNascimento, LocalDate.now()).getYears();
    }

    public int calcularTempoDeEmpresa() {
        return Period.between(dataAdmissao, LocalDate.now()).getYears();
    }
}
