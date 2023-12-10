package main.java;
import org.junit.Test;
import static org.junit.Assert.*;

public class CDTest {

    @Test
    public void testEmprestar() {
        CD cd = new CD("Título do CD", "Autor do CD", 2022, true, 10);

        assertEquals(10, cd.getQuantidadeExemplares());

        cd.emprestar();

        assertEquals(9, cd.getQuantidadeExemplares());
    }

    @Test
    public void testPodeSerEmprestado() {
        CD cdEmprestavel = new CD("Título do CD", "Autor do CD", 2022, true, 5);
        CD cdNaoEmprestavel = new CD("Outro CD", "Outro Autor", 2020, false, 3);

        assertTrue(cdEmprestavel.podeSerEmprestado());

        assertFalse(cdNaoEmprestavel.podeSerEmprestado());
    }

    @Test
    public void testToString() {
        CD cd = new CD("Título do CD", "Autor do CD", 2022, true, 10);

        assertEquals("CD - Título do CD, Autor do CD, Ano: 2022, Emprestável: true, Quantidade de Exemplares: 10",
                cd.toString());
    }

}
