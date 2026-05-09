package br.ufrpe.autodrive.gui;

import br.ufrpe.autodrive.negocio.*; // Importa as Interfaces

public class MenuPrincipal {
    // O Menu guarda os gerenciadores que recebeu do Main
    private IGerenciadorVenda gVenda;
    private IGerenciadorOficina gOficina;
    private IGerenciadorRelatorio gRelatorio;
    // ... outros gerenciadores

    public MenuPrincipal(IGerenciadorVenda gV, IGerenciadorOficina gO, IGerenciadorRelatorio gR) {
        this.gVenda = gV;
        this.gOficina = gO;
        this.gRelatorio = gR;
    }

    public void exibirMenu() {
        // Loop com switch/case para o usuário escolher a opção
        // Se o usuário escolher '1' (Vendas):
        this.abrirTelaVenda();
    }

    // Métodos baseados no seu UML (image_81c45f.png)
    public void abrirTelaVenda() {
        // Cria a tela e passa o gerenciador específico para ela
        TelaVenda telaV = new TelaVenda(this.gVenda);
        telaV.exibir(); // Método na TelaVenda que inicia a interação
    }

    public void abrirTelaOficina() {
        TelaOficina telaO = new TelaOficina(this.gOficina);
        telaO.exibir();
    }

    public void abrirTelaRelatorio() {
        TelaRelatorio telaR = new TelaRelatorio(this.gRelatorio);
        telaR.exibir();
    }
}
