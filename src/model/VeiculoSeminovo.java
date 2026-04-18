package projeto1;

//classe filha de "Veiculo"
public class VeiculoSeminovo extends Veiculo {
	//atributos
	private double quilometragem;
  //não permitir cadastro de seminovos sem registro de quilometragem inicial [A] [!!]
	
	//construtor
	public VeiculoSeminovo(String chassi, String renavam, String modelo, int ano, double quilometragem) {
			super(chassi, renavam, modelo, ano);
			this.quilometragem = quilometragem;
	}

	//getters e setters
	public double getQuilometragem() {return quilometragem;}
	public void setQuilometragem(double quilometragem) {this.quilometragem = quilometragem;}
}
