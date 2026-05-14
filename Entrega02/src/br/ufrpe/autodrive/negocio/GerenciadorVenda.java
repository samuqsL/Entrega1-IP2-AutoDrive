package br.ufrpe.autodrive.negocio;

import br.ufrpe.autodrive.dados.*;
import br.ufrpe.autodrive.negocio.beans.*;
import java.util.ArrayList;
import java.util.List;

public class GerenciadorVenda implements IGerenciadorVenda {
    // --- 1. ATRIBUTOS (Agora com todos os repositórios necessários) ---
    private IRepositorioVendas repoV;
    private IRepositorioClientes repoC;
    private IRepositorioVendedores repoVend;
    private IRepositorioVeiculos repoVeic;

    // --- 2. CONSTRUTOR (Recebendo as novas dependências) ---
    public GerenciadorVenda(IRepositorioVendas repoV, IRepositorioClientes repoC, 
                            IRepositorioVendedores repoVend, IRepositorioVeiculos repoVeic) {
        this.repoV = repoV;
        this.repoC = repoC;
        this.repoVend = repoVend;
        this.repoVeic = repoVeic;
    }

    // --- 3. EFETUAR VENDA (Agora 100% dinâmico) ---
    @Override
    public boolean efetuarVenda(String cpfCliente, String chassi, String nomeVendedor, double entrada) {
        // Busca os objetos reais nos repositórios em vez de instanciar fixo
        Cliente c = repoC.procurarCliente(cpfCliente);
        Vendedor v = repoVend.procurarVendedor(nomeVendedor);
        Veiculo veic = repoVeic.procurarVeiculo(chassi);

        // Validação: Todos os envolvidos precisam existir e o carro deve estar disponível
        if (c != null && v != null && veic != null) {
            if (veic.getStatus() == StatusVeiculo.DISPONIVEL) {
                
                Venda novaVenda = new Venda(c, v, veic, entrada);
                
                // O realizarVenda() processa comissão e data
                if (novaVenda.realizarVenda()) {
                    this.repoV.adicionarVenda(novaVenda);
                    return true;
                }
            }
        }
        return false;
    }
    
    // --- OS DEMAIS PERMANECEM IGUAIS (Apenas verifique os nomes dos métodos no repoV) ---
    
    @Override
    public List<Notificacao> listarAlertasRevisao() {
        List<Notificacao> filtrados = new ArrayList<>();
        // Verifique se no seu IRepositorioVendas o nome é listarTodasVendas() ou listarVendas()
        List<Venda> todasAsVendas = repoV.listarTodasVendas(); 

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

    @Override
    public Venda procurarVenda(String cpf) {
        return this.repoV.procurarVenda(cpf);
    }

    @Override
    public void removerVenda() {
        this.repoV.removerVenda();
    }
}
