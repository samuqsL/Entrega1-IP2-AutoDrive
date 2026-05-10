package br.ufrpe.autodrive.negocio;

import br.ufrpe.autodrive.dados.IRepositorioVendas;
import br.ufrpe.autodrive.dados.IRepositorioClientes;
import br.ufrpe.autodrive.negocio.beans.*;
import java.util.ArrayList;
import java.util.List;

public class GerenciadorVenda implements IGerenciadorVenda {
    private IRepositorioVendas repoV;
    private IRepositorioClientes repoC; // Agora ele tem acesso aos clientes também

    public GerenciadorVenda(IRepositorioVendas repoV, IRepositorioClientes repoC) {
        this.repoV = repoV;
        this.repoC = repoC;
    }

    @Override
    public boolean efetuarVenda(String cpfCliente, double entrada) {
        Cliente c = repoC.procurarCliente(cpfCliente);
        
        // Se Veiculo for abstrato, você instancia uma classe FILHA:
        // Supondo que você criou uma classe simples chamada 'Carro' que estende Veiculo
        Veiculo veic = new Carro("Modelo Teste", "ABC-1234", 100000.0, 0);
        veic.setStatus(StatusVeiculo.DISPONIVEL);
        
        Vendedor v = new Vendedor("Samuel", 3000, 0.1); 
    
        if (c != null) {
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
        List<Venda> todasAsVendas = repoV.listarTodasVendas(); // Busca tudo o que foi salvo

        for (Venda v : todasAsVendas) {
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

    // Métodos de repasse (O Gerenciador expõe o que o repositório faz)
    @Override
    public Venda procurarVenda(String cpf) {
        return this.repoV.procurarVenda(cpf);
    }

    @Override
    public void removerVenda() {
        this.repoV.removerVenda();
    }
}
