package br.ufrpe.autodrive.gui;

import java.util.Scanner;
import java.util.List;
import br.ufrpe.autodrive.negocio.IGerenciadorRelatorio;
import br.ufrpe.autodrive.negocio.beans.Venda;
import br.ufrpe.autodrive.negocio.beans.OrdemServico;
import br.ufrpe.autodrive.negocio.beans.Pecas;
import br.ufrpe.autodrive.negocio.beans.MaoDeObra;

public class TelaRelatorio {
    private IGerenciadorRelatorio control;

    public TelaRelatorio(IGerenciadorRelatorio control) {
        this.control = control;
    }

    public void exibir() {
        Scanner leitor = new Scanner(System.in);
        int op = -1;
        while (op != 0) {
            System.out.println("\n--- SISTEMA DE RELATÓRIOS ---");
            System.out.println("1. Relatório Geral");
            System.out.println("2. Vendas por Vendedor");
            System.out.println("3. Vendas por Período");
            System.out.println("4. Relatório Geral de Oficina (OS)");
            System.out.println("5. Relatório de Lucratividade");
            System.out.println("0. Voltar");

            // Tratamento simples para evitar erro se não for número
            if (leitor.hasNextInt()) {
                op = leitor.nextInt();
            } else {
                leitor.next(); // limpa a entrada inválida
                continue;
            }

            if (op == 1) this.botaoRelatorioVendas();
            if (op == 2) this.botaoVendasPorVendedor(leitor);
            if (op == 3) this.botaoVendasPorPeriodo(leitor);
            if (op == 4) this.botaoRelatorioOS();
            if (op == 5) this.botaoLucratividadeOficina();
        }
    }

    public void botaoRelatorioVendas() {
        List<Venda> vendas = control.gerarRelatorioVendas();
        System.out.println("\n--- Relatório Geral de Vendas ---");
        if (vendas == null || vendas.isEmpty()) {
            System.out.println("Não há venda cadastrada.");
        } else {
            for (Venda v : vendas) {
                System.out.println("Venda: R$ " + v.getValorTotal() + " | Data: " + v.getDataVenda());
            }
        }
    }

    public void botaoVendasPorVendedor(Scanner leitor) {
        System.out.print("Digite o nome do vendedor: ");
        String nome = leitor.nextLine();
        List<Venda> vendas = control.gerarRelatorioVendas();

        System.out.println("\n--- Vendas do Vendedor: " + nome + " ---");
        boolean encontrou = false;
        if (vendas != null) {
            for (Venda v : vendas) {
                if (v.getVendedor() != null && v.getVendedor().getNome().equalsIgnoreCase(nome)) {
                    System.out.println("Data: " + v.getDataVenda() + " | Valor: R$ " + v.getValorTotal());
                    encontrou = true;
                }
            }
        }
        if (!encontrou) System.out.println("Venda não localizada.");
    }

    public void botaoVendasPorPeriodo(Scanner leitor) {
        System.out.print("Digite a data inicial: ");
        String inicio = leitor.nextLine();
        System.out.print("Digite a data final: ");
        String fim = leitor.nextLine();
        
        System.out.println("\n--- Filtragem por Período (" + inicio + " a " + fim + ") ---");
        System.out.println("Funcionalidade delegada ao processamento de negócio.");
    }

    public void botaoRelatorioOS() {
        List<OrdemServico> ordens = control.gerarRelatorioOS();
        System.out.println("\n--- Relatório Geral da Oficina ---");
        if (ordens == null || ordens.isEmpty()) {
            System.out.println("Nenhuma Ordem de Serviço encontrada.");
        } else {
            for (OrdemServico os : ordens) {
                System.out.println("OS Nº: " + os.getNumero() + " | Status: " + os.getStatus());
            }
        }
    }

    public void botaoLucratividadeOficina() {
        List<OrdemServico> ordens = control.gerarRelatorioOS();
        double lucroPecas = 0;
        double totalServicos = 0;

        if (ordens != null) {
            for (OrdemServico os : ordens) {
                if (os.getListaPecas() != null) {
                    for (Pecas p : os.getListaPecas()) {
                        lucroPecas += p.custoPecas();
                    }
                }
                if (os.getListaServicos() != null) {
                    for (MaoDeObra m : os.getListaServicos()) {
                        totalServicos += m.calcularCusto();
                    }
                }
            }
        }

        System.out.println("\n--- RELATÓRIO DE LUCRATIVIDADE DA OFICINA ---");
        System.out.println("Receita com Peças: R$ " + String.format("%.2f", lucroPecas));
        System.out.println("Receita com Serviços: R$ " + String.format("%.2f", totalServicos));
        System.out.println("Total da Oficina: R$ " + String.format("%.2f", (lucroPecas + totalServicos)));
        System.out.println("----------------------------------------------");
    }
}
