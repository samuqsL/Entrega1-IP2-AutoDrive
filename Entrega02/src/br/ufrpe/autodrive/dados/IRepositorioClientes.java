package br.ufrpe.autodrive.dados;

import br.ufrpe.autodrive.negocio.beans.Cliente;

public interface IRepositorioClientes {
    void adicionarCliente(Cliente cliente);
    Cliente procurarCliente(String cpf); // Mudei para retornar Cliente para o Gerenciador usar
    void removerCliente(Cliente cliente);
}
