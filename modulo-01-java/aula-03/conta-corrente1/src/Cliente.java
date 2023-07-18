public class Cliente {
    // Declarando os atributos
    public String nome;
    public String cpf;
    public Contato[] contatos = new Contato[2];
    public Endereco[] enderecos = new Endereco[2];

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
