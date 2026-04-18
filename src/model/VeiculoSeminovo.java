package model;

//classe filha de "Veiculo"
public class VeiculoSeminovo extends Veiculo {
	//atributos [são herdados da classe Veiculo]!
	
	//construtor principal
	public VeiculoSeminovo(String chassi, String renavam, String modelo, int ano, double preco, StatusVeiculo status, double quilometragem) {
		super(chassi, renavam, modelo, ano, preco, status.ESTOQUE);
		if (quilometragem <= 0) {
            throw new IllegalArgumentException("Seminovo precisa de quilometragem inicial");
        }
		setQuilometragem(quilometragem)
	}
}
