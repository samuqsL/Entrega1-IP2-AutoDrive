package br.ufrpe.autodrive.negocio;

import br.ufrpe.autodrive.dados.IRepositorioTD;
import br.ufrpe.autodrive.negocio.beans.Cliente;
import br.ufrpe.autodrive.negocio.beans.TestDrive;
import br.ufrpe.autodrive.negocio.beans.Veiculo;

public class GerenciadorTestDrive implements IGerenciadorTestDrive {
    
    private IRepositorioTD repoTD;

    public GerenciadorTestDrive(IRepositorioTD repoTD) {
        this.repoTD = repoTD;
    }

    @Override
    public boolean agendarTestDrive(Cliente cliente, Veiculo veiculo) {
        TestDrive novoTD = new TestDrive(cliente, veiculo);

        if (novoTD.agendar()) {
            this.repoTD.adicionarTestDrive(novoTD);
            return true;
        }
        return false;
    }
}
