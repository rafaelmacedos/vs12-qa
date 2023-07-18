public class Pessoa {
    String nome;
    String sobrenome;
    int idade;
    String whatsapp;

    public void conversar(Pessoa pessoa) {
        System.out.println(this.nome + " conversou com " + pessoa.nome);
    }

    public String retornarNomeCompleto() {
        return this.nome + " " + this.sobrenome;
    }

    public boolean ehMaiorDeIdade() {
        if (idade > 18) {
            return true;
        }
        return false;
    }

    public void mandarWhatsApp(Pessoa pessoa, String mensagem) {
        System.out.println(this.nome + " enviou: " + mensagem + " para " + pessoa.nome);
    }

}
