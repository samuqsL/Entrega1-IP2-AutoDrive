//problema na linha 55, mas não sei qual é o problema
package br.ufrpe.autodrive.gui;
import java.util.Scanner;
import br.ufrpe.autodrive.negocio.IGerenciadorOficina;
import br.ufrpe.autodrive.negocio.beans.Cliente;

/**
 * ORIENTAÇÃO DE IMPLEMENTAÇÃO (PADRÃO GUI):
 * * 1. MÉTODO exibir(): Deve conter um loop (while) que mantém a tela ativa 
 * até que o usuário digite '0'. Use um switch/case para ler as opções.
 
 * * 2. LÓGICA DE NAVEGAÇÃO: Ao escolher '0', o loop deve encerrar. Isso fará 
 * com que o método termine e o controle retorne automaticamente para o MenuPrincipal.
 
 * * 3. MÉTODOS "BOTAO": As opções do switch devem chamar os métodos específicos 
 * da classe (ex: BotaoRealizarVenda).
 
 * * 4. FLUXO DE DADOS: O método da tela lê os dados (Scanner) -> Chama o Gerenciador 
 * (Control) -> Recebe um boolean -> A tela decide qual mensagem exibir (if/else).
 * * NOTA: Nenhuma lógica de negócio ou print deve existir fora das classes GUI.
 */

public class TelaOficina {
	
	private IGerenciadorOficina control;

  //exibir() é Metodo pra todas as classes! (painelzinho com opções(1, 2, ..., 0[sair]) 
  // que chamam metodos especificos das classes do IGerenciciadorX especifico!
  //Fiz um na classe "TelaVenda" --- se quiserem uma referência.
  public void exibir(){
	  Scanner leitor = new Scanner(System.in);
	  int op = -1;
			  
	  while(op != 0) {
		  
		  System.out.println("--------------------------");
		  System.out.println("  VOCE ENTROU NA OFICINA  ");
		  System.out.println("--------------------------");
		  System.out.println("   SELECIONE UMA OPÇÃO    ");
		  System.out.println("--------------------------");
		  System.out.println("1. Abrir Ordem de Serviço");
		  System.out.println("2. Registrar itens da Ordem de Serviço");
		  System.out.println("0. voltar ao Menu principal");
		  
		  switch(op) {
		  
		  case(1)://abrir ordem de serviço
			  System.out.println("Digite o número da nova Ordem de Serviço:");
		    int numero = leitor.nextInt();
		    leitor.nextLine(); // Limpar o buffer
		    
		    System.out.println("Digite a data (dd/mm/aaaa):");
		    String data = leitor.nextLine();
		    
		    control.abrirOS(numero, data, cliente, veiculo);
			  break;
		  case(2):
			  System.out.println("Digite o número da Ordem de serviço que deseja editar:");
		    int numOS = leitor.nextInt();
			  break;
		  case(0):
			  System.out.println("voltando ao Menu Principal...");
			  break;
		  }
		  
	  }
	  
  }
  
  public void BotaoFinalizarOS() {};
  
}
