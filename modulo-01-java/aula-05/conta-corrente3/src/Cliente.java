import java.util.ArrayList;

public class Cliente {
    // Declarando os atributos
    private String nome;
    private String cpf;
    private ArrayList<Contato> contatos;
    private ArrayList<Endereco> enderecos;

    // Construtor
    public Cliente(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
        this.contatos = new ArrayList<Contato>();
        this.enderecos = new ArrayList<Endereco>();
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

    public ArrayList<Contato> getContatos() {
        return contatos;
    }

    public void setContatos(Contato novoContato) {
        this.contatos.add(novoContato);
    }

    public ArrayList<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(Endereco novoEndereco) {
        this.enderecos.add(novoEndereco);
    }

    // Declarando os métodos
    public void imprimirContatos() {
        for (int i = 0; i < this.contatos.size(); i++) {
            System.out.printf("\nContato %d: ", i+1);
            this.contatos.get(i).imprimirContato();
        }
    }
    public void imprimirEnderecos() {
        for (int i = 0; i < this.enderecos.size(); i++) {
            System.out.printf("\nEndereço %d: ", i+1);
            this.enderecos.get(i).imprimirEndereco();
        }
    }
    public void imprimirCliente() {
        System.out.println("Cliente: " + this.nome
                            + "\nCPF: " + this.cpf);
    }

}
