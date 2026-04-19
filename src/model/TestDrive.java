package model;

public class TestDrive {

  private Cliente cliente;
  private Veiculo veiculo;

  public void agendar() {

    if (!cliente.validarCnhCliente()) {
      System.out.println("CNH inválida");
      return; //encerrar metodo antes da hora, para impedir agendamento (SE CNH é INVÁLIDO)
    }

    if (veiculo.getStatus() == Status.EM_MANUTENCAO) {
      System.out.println("Veículo indisponível");
      return; //encerrar metodo antes da hora, para impedir agendamento (SE StatusVeiculo == EM_MANUTENCAO)
    }

    veiculo.setStatus(Status.TEST_DRIVE);

    System.out.println("Test-drive agendado");
  }
}
