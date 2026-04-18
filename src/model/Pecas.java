public class Pecas {
    private String nome;
    private String codigo;
    private double preco;
    private int quantidade;
    private double custoRepasse;

    public Pecas(String nome, String codigo, double preco, int quantidade, double custoRepasse) {
        this.nome = nome;
        this.codigo = codigo;
        this.preco = preco;
        this.quantidade = quantidade;
        this.custoRepasse = custoRepasse;
    }

    public double calcularTotal() {
        return preco * quantidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getCustoRepasse() {
        return custoRepasse;
    }

    public void setCustoRepasse(double custoRepasse) {
        this.custoRepasse = custoRepasse;
    }
}
