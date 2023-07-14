package ex02;

public class Cidade {
    private int id;
    private String nome;
    private String festaPrincipal;
    private double idh;
    private int populacao;

    public Cidade(int id, String nome, String festaPrincipal, double idh, int populacao) {
        this.id = id;
        this.nome = nome;
        this.festaPrincipal = festaPrincipal;
        this.idh = idh;
        this.populacao = populacao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFestaPrincipal() {
        return festaPrincipal;
    }

    public void setFestaPrincipal(String festaPrincipal) {
        this.festaPrincipal = festaPrincipal;
    }

    public double getIdh() {
        return idh;
    }

    public void setIdh(double idh) {
        this.idh = idh;
    }

    public int getPopulacao() {
        return populacao;
    }

    public void setPopulacao(int populacao) {
        this.populacao = populacao;
    }
}
