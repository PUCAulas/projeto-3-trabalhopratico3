package main.java;

import java.util.HashSet;
import java.util.Set;

//Classe para teses
public class Tese extends ItemBiblioteca {
    public Tese(String titulo, String autor, int anoPublicacao, boolean emprestavel, int quantidadeExemplares) {
        super(titulo, autor, anoPublicacao, emprestavel, quantidadeExemplares);
        this.emprestavel = emprestavel;
        this.quantidadeExemplares = quantidadeExemplares;
    }

    @Override
    public String getTipo() {
        return "Tese";
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
        return "Tese - " + super.toString() + ", Emprestável: " + emprestavel + ", Quantidade de Exemplares: " + quantidadeExemplares;
    }
    
 // Implementação do método abstrato getCategorias para Tese
    @Override
    public Set<String> getCategorias() {
        // Lógica para obter categorias específicas de Tese
        Set<String> categorias = new HashSet<>();
        categorias.add("Acadêmico"); 
        return categorias;
    }
}
