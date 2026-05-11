package br.ufrpe.autodrive.negocio;

import java.util.List;
import br.ufrpe.autodrive.negocio.beans.Venda;
import br.ufrpe.autodrive.negocio.beans.OrdemServico;
import br.ufrpe.autodrive.dados.IRepositorioVendas;
import br.ufrpe.autodrive.dados.IRepositorioOS;

public class GerenciadorRelatorio implements IGerenciadorRelatorio {
    private IRepositorioVendas repoVendas;
    private IRepositorioOS repoOS;

    public GerenciadorRelatorio(IRepositorioVendas repoVendas, IRepositorioOS repoOS) {
        this.repoVendas = repoVendas;
        this.repoOS = repoOS;
    }

    @Override
    public List<Venda> gerarRelatorioVendas() {
        // Retorna a lista pura vinda do repositório
        return repoVendas.listarTodos();
    }

    @Override
    public List<OrdemServico> gerarRelatorioOS() {
        return repoOS.listarTodas();
    }
}
