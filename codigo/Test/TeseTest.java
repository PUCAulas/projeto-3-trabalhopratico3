package main.java;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TeseTest {

    @Test
    public void testTese() {

        Tese tese = new Tese("Título da Tese", "Autor da Tese", 2022, true, 5);

        assertEquals("Título da Tese", tese.getTitulo());
        assertEquals("Autor da Tese", tese.getAutor());
        assertEquals(2022, tese.getAnoPublicacao());
        assertEquals("Tese", tese.getTipo());
        assertEquals(true, tese.isEmprestavel());
        assertEquals(5, tese.getQuantidadeExemplares());

        tese.setEmprestavel(false);
        assertEquals(false, tese.isEmprestavel());

        tese.setQuantidadeExemplares(10);
        assertEquals(10, tese.getQuantidadeExemplares());

        String expectedToString = "Tese - Título: Título da Tese, Autor: Autor da Tese, Ano de Publicação: 2022, Emprestável: false, Quantidade de Exemplares: 10";
        assertEquals(expectedToString, tese.toString());
    }
}
