package main.java;

//Classe para revistas
public class Revista extends ItemBiblioteca {
    public Revista(String titulo, String autor, int anoPublicacao, boolean emprestavel, int quantidadeExemplares) {
        super(titulo, autor, anoPublicacao, emprestavel, quantidadeExemplares);
        this.emprestavel = emprestavel;
        this.quantidadeExemplares = quantidadeExemplares;
    }

    @Override
    public String getTipo() {
        return "Revista";
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
        return "Revista - " + super.toString() + ", Emprestável: " + emprestavel + ", Quantidade de Exemplares: " + quantidadeExemplares;
    }
}