package main.java;

//Interface para itens emprestáveis
public interface Emprestavel {
	boolean isEmprestavel();
	
	void setEmprestavel(boolean emprestavel);

    int getQuantidadeExemplares();

    void setQuantidadeExemplares(int quantidadeExemplares);
    
    void emprestar();

    boolean podeSerEmprestado();
}
