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

    public void adicionarServico(MaoDeObra maoDeObra) {
        if (!maoDeObra.getMecanico().isDisponivel()) {
            throw new IllegalStateException("Mecânico indisponível");
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

    public void finalizarOS(Cliente cliente, Veiculo veiculo) {
        if (status != StatusOS.PAGA) {
            throw new IllegalStateException("OS só pode ser finalizada se estiver PAGA");
        }

        this.status = StatusOS.FINALIZADA;
        this.dataFechamento = "hoje";

        Relatorio relatorio = new Relatorio(null, this);
        relatorio.emitirRelatorioOS();

        Notificacao notificacao = new Notificacao(
                veiculo.getQuilometragem(),
                0,
                "hoje",
                cliente,
                veiculo
        );
        notificacao.notificarCliente();
    }

    public void excluirOS() {
        if (!pecas.isEmpty()) {
            throw new IllegalStateException("Não é possível excluir OS com peças já utilizadas");
        }
        System.out.println("OS excluída com sucesso");
    }

    public double calcularBonusMecanico() {
        double bonusTotal = 0;
        for (MaoDeObra m : servicos) {
            bonusTotal += m.getMecanico().getBonus();
        }
        return bonusTotal;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public StatusOS getStatus() {
        return status;
    }

    public void setStatus(StatusOS status) {
        this.status = status;
    }

    public String getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(String dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    public String getDataFechamento() {
        return dataFechamento;
    }

    public void setDataFechamento(String dataFechamento) {
        this.dataFechamento = dataFechamento;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public List<Pecas> getPecas() {
        return pecas;
    }

    public void setPecas(List<Pecas> pecas) {
        this.pecas = pecas;
    }

    public List<MaoDeObra> getServicos() {
        return servicos;
    }

    public void setServicos(List<MaoDeObra> servicos) {
        this.servicos = servicos;
    }
}
