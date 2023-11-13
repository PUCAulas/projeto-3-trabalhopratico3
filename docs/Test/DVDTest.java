package main.java;
import org.junit.Test;
import static org.junit.Assert.*;

public class DVDTest {

    @Test
    public void testEmprestar() {
        DVD dvd = new DVD("Título do DVD", "Autor do DVD", 2022, true, 10);

        assertEquals(10, dvd.getQuantidadeExemplares());

        dvd.emprestar();

        assertEquals(9, dvd.getQuantidadeExemplares());
    }

    @Test
    public void testPodeSerEmprestado() {
        DVD dvdEmprestavel = new DVD("Título do DVD", "Autor do DVD", 2022, true, 5);
        DVD dvdNaoEmprestavel = new DVD("Outro DVD", "Outro Autor", 2020, false, 3);

        assertTrue(dvdEmprestavel.podeSerEmprestado());

        assertFalse(dvdNaoEmprestavel.podeSerEmprestado());
    }

    @Test
    public void testToString() {
        DVD dvd = new DVD("Título do DVD", "Autor do DVD", 2022, true, 10);

        assertEquals("DVD - Título do DVD, Autor do DVD, Ano: 2022, Emprestável: true, Quantidade de Exemplares: 10",
                dvd.toString());
    }

}
