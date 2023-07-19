public class Contato {
    // Declarando os atributos
    private String descricao;
    private String telefone;
    private int tipo;

    // Construtor
    public Contato(String descricao, String telefone, int tipo) {
        this.descricao = descricao;
        this.telefone = telefone;
        this.tipo = tipo;
    }

    // Getters e Setters
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

        if (casoTipo != null) {
            System.out.println(
                    "\nTelefone: "
                    + this.telefone
                    + "\nDescrição: "
                    + this.descricao
                    + "\nTipo: "
                    + casoTipo
            );
        }

    }

}
