package model;

public class TestDrive {

  private Cliente cliente;
  private Veiculo veiculo;

  public void agendar() {

    if (!cliente.verificarCnhCliente()) {
      System.out.println("CNH inválida");
      return;
    }

    if (veiculo.getStatus() == Status.EM_MANUTENCAO) {
      System.out.println("Veículo indisponível");
      return;
    }

    veiculo.setStatus(Status.TEST_DRIVE);

    System.out.println("Test-drive agendado");
  }
}
