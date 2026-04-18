package model;

import java.time.LocalDateTime;
  
public class Venda {
  //Atributos
  private Cliente cliente;
  private Vendedor vendedor;
  private Veiculo veiculo;
  private double valorTotal;
  private LocalDateTime dataVenda;

  private static final double TAXA_IMPOSTO = 0.10; //Variavel compartilhada por todas as classes (static) | variavel constate fixa (final)

  //Construtor Principal
  public Venda (Cliente cliente, Vendedor vendedor, Veiculo veiculo){
    //valor total não é inicializado no construtor!
    this.cliente = cliente;
    this.vendedor = vendedor;
    this.veiculo = veiculo;
  }

  //getters (pegar valor)
  public Cliente getCliente() {return this.cliente;}
  public Vendedor getVendedor() {return this.vendedor;}
  public Veiculo getVeiculo() {return this.veiculo;}
  public double getValorTotal() {return this.valorTotal;}
  public LocalDateTime getDataVenda() {return this.dataVenda;}
  //setters (alterar valor / validações)
  public void setCliente(Cliente cliente) {this.cliente = cliente;}
  public void setVendedor(Vendedor vendedor) {this.vendedor = vendedor;}
  public void setVeiculo(Veiculo veiculo) {this.veiculo = veiculo;}
  public void setValorTotal(double valorTotal) {this.valorTotal = valorTotal;}
  public void setDataVenda(LocalDateTime dataVenda) {this.dataVenda = dataVenda;}

  //Metodo 1 (realizar venda de veiculo) - [PRINCIPAL]
 public void realizarVenda() {

    if (!cliente.validarCnhCliente()) {
        System.out.println("Cliente sem CNH válida");
        return;
    }

    if (veiculo.getStatus() == Status.VENDIDO) {
        System.out.println("Veículo já vendido");
        return;
    }

    this.valorTotal = veiculo.getPreco();
    this.dataVenda = LocalDateTime.now();

    veiculo.setStatus(Status.VENDIDO);

    double imposto = calcularImposto();
    double comissao = calcularComissao();

    double comissao = calcularComissao();
    vendedor.setComissao(vendedor.getComissao() + comissao);

    System.out.println("Venda realizada");
    System.out.println("Imposto: " + imposto);
    System.out.println("Comissão: " + comissao);
}
  
  //Metodo 2 (Calcular Comissao)
  public double calcularComissao() {
    return this.valorTotal * vendedor.getPercentualComissao();
}
  //Metodo 3 (CalcularImposto)
  public double calcularImposto() {
    return this.valorTotal * TAXA_IMPOSTO;
  }
}
