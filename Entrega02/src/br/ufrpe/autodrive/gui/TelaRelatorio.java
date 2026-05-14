package br.ufrpe.autodrive.gui;

import br.ufrpe.autodrive.negocio.IGerenciadorRelatorio;
import br.ufrpe.autodrive.negocio.beans.*;
import java.util.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class TelaRelatorio {
    private IGerenciadorRelatorio control;
    private DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public TelaRelatorio(IGerenciadorRelatorio control) {
        this.control = control;
    }

    public void exibir() {
        Scanner leitor = new Scanner(System.in);
        int op = -1;
        while (op != 0) {
            System.out.println("\n--- SISTEMA DE RELATÓRIOS ---");
            System.out.println("1. Relatório Geral de Vendas");
            System.out.println("2. Vendas por Vendedor");
            System.out.println("3. Vendas por Período");
            System.out.println("4. Relatório Geral de Oficina (OS)");
            System.out.println("5. Relatório de Lucratividade");
            System.out.println("0. Voltar");
            
            try {
                op = Integer.parseInt(leitor.nextLine());
                switch (op) {
                    case 1 -> imprimirVendas(control.gerarDadosRelatorio().getListaVendas(), "GERAL");
                    case 2 -> botaoVendasPorVendedor(leitor);
                    case 3 -> botaoVendasPorPeriodo(leitor);
                    case 4 -> imprimirOS(control.gerarDadosRelatorio().getListaOs());
                    case 5 -> botaoLucratividade();
                }
            } catch (Exception e) { System.out.println("Erro: Entrada inválida."); }
        }
    }

    private void botaoVendasPorVendedor(Scanner leitor) {
        System.out.print("Nome do Vendedor: ");
        String nome = leitor.nextLine();
        List<Venda> vds = control.gerarDadosRelatorio().filtrarPorVendedor(nome);
        imprimirVendas(vds, "VENDEDOR: " + nome);
    }

    private void botaoVendasPorPeriodo(Scanner leitor) {
        System.out.print("Data Início (dd/mm/aaaa): ");
        LocalDate ini = LocalDate.parse(leitor.nextLine(), fmt);
        System.out.print("Data Fim (dd/mm/aaaa): ");
        LocalDate fim = LocalDate.parse(leitor.nextLine(), fmt);
        List<Venda> vds = control.gerarDadosRelatorio().filtrarPorPeriodo(ini, fim);
        imprimirVendas(vds, "PERÍODO: " + ini + " a " + fim);
    }

    private void botaoLucratividade() {
        double[] lucros = control.gerarDadosRelatorio().calcularLucratividade();
        System.out.println("\n--- RELATÓRIO DE LUCRATIVIDADE ---");
        System.out.printf("Receita Peças: R$ %.2f\n", lucros[0]);
        System.out.printf("Receita Serviços: R$ %.2f\n", lucros[1]);
        System.out.printf("TOTAL: R$ %.2f\n", (lucros[0] + lucros[1]));
    }

    private void imprimirVendas(List<Venda> vendas, String titulo) {
        System.out.println("\n--- RELATÓRIO DE VENDAS (" + titulo + ") ---");
        for (Venda v : vendas) {
            System.out.println("Data: " + v.getDataVenda().format(fmt) + " | Valor: R$ " + v.getValorTotal());
        }
    }

    private void imprimirOS(List<OrdemServico> lista) {
        System.out.println("\n--- RELATÓRIO GERAL DE OFICINA ---");
        for (OrdemServico os : lista) {
            System.out.println("OS Nº: " + os.getNumero() + " | Status: " + os.getStatus());
        }
    }
}
