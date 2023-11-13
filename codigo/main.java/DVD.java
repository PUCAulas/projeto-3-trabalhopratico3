package main.java;

//Classe para DVDs
public class DVD extends ItemBiblioteca implements Emprestavel {
    public DVD(String titulo, String autor, int anoPublicacao, boolean emprestavel, int quantidadeExemplares) {
        super(titulo, autor, anoPublicacao, emprestavel, quantidadeExemplares);
        this.emprestavel = emprestavel;
        this.quantidadeExemplares = quantidadeExemplares;
    }

    @Override
    public String getTipo() {
        return "DVD";
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
        return "DVD - " + super.toString() + ", Emprestável: " + emprestavel + ", Quantidade de Exemplares: " + quantidadeExemplares;
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
}