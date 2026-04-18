package model;

import java.util.LocalDateTime;
  
public class Venda {
  //Atributos
  private Cliente cliente;
  private Vendedor vendedor;
  private Veiculo veiculo;
  private double valorTotal;
  private LocalDateTime dataVenda;

  //Construtor Principal
  public Venda (Cliente cliente, Vendedor vendedor, Veiculo veiculo, double valorTotal, LocalDateTime dataVenda){
    this.cliente = cliente;
    this.vendedor = vendedor;
    this.veiculo = veiculo;
    this.valorTotal = valorTotal;
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

  public 
  
}
