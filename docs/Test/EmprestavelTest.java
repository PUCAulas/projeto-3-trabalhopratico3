package main.java;

import static org.junit.Assert.*;
import org.junit.Test;

public class EmprestavelTest implements Emprestavel {

    private boolean emprestavel;
    private int quantidadeExemplares;

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
    public void emprestar() {
        if (podeSerEmprestado()) {
            quantidadeExemplares--;
        }
    }

    @Override
    public boolean podeSerEmprestado() {
        return emprestavel && quantidadeExemplares > 0;
    }

    @Test
    public void testIsEmprestavel() {
        setEmprestavel(true);
        assertTrue(isEmprestavel());

        setEmprestavel(false);
        assertFalse(isEmprestavel());
    }

    @Test
    public void testSetEmprestavel() {
        setEmprestavel(true);
        assertTrue(isEmprestavel());
    }

    @Test
    public void testGetQuantidadeExemplares() {
        setQuantidadeExemplares(5);
        assertEquals(5, getQuantidadeExemplares());
    }

    @Test
    public void testSetQuantidadeExemplares() {
        setQuantidadeExemplares(10);
        assertEquals(10, getQuantidadeExemplares());
    }

    @Test
    public void testEmprestar() {
        setEmprestavel(true);
        setQuantidadeExemplares(3);

        emprestar();
        assertEquals(2, getQuantidadeExemplares());

        setQuantidadeExemplares(0);
        emprestar();
        assertEquals(0, getQuantidadeExemplares());
    }

    @Test
    public void testPodeSerEmprestado() {
        setEmprestavel(true);
        setQuantidadeExemplares(3);

        assertTrue(podeSerEmprestado());

        setEmprestavel(false);
        assertFalse(podeSerEmprestado());

        setEmprestavel(true);
        setQuantidadeExemplares(0);
        assertFalse(podeSerEmprestado());
    }
}
