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

package br.ufrpe.autodrive.gui;

import br.ufrpe.autodrive.negocio.IGerenciadorTestDrive;
import br.ufrpe.autodrive.negocio.beans.Cliente;
import br.ufrpe.autodrive.negocio.beans.Veiculo;
import java.util.Scanner;

public class TelaTestDrive {

    private IGerenciadorTestDrive control;

    public TelaTestDrive(IGerenciadorTestDrive control) {
        this.control = control;
    }

    public void exibir() {
        Scanner scanner = new Scanner(System.in);
        int opcao = -1;

        while (opcao != 0) {
            System.out.println("\n--- TELA DE TEST-DRIVE ---");
            System.out.println("1 - Agendar Test-Drive");
            System.out.println("0 - Sair (Voltar ao Menu Principal)");
            System.out.print("Escolha uma opção: ");

            try {
                opcao = Integer.parseInt(scanner.nextLine());

                switch (opcao) {
                    case 1:
                        BotaoAgendarTestDrive(scanner);
                        break;
                    case 0:
                        System.out.println("Retornando ao Menu Principal...");
                        break;
                    default:
                        System.out.println("Opção inválida! Escolha 1 ou 0.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida! Por favor, digite um número.");
            }
        }
    }

    private void BotaoAgendarTestDrive(Scanner scanner) {
        System.out.println("\n--- AGENDAR TEST-DRIVE ---");

        System.out.print("Digite o CPF do Cliente: ");
        String cpf = scanner.nextLine();

        System.out.print("Digite o Chassi do Veículo: ");
        String chassi = scanner.nextLine();

        Cliente clienteSelecionado = new Cliente(); 
        Veiculo veiculoSelecionado = null; 

        boolean sucesso = this.control.agendarTestDrive(clienteSelecionado, veiculoSelecionado);

        if (sucesso) {
            System.out.println("Sucesso: Test-drive agendado com sucesso!");
        } else {
            System.out.println("Erro: Não foi possível agendar o test-drive. Verifique se o cliente possui CNH válida e se o veículo está disponível.");
        }
    }
}
