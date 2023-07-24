package br.com.dbc.vemser.model;
public class Endereco {
    private int tipo;
    private String logradouro;
    private String numero;
    private String complemento;
    private String cep;
    private String cidade;
    private String estado;
    private String pais;

    // Construtor
    public Endereco(int tipo, String logradouro, String numero, String complemento, String cep, String cidade, String estado, String pais) {
        this.tipo = tipo;
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.cep = cep;
        this.cidade = cidade;
        this.estado = estado;
        this.pais = pais;
    }

    // Getters e Setters
    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    // Declarando o método
    public void imprimirEndereco() {
        String casoTipo = null;
        switch (this.tipo) {
            case 1:
                casoTipo = "Residencial";
                break;
            case 2:
                casoTipo = "Comercial";
                break;
            default:
                break;
        }

        System.out.println(
                "\nLogradouro: " + this.logradouro
                + "\nNúmero: " + this.numero
                +"\nComplemento: " + this.complemento
                +"\nCep: " + this.cep
                +"\nCidade: " + this.cidade
                +"\nEstado: " + this.estado
                +"\nPaís: " + this.pais
                + "\nTipo: " + casoTipo
        );
    }
}
