package model;

public class Vendedor {

  private String nome;
  private double comissao;

  //construtor principal da classe!
  public Vendedor(String nome, double comissao){
    this.nome = nome;
    this.comissao = comissao;
  }

  //getters (pegar valor)
  public String getNome() {return this.nome;}
  public double getComissao() {return this.comissao;}
  //setters
  public void setNome(String nome) {this.nome = nome;}
  public void setComissao(double comissao) {this.comissao = comissao;}

  //Metodos (...)
}
