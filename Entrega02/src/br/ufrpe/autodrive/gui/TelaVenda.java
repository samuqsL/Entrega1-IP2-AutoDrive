public class TelaVenda {
    private IGerenciadorVenda control; // Interface, não a classe concreta!

    // A tela recebe o gerenciador pronto para manter os dados consistentes
    public TelaVenda(IGerenciadorVenda gVenda) {
        this.control = gVenda;
    }

    // Método que seria disparado pelo clique de um botão
    public void executarBotaoVender() {
        System.out.println("--- TELA DE VENDA ---");
        
        // Simulação: pegando dados que o usuário digitou
        // (Em um sistema real, viria de campos de texto do Swing/JavaFX)
        Cliente cli = ...; 
        Veiculo vei = ...;
        double valorEntrada = 10000.0;

        // A TELA SÓ CHAMA O GERENCIADOR
        boolean ok = control.efetuarVenda(cli, vendedorLogado, vei, valorEntrada);

        // A TELA DECIDE COMO FALAR COM O USUÁRIO
        if (ok) {
            System.out.println(">>> Parabéns! Venda registrada no sistema.");
        } else {
            System.out.println(">>> ERRO: A venda não pôde ser concluída. Verifique os requisitos.");
        }
    }
}
