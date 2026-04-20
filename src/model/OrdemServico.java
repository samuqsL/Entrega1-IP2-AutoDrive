import java.util.ArrayList;
import java.util.List;

public class OrdemServico {
    private int numero;
    private StatusOS status;
    private String dataAbertura;
    private String dataFechamento;
    private Double valorTotal;

    private Cliente cliente;
    private Veiculo veiculo;

    private List<Pecas> listaPecas;
    private List<MaoDeObra> listaServicos;

    public OrdemServico() {
        this.listaPecas = new ArrayList<>();
        this.listaServicos = new ArrayList<>();
        this.status = StatusOS.ABERTA;
    }

    // Construtor atualizado (REQ06)
    public OrdemServico(int numero, String dataAbertura, Cliente cliente, Veiculo veiculo) {
        this();
        this.numero = numero;
        this.dataAbertura = dataAbertura;
        this.cliente = cliente;
        this.veiculo = veiculo;
    }

    // REQ07 – adicionar itens
    public void adicionarPeca(Pecas peca, int quantidade) {
        if (peca.retirarDoEstoque(quantidade)) {
            Pecas item = new Pecas(
                peca.getNome(),
                peca.getCodigo(),
                peca.getPreco(),
                quantidade
            );
            listaPecas.add(item);
        } else {
            System.out.println("Estoque insuficiente para: " + peca.getNome());
        }
    }

    //REQ20
    public void adicionarServico(MaoDeObra servico) {
        if (!servico.getMecanico().isDisponivel()) {
            System.out.println("Mecânico indisponível.");
            return;
        }
        listaServicos.add(servico);
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
            System.out.println("OS precisa estar PAGA.");
        }
    }

    public boolean validarItensObrigatorios() {
    boolean temOleo = false;

    for (Pecas p : listaPecas) {
        if (p.getNome().equalsIgnoreCase("oleo")) {
            temOleo = true;
            break;
        }
    }

    if (!temOleo) {
        System.out.println("Item obrigatório não incluído: Óleo");
        return false;
    }

    return true;
}

    // Getters e Setters
    public int getNumero() { return numero; }
    public void setNumero(int numero) { this.numero = numero; }

    public StatusOS getStatus() { return status; }
    public void setStatus(StatusOS status) { this.status = status; }

    public String getDataAbertura() { return dataAbertura; }
    public void setDataAbertura(String dataAbertura) { this.dataAbertura = dataAbertura; }

    public String getDataFechamento() { return dataFechamento; }
    public void setDataFechamento(String dataFechamento) { this.dataFechamento = dataFechamento; }

    public Double getValorTotal() { return valorTotal; }
    public void setValorTotal(Double valorTotal) { this.valorTotal = valorTotal; }

    public Cliente getCliente() { return cliente; }
    public void setCliente(Cliente cliente) { this.cliente = cliente; }

    public Veiculo getVeiculo() { return veiculo; }
    public void setVeiculo(Veiculo veiculo) { this.veiculo = veiculo; }

    public List<Pecas> getListaPecas() { return listaPecas; }
    public void setListaPecas(List<Pecas> listaPecas) { this.listaPecas = listaPecas; }

    public List<MaoDeObra> getListaServicos() { return listaServicos; }
    public void setListaServicos(List<MaoDeObra> listaServicos) { this.listaServicos = listaServicos; }
}
