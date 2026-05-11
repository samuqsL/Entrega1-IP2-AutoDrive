package br.ufrpe.autodrive.gui;

import java.util.Scanner;
import java.util.List;
import br.ufrpe.autodrive.negocio.IGerenciadorVenda;
import br.ufrpe.autodrive.negocio.beans.Notificacao;

public class TelaVenda {
    private IGerenciadorVenda control; 

    public TelaVenda(IGerenciadorVenda gVenda) {
        this.control = gVenda;
    }

    public void exibir() {
        Scanner leitor = new Scanner(System.in);
        int op = -1;

        while (op != 0) {
            System.out.println("\n--- TELA DE VENDAS ---");
            System.out.println("1. Realizar Nova Venda");
            System.out.println("2. Verificar Necessidade de Reparo (Alertas)");
            System.out.println("0. Voltar ao Menu");
            
            // Tratamento simples para evitar erro se não for número
            if (leitor.hasNextInt()) {
                op = leitor.nextInt();
            } else {
                leitor.next(); // limpa a entrada inválida
                continue;
            }

            if (op == 1) this.BotaoRealizarVenda();
            if (op == 2) this.BotaoVerificarAlertas();
        }
        leitor.close();
    }

    public void BotaoRealizarVenda() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n--- INICIANDO VENDA ---");
    
        System.out.print("CPF do Cliente: ");
        String cpfCliente = sc.nextLine();
    
        System.out.print("Valor da Entrada: ");
        double entrada = sc.nextDouble();
    
        // O controlador faz a ponte com o repositório de clientes
        boolean sucesso = control.efetuarVenda(cpfCliente, entrada); 
    
        if (sucesso) {
            System.out.println(">>> SUCESSO: Venda concluída com sucesso!");
        } else {
            System.out.println(">>> ERRO: Falha ao realizar venda (Cliente não encontrado ou dados inválidos).");
        }
        sc.close();
    }

    public void BotaoVerificarAlertas() {
        System.out.println("\n--- BUSCANDO ALERTAS DE REVISÃO NO SISTEMA ---");
        List<Notificacao> alertas = control.listarAlertasRevisao(); 
    
        if (alertas.isEmpty()) {
            System.out.println("Nenhum veículo precisa de revisão no momento.");
        } else {
            for (Notificacao n : alertas) {
                // A tela formata a saída para o usuário
                System.out.println("[ALERTA] Cliente: " + n.getCliente().getNome() + 
                                   " | Veículo: " + n.getVeiculo().getModelo() + 
                                   " | KM: " + n.getQuilometragem());
            }
        }
    }
}
