package br.ufrpe.autodrive.negocio;

// IMPORTS NECESSÁRIOS para reconhecer as Beans e as Listas
import br.ufrpe.autodrive.negocio.beans.Venda;
import br.ufrpe.autodrive.negocio.beans.Notificacao;
import java.util.List;

public interface IGerenciadorVenda {

    // 1. Recebe String e double da Tela e retorna se deu certo
    boolean efetuarVenda(String cpfCliente, double entrada);

    // 2. Retorna a lista de notificações para a Tela
    List<Notificacao> listarAlertasRevisao();

    // 3. Retorna o objeto Venda completo (precisa do import da bean Venda)
    Venda procurarVenda(String cpf);

    // 4. Método de remoção simples
    void removerVenda();
}
