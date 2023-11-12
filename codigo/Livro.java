package biblioteca;

public class Livro extends ItemBiblioteca implements Emprestavel {
    public Livro(String titulo, String autor, int ano, int quantidade) {
        super(titulo, autor, ano, quantidade);
    }

    @Override
    public boolean verificarDisponibilidade() {
        return getQuantidade() > 0;
    }

    @Override
    public void emprestar() {
        if (verificarDisponibilidade()) {
            setQuantidade(getQuantidade() - 1);
        }
    }
}
