package br.ufrpe.autodrive.negocio;

import br.ufrpe.autodrive.dados.IRepositorioVendas;
import br.ufrpe.autodrive.dados.IRepositorioClientes;
import br.ufrpe.autodrive.negocio.beans.*;
import java.util.ArrayList;
import java.util.List;

public class GerenciadorVenda implements IGerenciadorVenda {
    private IRepositorioVendas repoV;
    private IRepositorioClientes repoC;

    public GerenciadorVenda(IRepositorioVendas repoV, IRepositorioClientes repoC) {
        this.repoV = repoV;
        this.repoC = repoC;
    }

    @Override
    public boolean efetuarVenda(String cpfCliente, double entrada) {
        // 1. Busca o cliente real pelo CPF
        Cliente c = repoC.procurarCliente(cpfCliente);
        
        // 2. Busca um veículo disponível (Simulação, já que não tem repo de Veículo)
        Veiculo veic = repoV.procurarVeiculoDisponivel(); 
    
        if (c != null && veic != null) {
            Vendedor v = new Vendedor("Samuel", 3000, 0.1); // Vendedor padrão
            Venda novaVenda = new Venda(c, v, veic, entrada);
    
            if (novaVenda.realizarVenda()) {
                this.repoV.adicionarVenda(novaVenda);
                return true;
            }
        }
        return false;
    }

    @Override
    public List<Notificacao> listarAlertasRevisao() {
        List<Notificacao> filtrados = new ArrayList<>();
        List<Venda> todasAsVendas = repoV.listarTodasVendas();

        for (Venda v : todasAsVendas) {
            // Cria a notificação com os dados da venda salva
            Notificacao n = new Notificacao(
                v.getVeiculo().getQuilometragem(),
                0,
                v.getDataVenda().toString(),
                v.calcularMesesUso(),
                v.getCliente(),
                v.getVeiculo()
            );

            if (n.gerarAlerta()) {
                filtrados.add(n);
            }
        }
        return filtrados;
    }

    // Métodos de repasse para o Repositório
    @Override
    public void adicionarVenda(Venda venda) {
        this.repoV.adicionarVenda(venda);
    }

    @Override
    public void procurarVenda(String cpf) {
        this.repoV.procurarVenda(cpf);
    }

    @Override
    public void removerVenda() {
        this.repoV.removerVenda();
    }
}
