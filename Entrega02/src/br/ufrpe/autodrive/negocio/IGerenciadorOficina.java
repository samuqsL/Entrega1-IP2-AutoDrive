package br.ufrpe.autodrive.negocio;
import br.ufrpe.autodrive.negocio.beans.Cliente;
import br.ufrpe.autodrive.negocio.beans.MaoDeObra;
import br.ufrpe.autodrive.negocio.beans.Veiculo;
import br.ufrpe.autodrive.negocio.beans.Pecas;

public interface IGerenciadorOficina {
	
	//abrir OS
	void abrirOS(int numero, String dataAbertura, Cliente cliente, Veiculo veiculo);
    
    // Registrar peças (composição e estoque) e serviços
    void registrarPecaNaOS(int numeroOS, Pecas peca, int quantidade);
    void registrarServicoNaOS(int numeroOS, MaoDeObra servico);

    void finalizarServico(int numeroOS);
	
}
