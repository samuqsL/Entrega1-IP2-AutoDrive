public class MaoDeObra {
    private String descricao;
    private double valor;
    private double horas;
    private Mecanico mecanico;

    public MaoDeObra(String descricao, double valor, double horas, Mecanico mecanico) {
        this.descricao = descricao;
        this.valor = valor;
        this.horas = horas;
        this.mecanico = mecanico;
    }

    public double calcularCusto() {
        return valor * horas;
    }

    public Mecanico getMecanico() {
        return mecanico;
    }
}
