package model;

public class Notificacao {
    private double quilometragem;
    private String data;
    private int mesesUso;
    private Cliente cliente;
    private Veiculo veiculo;

    public Notificacao(double quilometragem, String data, int mesesUso, Cliente cliente, Veiculo veiculo) {
        this.quilometragem = quilometragem;
        this.data = data;
        this.mesesUso = mesesUso;
        this.cliente = cliente;
        this.veiculo = veiculo;
    }

    // REQ10: revisão preventiva por tempo/km
    public boolean gerarAlerta() {
        return quilometragem >= 10000 || mesesUso >= 12;
    }

    public void notificarCliente() {
        if (cliente == null || veiculo == null) {
        System.out.println("Erro: Falha ao enviar notificação. Dados incompletos.");
        return;
        }

        // Se não houver necessidade de revisão, encerra o método
        if (!gerarAlerta()) {
            return;
        }
        
        System.out.println("ENVIANDO NOTIFICAÇÃO...");
        System.out.println("Cliente: " + cliente.getNome());
        System.out.println("Veículo: " + veiculo.getModelo());
        System.out.println("Data: " + data);
        System.out.println("KM atual: " + quilometragem);
        System.out.println("Mensagem: Revisão preventiva necessária.");

    }
}
