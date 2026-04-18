//sinais de comunicação do meu codigo:
// [!] importante
// [!!] muito importante
// [!!!] urgente
// [?] duvida
// [A] aviso

package model;

//classe mae de "VeiculoNovo" e "VeiculoSeminovo"
public class Veiculo {
	//atributos
	private String chassi;
	private String renavam;
	private String modelo;
	private int ano;
	private double preco;
	private double quilometragem;
	private StatusVeiculo status;
	
	//construtores principal
	public Veiculo(String chassi, String renavam, String modelo, int ano, double preco, double quilometragem ,StatusVeiculo status) {
		this.chassi = chassi;
		this.renavam = renavam;
		this.modelo = modelo;
		this.ano = ano;
		this.preco = preco;
		this.quilometragem;
		this.status = status;
	}
	//construtor 2 (status padrão = ESTOQUE)
	public Veiculo(String chassi, String renavam, String modelo, int ano, double preco, double quilometragem) {
		this(chassi, renavam, modelo, ano, preco, quilometragem, statusVeiculo.Estoque);
		//esse construtor não tem "StatusVeiculo status" como parametro, pra deixar o status "ESTOQUE" como status padrão
}

    //getters e setters
	public String getChassi() {return chassi;}
	public void setChassi(String chassi) {this.chassi = chassi;}

	public String getRenavam() {return renavam;}
	public void setRenavam(String renavam) {this.renavam = renavam;}

	public String getModelo() {return modelo;}
	public void setModelo(String modelo) {this.modelo = modelo;}

	public int getAno() {return ano;}
	public void setAno(int ano) {this.ano = ano;}

	public double getPreco() {return preco;}
	public void setPreco(double preco) {this.preco = preco;}

	public double getQuilometragem() {return quilometragem;}
	public void setQuilometragem(double quilometragem) {this.quilometragem = quilometragem;}

	public StatusVeiculo getStatus() {return status;}
	public void setStatus(StatusVeiculo status) {this.status = status;}

}
