package main.java;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class SistemaBibliotecaTest {
    private SistemaBiblioteca sistema;

    @Before
    public void setUp() {
        sistema = new SistemaBiblioteca();
    }

    @Test
    public void testAdicionarItem() {
        Livro livro = new Livro("Livro Teste", "Autor Teste", 2023, true, 2);
        sistema.adicionarItem(livro);

        assertTrue(sistema.getAcervo().containsKey("Livro Teste"));
    }

    @Test
    public void testAdicionarUsuario() {
        Usuario usuario = new Usuario("Usuario Teste");
        sistema.adicionarUsuario(usuario);

        assertTrue(sistema.getUsuarios().contains(usuario));
    }

    @Test
    public void testCadastrarNovoItem() {
        sistema.cadastrarNovoItem();
}
}
