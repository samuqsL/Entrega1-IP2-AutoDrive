package model;

import java.time.LocalDateTime;
  
public class Venda {
  //Atributos
  private Cliente cliente;
  private Vendedor vendedor;
  private Veiculo veiculo;
  private double valorTotal; // Atribuido aqui
  private LocalDateTime dataVenda;

  //Construtor Principal
  public Venda (Cliente cliente, Vendedor vendedor, Veiculo veiculo, LocalDateTime dataVenda){
    //valor total não é inicializado no construtor!
    this.cliente = cliente;
    this.vendedor = vendedor;
    this.veiculo = veiculo;
    this.dataVenda = dataVenda;
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

  //Metodo 1 (realizar venda de veiculo)
  public void realizaVenda(){
    this.valorTotal = veiculo.getpreco(); //inicializar valorTotal no metodo!
    //A fazer...
  }
  //Metodo 2 (Calcular Comissao)
  public double calcularComissao(){
    //A fazer...
  }
  public double calcularImposto(){
    //A fazer...
  }
}
