package br.ufrpe.autodrive.gui;

import br.ufrpe.autodrive.negocio.IGerenciadorVenda;

public class MenuPrincipal {
    private IGerenciadorVenda gVenda; // Ele guarda a referência do cérebro do sistema

    public MenuPrincipal(IGerenciadorVenda gVenda) {
        this.gVenda = gVenda;
    }

    public void exibirMenu() {
        // Exemplo:
        System.out.println("1 - Realizar Venda");
        // ... lógica de ler opção do usuário ...
        
        if (opcao == 1) {
            // Cria a tela de venda passando o gerenciador que o menu já tem
            TelaVenda tela = new TelaVenda(this.gVenda);
            tela.executarBotaoVender();
        }
    }
}
