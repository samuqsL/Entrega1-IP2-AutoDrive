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

    public int getQuantidade() {
        return quantidade;
    }
}
