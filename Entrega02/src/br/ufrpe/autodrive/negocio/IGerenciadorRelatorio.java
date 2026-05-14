package br.ufrpe.autodrive.negocio;

import br.ufrpe.autodrive.negocio.beans.Relatorio;

public interface IGerenciadorRelatorio {
    /**
     * Captura os dados dos repositórios de Vendas e OS 
     * e os encapsula em um objeto Relatorio para processamento.
     */
    Relatorio gerarDadosRelatorio();
}
