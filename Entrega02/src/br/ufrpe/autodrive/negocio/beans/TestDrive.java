package br.ufrpe.autodrive.negocio.beans;

public class TestDrive {

    private Cliente cliente;
    private Veiculo veiculo;

    // Construtor default (sem valores - precisa settar atributos posteriormente!)
    public TestDrive() {}
    
    // Construtor
    public TestDrive(Cliente cliente, Veiculo veiculo) {
        this.cliente = cliente;
        this.veiculo = veiculo;
    }

    // AJUSTE: Passou a retornar boolean em vez de void (e sem System.out.println)
    public boolean agendar() {

        // Valida se a CNH do cliente é válida
        if (!cliente.validarCnhCliente()) {
            return false; 
        }

        // Valida se o veículo está disponível (não pode estar em manutenção)
        if (veiculo.getStatus() == StatusVeiculo.EM_MANUTENCAO) {
            return false; 
        }

        // Tudo certo, atualiza o status do veículo
        veiculo.setStatus(StatusVeiculo.TEST_DRIVE);

        return true; // Sucesso no agendamento
    }

    // Getters e Setters (adicionados para garantir o encapsulamento, caso precise acessar na tela)
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }
}
