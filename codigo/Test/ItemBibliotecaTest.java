package main.java;

import static org.junit.Assert.*;
import org.junit.Test;

public class ItemBibliotecaTest extends ItemBiblioteca {

    public ItemBibliotecaTest(String titulo, String autor, int anoPublicacao, boolean emprestavel,
			int quantidadeExemplares) {
		super(titulo, autor, anoPublicacao, emprestavel, quantidadeExemplares);
		// TODO Auto-generated constructor stub
	}

    private static class TestItemBiblioteca extends ItemBibliotecaTest {
        public TestItemBiblioteca() {
            super("Título do Item", "Autor do Item", 2022, true, 5);
        }

        @Override
        public String getTipo() {
            return "TestTipo";
        }
    }

    @Test
    public void testGetQuantidadeEmprestimos() {
        TestItemBiblioteca testItem = new TestItemBiblioteca();
        assertEquals(0, testItem.getQuantidadeEmprestimos());

        testItem.incrementarEmprestimos();
        assertEquals(1, testItem.getQuantidadeEmprestimos());
    }

    @Test
    public void testRealizarEmprestimo() {
        TestItemBiblioteca testItem = new TestItemBiblioteca();
        assertTrue(testItem.realizarEmprestimo());
        assertEquals(4, testItem.getExemplaresDisponiveis());

        testItem.setExemplaresDisponiveis(0);
        assertFalse(testItem.realizarEmprestimo());
        assertEquals(0, testItem.getExemplaresDisponiveis());

        testItem.setEmprestavel(false);
        assertFalse(testItem.realizarEmprestimo());
        assertEquals(0, testItem.getExemplaresDisponiveis());
    }

    @Test
    public void testCompareTo() {
        TestItemBiblioteca testItem = new TestItemBiblioteca();
        ItemBiblioteca outroItem = new TestItemBiblioteca();

        assertTrue(testItem.compareTo(outroItem) == 0);

        outroItem.setAnoPublicacao(2021);

        assertTrue(testItem.compareTo(outroItem) > 0);
    }

    @Test
    public void testToString() {
        TestItemBiblioteca testItem = new TestItemBiblioteca();
        assertEquals("Título: Título do Item, Autor: Autor do Item, Ano de Publicação: 2022", testItem.toString());
    }

    @Test
    public void testSettersAndGetters() {
        TestItemBiblioteca testItem = new TestItemBiblioteca();

        testItem.setTitulo("Novo Título");
        assertEquals("Novo Título", testItem.getTitulo());

        testItem.setAutor("Novo Autor");
        assertEquals("Novo Autor", testItem.getAutor());

        testItem.setAnoPublicacao(2021);
        assertEquals(2021, testItem.getAnoPublicacao());

        testItem.setEmprestavel(false);
        assertFalse(testItem.isEmprestavel());

        testItem.setQuantidadeExemplares(10);
        assertEquals(10, testItem.getQuantidadeExemplares());

        testItem.setExemplaresDisponiveis(8);
        assertEquals(8, testItem.getExemplaresDisponiveis());
    }

	@Override
	public String getTipo() {
		// TODO Auto-generated method stub
		return null;
	}
}
