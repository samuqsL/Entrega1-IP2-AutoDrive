package model;

public class Notificacao {
    private Cliente cliente;
    private Veiculo veiculo;

    public Notificacao(Cliente cliente, Veiculo veiculo) {
        this.cliente = cliente;
        this.veiculo = veiculo;
    }

    public boolean gerarAlerta() {
        return veiculo.getStatus() == StatusVeiculo.EM_MANUTENCAO;
    }

    public void notificarCliente() {
        System.out.println("Aviso: Olá " + cliente.getNome() + 
                           ", o status do seu veículo (" + veiculo.getModelo() + 
                           ") foi atualizado para: " + veiculo.getStatus());
    }
}
