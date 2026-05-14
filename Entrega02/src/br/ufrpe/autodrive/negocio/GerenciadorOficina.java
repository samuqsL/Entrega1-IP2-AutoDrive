package br.ufrpe.autodrive.negocio;
import br.ufrpe.autodrive.dados.IRepositorioOS;
// imports do beans!
import br.ufrpe.autodrive.negocio.beans.*;
import br.ufrpe.autodrive.negocio.beans.Cliente;
import br.ufrpe.autodrive.negocio.beans.MaoDeObra;
import br.ufrpe.autodrive.negocio.beans.OrdemServico;
import br.ufrpe.autodrive.negocio.beans.Pecas;
import br.ufrpe.autodrive.negocio.beans.Veiculo;

//colocar os imports que estão precisando [!!!]

public class GerenciadorOficina implements IGerenciadorOficina {

	private IRepositorioOS repoOS;
	
    // Construtor para receber o repositório
    public GerenciadorOficina(IRepositorioOS repo) {
        this.repoOS = repo;
    }

    @Override
    public boolean AbrirOS(int numero, String dataAbertura, Cliente cliente, Veiculo veiculo) {
        // Se a OS já existe no repositório (banco de dados/array), não deixa abrir outra igual
        if (repoOS.buscarPorNumero(numero) != null) {
        	return false;
        }
    	
    	OrdemServico novaOS = new OrdemServico(numero, dataAbertura, cliente, veiculo);
    	repoOS.salvar(novaOS);
        return true;
    }

    @Override
    public void registrarPecaNaOS(int numeroOS, Pecas peca, int quantidade) {
        // 1. Busca a OS no repositório pelo número
        OrdemServico os = repoOS.buscarPorNumero(numeroOS); 
        
        if (os != null) {
            // 2. Adiciona a peça. O método dentro de OrdemServico já vai 
            // checar a composição e retirar do estoque!
            os.adicionarPeca(peca, quantidade);
            System.out.println("Peça registrada na OS.");
        } else {
            System.out.println("OS não encontrada!");
        }
    }

    @Override
    public void registrarServicoNaOS(int numeroOS, MaoDeObra servico) {
        OrdemServico os = repoOS.buscarPorNumero(numeroOS);
        if (os != null) {
            os.adicionarServico(servico);
            System.out.println("Serviço registrado na OS.");
        } else {
            System.out.println("OS não encontrada!");
        }
    }
    
    @Override
    public boolean finalizarServico(int numeroOS) {
OrdemServico os = repoOS.buscarPorNumero(numeroOS);
        
        if (os != null) {
            // No código que você mandou, o finalizarOS() é void e tem prints dentro dele. 
            // O ideal seria que ele também retornasse boolean! Mas vamos assumir a lógica aqui:
            if (os.getStatus() == StatusOS.PAGA) { 
                os.finalizarOS();
                return true; // Finalizou com sucesso
            }
        }
        return false; // Falhou (não achou a OS ou não estava paga)
    }
}
