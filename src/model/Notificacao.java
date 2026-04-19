package model;

public class Notificacao {
    private double quilometragem;
    private int revisaoNumero;
    private String data;
    private Cliente cliente;
    private Veiculo veiculo;

    public Notificacao(double quilometragem, int revisaoNumero, String data, Cliente cliente, Veiculo veiculo) {
        this.quilometragem = quilometragem;
        this.revisaoNumero = revisaoNumero;
        this.data = data;
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
        if (cliente == null || veiculo == null) {
        System.out.println("Erro: Falha ao enviar notificação. Dados incompletos.");
        return;
        }
        
        System.out.println("ENVIANDO NOTIFICAÇÃO...");
        System.out.println("Para: " + cliente.getNome());
        System.out.println("Assunto: Status do seu veículo " + veiculo.getModelo());
        System.out.println("Data: " + this.data + " | KM: " + this.quilometragem);
        System.out.println("Mensagem: O status atual é: " + veiculo.getStatus());

        
        if (this.quilometragem % 10000 == 0 && this.quilometragem > 0) {
           System.out.println("ALERTA: Seu veículo atingiu um novo ciclo de 10.000km. Agende sua revisão!");
        }

    }
}
