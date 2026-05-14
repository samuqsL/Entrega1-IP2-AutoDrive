package br.ufrpe.autodrive.dados;

import br.ufrpe.autodrive.negocio.beans.Venda;
import java.util.List;

public interface IRepositorioVendas {
    void salvar(Venda v);
    List<Venda> listarTodasVendas();
    Venda buscarPorNumero(int numero);
    void removerVenda(int numero);    
}
