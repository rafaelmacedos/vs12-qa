public class Endereco {
    public int tipo;
    public String logradouro;
    public String numero;
    public String complemento;
    public String cep;
    public String cidade;
    public String estado;
    public String pais;
    public void imprimirEndereco() {
        System.out.println(
                "\nLogradouro: "
                        + this.logradouro
                        + "\nNúmero: "
                        + this.numero
                        +"\nComplemento: "
                        + this.complemento
                        +"\nCep: "
                        + this.cep
                        +"\nCidade: "
                        + this.cidade
                        +"\nEstado: "
                        + this.estado
                        +"\nPaís: "
                        + this.pais
                        + "\nTipo: "
                        + (this.tipo == 1 ? "Residencial" : "Comercial")
        );
    }


}
