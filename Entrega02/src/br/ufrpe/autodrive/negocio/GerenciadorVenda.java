public class GerenciadorVenda implements IGerenciadorVenda {
    private IRepositorioVendas repoVendas; // O repositório único vindo do Main

    public GerenciadorVenda(IRepositorioVendas repo) {
        this.repoVendas = repo;
    }

    @Override
    public boolean efetuarVenda(Cliente c, Vendedor v, Veiculo veic, double entrada) {
        try {
            // 1. Tenta criar o objeto (valida entrada < 0 no setEntrada)
            Venda novaVenda = new Venda(c, v, veic, entrada);

            // 2. Executa a lógica de negócio (CNH, Status do Veículo, etc.)
            if (novaVenda.realizarVenda()) { 
                // 3. Se a regra de negócio permitiu, salva no "banco" (Array)
                this.repoVendas.adicionarVenda(novaVenda);
                return true; 
            }
        } catch (IllegalArgumentException e) {
            // Aqui capturamos o erro do construtor/setter (ex: entrada negativa)
            System.out.println("Erro de validação: " + e.getMessage());
        }
        return false; // Se chegou aqui, a venda falhou por algum motivo
    }
}
