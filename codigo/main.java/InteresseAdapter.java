package main.java;

public class InteresseAdapter {
	private Usuario usuario;

    public InteresseAdapter(Usuario usuario) {
        this.usuario = usuario;
    }

    public String[] adaptarCategorias() {
 
        return new String[]{"Categoria1", "Categoria2", "Categoria3"};
    }
}
