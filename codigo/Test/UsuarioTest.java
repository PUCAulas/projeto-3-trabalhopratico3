package main.java;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

public class UsuarioTest {

    @Test
    public void testUsuario() {

        Usuario usuario = new Usuario("John Doe");

        assertEquals("John Doe", usuario.getNome());
        assertEquals(1, usuario.getId());

        ItemBiblioteca livro = new Livro("Livro 1", "Autor 1", 2000, true, 3);
        usuario.adicionarItemEmprestado(livro);
        List<ItemBiblioteca> itensEmprestados = usuario.getItensEmprestados();
        assertEquals(1, itensEmprestados.size());
        assertEquals(livro, itensEmprestados.get(0));

        assertTrue(usuario.podePegarEmprestado()); 

        ItemBiblioteca tese = new Tese("Tese 1", "Autor 2", 2015, false, 3);
        usuario.adicionarItemEmprestado(tese);

        ItemBiblioteca cd = new CD("CD 1", "Artista 1", 2012, true, 3);
        usuario.adicionarItemEmprestado(cd);

        assertFalse(usuario.podePegarEmprestado()); 
        
        usuario.setNome("Jane Doe");
        assertEquals("Jane Doe", usuario.getNome());

        String expectedToString = "Usuario [nome=Jane Doe, itensEmprestados=" + itensEmprestados + "]";
        assertEquals(expectedToString, usuario.toString());
    }
}
