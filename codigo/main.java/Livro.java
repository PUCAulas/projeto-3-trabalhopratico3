package main.java;

//Classe para livros
public class Livro extends ItemBiblioteca {
    public Livro(String titulo, String autor, int anoPublicacao, boolean emprestavel, int quantidadeExemplares) {
        super(titulo, autor, anoPublicacao, emprestavel, quantidadeExemplares);
        this.emprestavel = emprestavel;
        this.quantidadeExemplares = quantidadeExemplares;
    }

    @Override
    public String getTipo() {
        return "Livro";
    }
    
    @Override
    public boolean isEmprestavel() {
        return emprestavel;
    }

    @Override
    public void setEmprestavel(boolean emprestavel) {
        this.emprestavel = emprestavel;
    }

    @Override
    public int getQuantidadeExemplares() {
        return quantidadeExemplares;
    }

    @Override
    public void setQuantidadeExemplares(int quantidadeExemplares) {
        this.quantidadeExemplares = quantidadeExemplares;
    }
    
    @Override
    public String toString() {
        return "Livro - " + super.toString() + ", Emprestável: " + emprestavel + ", Quantidade de Exemplares: " + quantidadeExemplares;
    }
}
