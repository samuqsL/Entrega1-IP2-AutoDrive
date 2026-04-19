import java.util.ArrayList;
import java.util.List;

public class OrdemServico {
    private int numero;
    private StatusOS status;
    private String dataAbertura;
    private String dataFechamento;
    private Double valorTotal;

    private List<Pecas> listaPecas;
    private List<MaoDeObra> listaServicos;

    public OrdemServico() {
        this.listaPecas = new ArrayList<>();
        this.listaServicos = new ArrayList<>();
        this.status = StatusOS.ABERTA;
    }

    public OrdemServico(int numero, String dataAbertura) {
        this();
        this.numero = numero;
        this.dataAbertura = dataAbertura;
    }

    public Double calcularTotal() {
        double total = 0;

        for (Pecas p : listaPecas) {
            total += p.custoPecas();
        }

        for (MaoDeObra m : listaServicos) {
            total += m.calcularCusto();
        }

        this.valorTotal = total;
        return total;
    }

    public void marcarComoPago() {
        this.status = StatusOS.PAGA;
    }

    public void finalizarOS() {
        if (status == StatusOS.PAGA) {
            this.status = StatusOS.FINALIZADA;
        } else {
            System.out.println("Não é possível finalizar OS sem estar paga.");
        }
    }

    // Métodos para integração com outras classes (Relatorio/Notificacao)
    public void adicionarPeca(Pecas peca) {
        listaPecas.add(peca);
    }

    public void adicionarServico(MaoDeObra servico) {
        listaServicos.add(servico);
    }

    // Getters e Setters

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

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public List<Pecas> getListaPecas() {
        return listaPecas;
    }

    public void setListaPecas(List<Pecas> listaPecas) {
        this.listaPecas = listaPecas;
    }

    public List<MaoDeObra> getListaServicos() {
        return listaServicos;
    }

    public void setListaServicos(List<MaoDeObra> listaServicos) {
        this.listaServicos = listaServicos;
    }
}
