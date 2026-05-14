package br.ufrpe.autodrive.negocio.beans;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

public class Relatorio {
    private List<Venda> listaVendas;
    private List<OrdemServico> listaOs;

    public Relatorio(List<Venda> vendas, List<OrdemServico> ordens) {
        this.listaVendas = (vendas != null) ? new ArrayList<>(vendas) : new ArrayList<>();
        this.listaOs = (ordens != null) ? new ArrayList<>(ordens) : new ArrayList<>();
    }

    // Filtros para o REQ09
    public List<Venda> filtrarPorVendedor(String nomeVendedor) {
        List<Venda> filtradas = new ArrayList<>();
        for (Venda v : listaVendas) {
            if (v.getVendedor().getNome().equalsIgnoreCase(nomeVendedor)) {
                filtradas.add(v);
            }
        }
        return filtradas;
    }

    public List<Venda> filtrarPorPeriodo(LocalDate inicio, LocalDate fim) {
        List<Venda> filtradas = new ArrayList<>();
        for (Venda v : listaVendas) {
            LocalDate dataVenda = v.getDataVenda().toLocalDate();
            if (!(dataVenda.isBefore(inicio) || dataVenda.isAfter(fim))) {
                filtradas.add(v);
            }
        }
        return filtradas;
    }

    // Cálculos para o REQ11
    public double[] calcularLucratividade() {
        double pecas = 0;
        double servicos = 0;
        for (OrdemServico os : listaOs) {
            for (Pecas p : os.getListaPecas()) pecas += p.custoPecas();
            for (MaoDeObra m : os.getListaServicos()) servicos += m.calcularCusto();
        }
        return new double[]{pecas, servicos};
    }

    public List<Venda> getListaVendas() { return new ArrayList<>(listaVendas); }
    public List<OrdemServico> getListaOs() { return new ArrayList<>(listaOs); }
}
