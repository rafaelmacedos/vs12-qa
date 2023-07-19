public class Cliente {
    // Declarando os atributos
    private String nome;
    private String cpf;
    private Contato[] contatos = new Contato[2];
    private Endereco[] enderecos = new Endereco[2];

    // Construtor
    public Cliente(String nome, String cpf, Contato[] contatos, Endereco[] enderecos) {
        this.nome = nome;
        this.cpf = cpf;
        this.contatos = contatos;
        this.enderecos = enderecos;
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Contato[] getContatos() {
        return contatos;
    }

    public void setContatos(Contato[] contatos) {
        this.contatos = contatos;
    }

    public Endereco[] getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(Endereco[] enderecos) {
        this.enderecos = enderecos;
    }

    // Declarando os métodos
    public void imprimirContatos() {
        for (int i = 0; i < this.contatos.length; i++) {
            System.out.printf("\nContato %d: ", i+1);
            this.contatos[i].imprimirContato();
        }
    }
    public void imprimirEnderecos() {
        for (int i = 0; i < this.enderecos.length; i++) {
            System.out.printf("\nEndereço %d: ", i+1);
            this.enderecos[i].imprimirEndereco();
        }
    }
    public void imprimirCliente() {
        System.out.println("Cliente: " + this.nome
                            + "\nCPF: " + this.cpf);
    }

}
