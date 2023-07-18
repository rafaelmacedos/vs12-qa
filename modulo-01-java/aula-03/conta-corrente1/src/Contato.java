public class Contato {
    // Declarando os atributos
    public String descricao;
    public String telefone;
    public int tipo;

    // Declarando o método
    public void imprimirContato() {
        System.out.println(
                "\nTelefone: "
                + this.telefone
                + "\nDescrição: "
                + this.descricao
                + "\nTipo: "
                + (this.tipo == 1 ? "Residencial" : "Comercial")
        );
    }

}
