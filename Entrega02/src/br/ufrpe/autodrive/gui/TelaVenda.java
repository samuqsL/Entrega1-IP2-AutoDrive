package br.ufrpe.autodrive.gui;

import java.util.Scanner;
import br.ufrpe.autodrive.negocio.IGerenciadorVenda;

public class TelaVenda {
    private IGerenciadorVenda control; 

    public TelaVenda(IGerenciadorVenda gVenda) {
        this.control = gVenda;
    }

    //Método exibir() de todas as telas (Ex: com while - pode usar switch também)
    public void exibir() {
        Scanner leitor = new Scanner(System.in);
        int op = -1;

        while (op != 0) {
            System.out.println("\n--- MÓDULO DE VENDAS ---");
            System.out.println("1. Realizar Nova Venda");
            System.out.println("0. Voltar ao Menu");
            op = leitor.nextInt();

            if (op == 1) {
                this.BotaoRealizarVenda(); // Método do seu UML
            }
        }
    }

    public void BotaoRealizarVenda() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Iniciando venda...");
        
        // Simulação de entrada de dados
        System.out.print("Informe o valor da venda: ");
        double valor = sc.nextDouble();

        // 1. CHAMA O GERENCIADOR (Lógica) e 2. RECEBE O BOOLEAN
        boolean sucesso = control.efetuarVenda(valor); 

        // 3. DECIDE A MENSAGEM (Responsabilidade da Tela)
        if (sucesso) {
            System.out.println(">>> SUCESSO: Venda concluída com sucesso!");
        } else {
            System.out.println(">>> ERRO: Falha ao realizar venda (Verifique o valor).");
        }
    }
}
