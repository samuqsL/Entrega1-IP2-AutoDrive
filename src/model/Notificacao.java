package model;

public class Notificacao {
    private Cliente cliente;
    private Veiculo veiculo;

    public Notificacao(Cliente cliente, Veiculo veiculo) {
        this.cliente = cliente;
        this.veiculo = veiculo;
    }

    public boolean gerarAlerta() {
        if (veiculo.getStatus() == StatusVeiculo.EM_MANUTENCAO) {
            return true;
        }
        return false;
    }

    public void notificarCliente() {
        System.out.println("ENVIANDO NOTIFICAÇÃO...");
        System.out.println("Para: " + cliente.getNome());
        System.out.println("Assunto: Status do seu veículo " + veiculo.getModelo());
        System.out.println("Mensagem: O status atual é: " + veiculo.getStatus());
    }
}
