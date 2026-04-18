package model;

import java.time.LocalDateTime;
  
public class Venda {
  //Atributos
  private Cliente cliente;
  private Vendedor vendedor;
  private Veiculo veiculo;
  private double valorTotal;
  private LocalDateTime dataVenda;

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

    if (veiculo.getStatus() == Status.RESERVADO) {
        System.out.println("Veículo reservado");
        return;
    }

    this.valorTotal = veiculo.getPreco(); //inicializar o valorTotal" quando realizaVenda()!
    this.dataVenda = LocalDateTime.now();
    
    veiculo.setStatus(Status.VENDIDO);
   
    double imposto = calcularImposto();
    double comissao = calcularComissao();

    System.out.println("Venda realizada");
    System.out.println("Imposto: " + imposto);
    System.out.println("Comissão: " + comissao);
}
  //Metodo 2 (Calcular Comissao)
  public double calcularComissao(){
    //A fazer...
  }
  public double calcularImposto(){
    //A fazer...
  }
}
