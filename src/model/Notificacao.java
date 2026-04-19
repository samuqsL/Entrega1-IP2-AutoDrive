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

    // REQ10: revisão preventiva por km
    public boolean gerarAlerta() {
        return quilometragem >= 10000;
    }

    public void notificarCliente() {
        if (cliente == null || veiculo == null) {
        System.out.println("Erro: Falha ao enviar notificação. Dados incompletos.");
        return;
        }

        // Chamada do metodo "gerarAlerta()", e aplica validação (SE quilometragem >= 10000 retornar *False*, ENTAO encerra metodo [pois não precisa notificar!])
        if (!gerarAlerta()) {
            return;
        }
        
        System.out.println("ENVIANDO NOTIFICAÇÃO...");
        System.out.println("Para: " + cliente.getNome());
        System.out.println("Assunto: Revisão preventiva do seu veículo " + veiculo.getModelo());
        System.out.println("Data: " + this.data + " | KM: " + this.quilometragem);
        System.out.println("Mensagem: Seu veículo atingiu a quilometragem para revisão preventiva.");

    }
}
