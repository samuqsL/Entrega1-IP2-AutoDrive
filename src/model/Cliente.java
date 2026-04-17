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

  //getters (pegar valor)
  public void getNome() {return this.nome;}
  public void getCpf() {return this.cpf;}
  public void getCnh() {return this.cnh;}
  public void getEmail() {return this.email;}
  public void getTelefone() {return this.telefone;}
  //setters (alterar valor)
  public String setNome(String nome) {this.nome = nome;}
  public String setCpf(String cpf) {this.cpf = cpf;}
  public String setCnh(String cnh) {this.cnh = cnh;}
  public String setEmail(String email) {this.email = email;}
  public String setTelefone(String telefone) {this.telefone = telefone}

  // ------ //
  
  //Metodo 1 (atualizar informações do cliente, apenas atributos alteravéis)
  public void atualizarCadastro(String nome, String cnh, String email, String telefone){
    setNome(nome);
    setCnh(cnh);
    setEmail(email);
    setTelefone(telefone);
  }
}
