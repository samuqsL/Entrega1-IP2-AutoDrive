public class Mecanico {
    private String nome;
    private double bonus;
    private boolean disponivel;

    public Mecanico(String nome, double bonus, boolean disponivel) {
        this.nome = nome;
        this.bonus = bonus;
        this.disponivel = disponivel;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }
}
