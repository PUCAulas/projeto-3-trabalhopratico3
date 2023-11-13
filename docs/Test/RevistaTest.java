package main.java;

import static org.junit.Assert.*;
import org.junit.Test;

public class RevistaTest {

    @Test
    public void testGetTipo() {
        Revista revista = new Revista("Título da Revista", "Autor da Revista", 2022, true, 5);
        assertEquals("Revista", revista.getTipo());
    }

    @Test
    public void testIsEmprestavel() {
        Revista revista = new Revista("Título da Revista", "Autor da Revista", 2022, true, 5);
        assertTrue(revista.isEmprestavel());

        revista.setEmprestavel(false);
        assertFalse(revista.isEmprestavel());
    }

    @Test
    public void testSetEmprestavel() {
        Revista revista = new Revista("Título da Revista", "Autor da Revista", 2022, true, 5);
        revista.setEmprestavel(false);
        assertFalse(revista.isEmprestavel());
    }

    @Test
    public void testGetQuantidadeExemplares() {
        Revista revista = new Revista("Título da Revista", "Autor da Revista", 2022, true, 5);
        assertEquals(5, revista.getQuantidadeExemplares());

        revista.setQuantidadeExemplares(10);
        assertEquals(10, revista.getQuantidadeExemplares());
    }

    @Test
    public void testSetQuantidadeExemplares() {
        Revista revista = new Revista("Título da Revista", "Autor da Revista", 2022, true, 5);
        revista.setQuantidadeExemplares(10);
        assertEquals(10, revista.getQuantidadeExemplares());
    }

    @Test
    public void testToString() {
        Revista revista = new Revista("Título da Revista", "Autor da Revista", 2022, true, 5);
        assertEquals("Revista - Título: Título da Revista, Autor: Autor da Revista, Ano de Publicação: 2022, Emprestável: true, Quantidade de Exemplares: 5", revista.toString());
    }

}
