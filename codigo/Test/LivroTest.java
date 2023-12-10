package main.java;

import static org.junit.Assert.*;
import org.junit.Test;

public class LivroTest {

    @Test
    public void testGetTipo() {
        Livro livro = new Livro("Título do Livro", "Autor do Livro", 2022, true, 5);
        assertEquals("Livro", livro.getTipo());
    }

    @Test
    public void testIsEmprestavel() {
        Livro livro = new Livro("Título do Livro", "Autor do Livro", 2022, true, 5);
        assertTrue(livro.isEmprestavel());

        livro.setEmprestavel(false);
        assertFalse(livro.isEmprestavel());
    }

    @Test
    public void testSetEmprestavel() {
        Livro livro = new Livro("Título do Livro", "Autor do Livro", 2022, true, 5);
        livro.setEmprestavel(false);
        assertFalse(livro.isEmprestavel());
    }

    @Test
    public void testGetQuantidadeExemplares() {
        Livro livro = new Livro("Título do Livro", "Autor do Livro", 2022, true, 5);
        assertEquals(5, livro.getQuantidadeExemplares());

        livro.setQuantidadeExemplares(10);
        assertEquals(10, livro.getQuantidadeExemplares());
    }

    @Test
    public void testSetQuantidadeExemplares() {
        Livro livro = new Livro("Título do Livro", "Autor do Livro", 2022, true, 5);
        livro.setQuantidadeExemplares(10);
        assertEquals(10, livro.getQuantidadeExemplares());
    }

    @Test
    public void testToString() {
        Livro livro = new Livro("Título do Livro", "Autor do Livro", 2022, true, 5);
        assertEquals("Livro - Título: Título do Livro, Autor: Autor do Livro, Ano de Publicação: 2022, Emprestável: true, Quantidade de Exemplares: 5", livro.toString());
    }
}
