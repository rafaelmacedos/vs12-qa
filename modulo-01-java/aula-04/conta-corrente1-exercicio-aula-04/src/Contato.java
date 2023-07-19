public class Contato {
    // Declarando os atributos
    private String descricao;
    private String telefone;
    private int tipo;

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

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
