package br.ufrpe.autodrive.dados;

import br.ufrpe.autodrive.negocio.beans.Venda;
import java.util.ArrayList;
import java.util.List;

public class RepositorioVendasArray implements IRepositorioVendas {
    private List<Venda> ListaDeVendas; // Nome exato do seu diagrama

    public RepositorioVendasArray() {
        this.ListaDeVendas = new ArrayList<>();
    }

    @Override
    public void adicionarVenda(Venda venda) {
        if (venda != null) {
            this.ListaDeVendas.add(venda);
        }
    }

    @Override
    public Venda procurarVenda(String cpf) {
        for (Venda v : ListaDeVendas) {
            if (v.getCliente().getCpf().equals(cpf)) {
                return v;
            }
        }
        return null;
    }

    @Override
    public void removerVenda() {
        // Implementação básica de limpeza ou remoção da última venda
        if (!ListaDeVendas.isEmpty()) {
            ListaDeVendas.remove(ListaDeVendas.size() - 1);
        }
    }

    @Override
    public List<Venda> listarTodasVendas() {
        return new ArrayList<>(ListaDeVendas);
    }
}
