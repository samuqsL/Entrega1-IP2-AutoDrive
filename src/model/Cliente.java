package model

Public class Cliente {

  private String nome;
  private String cpf;
  private String cnh;
  private String email;
  private String telefone;

  //Construtor 1 (Principal)
  public Cliente (String nome, String cpf, String cnh, String email, String telefone){
    this.nome = nome;
    this.cpf = cpf;
    this.cnh = cnh;
    this.email = email;
    this.telefone = telefone;
  }
  //Construtor 2 (overloading[simplificando] --> direciona pro construtor principal)
   public Cliente (String nome, String cpf, String cnh){
     this(nome, cpf, cnh, null, null);
   }

  //getters
  public void getNome() {return this.nome}
  pu
  
}
