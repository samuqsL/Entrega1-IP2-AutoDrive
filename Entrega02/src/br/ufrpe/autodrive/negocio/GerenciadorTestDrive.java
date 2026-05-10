package br.ufrpe.autodrive.negocio;

import br.ufrpe.autodrive.dados.IRepositorioTD;
import br.ufrpe.autodrive.negocio.beans.Cliente;
import br.ufrpe.autodrive.negocio.beans.TestDrive;
import br.ufrpe.autodrive.negocio.beans.Veiculo;

public class GerenciadorTestDrive {
    
    private IRepositorioTD repoTD;
    private TestDrive testDriveAtual; 

    public GerenciadorTestDrive(IRepositorioTD repoTD) {
        this.repoTD = repoTD;
    }

    public boolean agendarTestDrive(Cliente cliente, Veiculo veiculo) {
        this.testDriveAtual = new TestDrive(cliente, veiculo);

        if (this.testDriveAtual.agendar()) {
            this.repoTD.adicionarTestDrive(this.testDriveAtual);
            return true;
        }
        
        return false;
    }

    public void adicionarTestDrive(TestDrive td) {
        this.repoTD.adicionarTestDrive(td);
    }
}
