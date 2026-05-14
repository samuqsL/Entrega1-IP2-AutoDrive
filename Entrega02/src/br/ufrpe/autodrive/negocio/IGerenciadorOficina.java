package br.ufrpe.autodrive.negocio;
import br.ufrpe.autodrive.negocio.beans.*;
import br.ufrpe.autodrive.negocio.beans.Cliente;
import br.ufrpe.autodrive.negocio.beans.MaoDeObra;
import br.ufrpe.autodrive.negocio.beans.Veiculo;
import br.ufrpe.autodrive.negocio.beans.Pecas;

public interface IGerenciadorOficina {
	
	//abrir OS
	boolean abrirOS(int numero, String dataAbertura, Cliente cliente, Veiculo veiculo);
    
    // Métodos extras exigidos pelo professor (não estão no diagrama, mas são obrigatórios)
    void registrarPecaNaOS(int numeroOS, Pecas peca, int quantidade);
    void registrarServicoNaOS(int numeroOS, MaoDeObra servico);

    boolean finalizarServico(int numeroOS);
	
}
