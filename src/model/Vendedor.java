package model

public class Vendedor {

  private String nome;
  private double comissao;

  //construtor principal da classe!
  public Vendedor(String nome, double comissao){
    this.nome = nome;
    this.comissao = comissao;
  }

  //getters (pegar valor)
  public void getNome() {return this.nome;}
  public void getComissao() {return this.comissao;}
  //setters
  public String setNome(String nome) {this.nome = nome;}
  public double setComissao(double comissao) {this.comissao = comissao;}

  //Metodos (...)
}
