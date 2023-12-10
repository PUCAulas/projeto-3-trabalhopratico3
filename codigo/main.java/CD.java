package main.java;

import java.util.HashSet;
import java.util.Set;

//Classe para CDs
public class CD extends ItemBiblioteca implements Emprestavel {
    public CD(String titulo, String autor, int anoPublicacao, boolean emprestavel, int quantidadeExemplares) {
        super(titulo, autor, anoPublicacao, emprestavel, quantidadeExemplares);
        this.emprestavel = emprestavel;
        this.quantidadeExemplares = quantidadeExemplares;
    }

    @Override
    public String getTipo() {
        return "CD";
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
        return "CD - " + super.toString() + ", Emprestável: " + emprestavel + ", Quantidade de Exemplares: " + quantidadeExemplares;
    }
    
    @Override
	public void emprestar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean podeSerEmprestado() {
		// TODO Auto-generated method stub
		return false;
	}
	
	// Implementação do método abstrato getCategorias para CD
    @Override
    public Set<String> getCategorias() {
        // Lógica para obter categorias específicas de CD
        Set<String> categorias = new HashSet<>();
        categorias.add("Música"); //
        return categorias;
    }
}
