package main.java;

//Classe base para itens de biblioteca
abstract class ItemBiblioteca implements Comparable<ItemBiblioteca> {
	protected String titulo;
    protected String autor;
    protected int anoPublicacao;
    protected boolean emprestavel;
    protected int quantidadeExemplares;
    protected int exemplaresDisponiveis;
    private int quantidadeEmprestimos;

    public ItemBiblioteca(String titulo, String autor, int anoPublicacao, boolean emprestavel, int quantidadeExemplares) {
        this.titulo = titulo;
        this.autor = autor;
        this.anoPublicacao = anoPublicacao;
        this.emprestavel = emprestavel;
        this.quantidadeExemplares = quantidadeExemplares;
        this.exemplaresDisponiveis = quantidadeExemplares;
        this.quantidadeEmprestimos = 0;
    }

    public int getQuantidadeEmprestimos() {
        return quantidadeEmprestimos;
    }

    public void incrementarEmprestimos() {
        quantidadeEmprestimos++;
    }
    
    public boolean realizarEmprestimo() {
        if (emprestavel && exemplaresDisponiveis > 0) {
            exemplaresDisponiveis--;
            return true;
        } else {
            System.out.println("Este item não está disponível para empréstimo.");
            return false;
        }
    }

    public abstract String getTipo();

    @Override
    public int compareTo(ItemBiblioteca outroItem) {
        return Integer.compare(this.anoPublicacao, outroItem.anoPublicacao);
    }
    
    @Override
    public String toString() {
        return "Título: " + titulo + ", Autor: " + autor + ", Ano de Publicação: " + anoPublicacao;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getAnoPublicacao() {
        return anoPublicacao;
    }

    public void setAnoPublicacao(int anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }

    public boolean isEmprestavel() {
        return emprestavel;
    }

    public void setEmprestavel(boolean emprestavel) {
        this.emprestavel = emprestavel;
    }

    public int getQuantidadeExemplares() {
        return quantidadeExemplares;
    }

    public void setQuantidadeExemplares(int quantidadeExemplares) {
        this.quantidadeExemplares = quantidadeExemplares;
    }

    public int getExemplaresDisponiveis() {
        return exemplaresDisponiveis;
    }

    public void setExemplaresDisponiveis(int exemplaresDisponiveis) {
        this.exemplaresDisponiveis = exemplaresDisponiveis;
    }
}
