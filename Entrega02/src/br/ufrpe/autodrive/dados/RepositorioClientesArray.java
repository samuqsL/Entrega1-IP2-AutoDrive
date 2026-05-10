public class RepositorioClientesArray implements IRepositorioClientes {
    private ArrayList<Cliente> ListaDeClientes; // Nome exato do seu atributo

    public RepositorioClientesArray() {
        this.ListaDeClientes = new ArrayList<>();
    }

    @Override
    public void adicionarCliente(Cliente cliente) {
        if (cliente != null) {
            this.ListaDeClientes.add(cliente);
        }
    }

    @Override
    public Cliente procurarCliente(String cpf) {
        for (Cliente c : ListaDeClientes) {
            if (c.getCpf().equals(cpf)) {
                return c;
            }
        }
        return null;
    }

    @Override
    public void removerCliente(Cliente cliente) {
        this.ListaDeClientes.remove(cliente);
    }
}
