package main.java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//Classe para usuários
public class Usuario {
	private String nome;
    private List<ItemBiblioteca> itensEmprestados;
    private static final int LIMITE_EMPRESTIMOS = 3;
    private static int proximoId = 1; // Contador para gerar IDs únicos
    private int id;
    private String curso;
    private List<String> categoriasDeInteresse;
    
    
    public Usuario(String nome) {
        this.nome = nome;
        this.id = proximoId++;
        this.itensEmprestados = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    
    public void adicionarEmprestimo(ItemBiblioteca item) {
        itensEmprestados.add(item);
    }

    public List<ItemBiblioteca> getItensEmprestados() {
        return Collections.unmodifiableList(itensEmprestados);
    }
    
    public void adicionarItemEmprestado(ItemBiblioteca item) {
        this.itensEmprestados.add(item);
    }
    
    public boolean podePegarEmprestado() {
        return itensEmprestados.size() < LIMITE_EMPRESTIMOS;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public List<String> getCategoriasDeInteresse() {
        return categoriasDeInteresse;
    }

    public void setCategoriasDeInteresse(List<String> categoriasDeInteresse) {
        this.categoriasDeInteresse = categoriasDeInteresse;
    }
    
 // Método toString para representação textual do objeto
    @Override
    public String toString() {
        return "Usuario [nome=" + nome + ", itensEmprestados=" + itensEmprestados + "]";
    }
}


