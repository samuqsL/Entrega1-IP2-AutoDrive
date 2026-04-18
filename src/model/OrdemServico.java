import java.util.ArrayList;
import java.util.List;

public class OrdemServico {

    private int numero;
    private StatusOS status;
    private String dataAbertura;
    private String dataFechamento;
    private double valorTotal;

    private List<Pecas> pecas = new ArrayList<>();
    private List<MaoDeObra> servicos = new ArrayList<>();

    public OrdemServico(int numero, String dataAbertura) {
        this.numero = numero;
        this.dataAbertura = dataAbertura;
        this.status = StatusOS.ABERTA;
    }

    // REQ20
    public void adicionarServico(MaoDeObra maoDeObra) {
        if (!maoDeObra.getMecanico().isDisponivel()) {
            throw new IllegalStateException("Mecânico indisponível!");
        }
        servicos.add(maoDeObra);
        maoDeObra.getMecanico().setDisponivel(false);
    }

    public void adicionarPeca(Pecas peca) {
        pecas.add(peca);
    }

    public double calcularTotal() {
        double total = 0;

        for (Pecas p : pecas) {
            total += p.calcularTotal();
        }

        for (MaoDeObra m : servicos) {
            total += m.calcularCusto();
        }

        this.valorTotal = total;
        return total;
    }

    public void marcarComoPago() {
        this.status = StatusOS.PAGA;
    }

    public void finalizarOS() {
        if (status != StatusOS.PAGA) {
            throw new IllegalStateException("OS só pode ser finalizada se estiver PAGA.");
        }
        this.status = StatusOS.FINALIZADA;
        this.dataFechamento = "hoje";
    }

    // REQ18
    public void excluirOS() {
        if (!pecas.isEmpty()) {
            throw new IllegalStateException("Não é possível excluir OS com peças já utilizadas.");
        }
        System.out.println("OS excluída com sucesso.");
    }

    public double calcularBonusMecanico() {
        double bonusTotal = 0;
        for (MaoDeObra m : servicos) {
            bonusTotal += m.getMecanico().getBonus();
        }
        return bonusTotal;
    }
}
