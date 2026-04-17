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
	private StatusVeiculo status;
	
	//construtores
public Veiculo(String chassi, String renavam, String modelo, int ano, StatusVeiculo status) {
		this.chassi = chassi;
		this.renavam = renavam;
		this.modelo = modelo;
		this.ano = ano;
		this.status = status;
	}
public Veiculo(String chassi, String renavam, String modelo, int ano) {
	this.chassi = chassi;
	this.renavam = renavam;
	this.modelo = modelo;
	this.ano = ano;
	status = StatusVeiculo.ESTOQUE;
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

	public StatusVeiculo getStatus() {return status;}

	public void setStatus(StatusVeiculo status) {this.status = status;}

}
