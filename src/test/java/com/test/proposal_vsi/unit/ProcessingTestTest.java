package com.test.proposal_vsi.unit;

import com.test.proposal_vsi.processing_test.ProcessingTest;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

class ProcessingTestTest {

    /**
     * Testa a validação de entrada com diferentes cenários.
     */
    @Test
    void testIsValidInput() {
        assertTrue(ProcessingTest.isValidInput("abc"));
        assertFalse(ProcessingTest.isValidInput(""));
        assertFalse(ProcessingTest.isValidInput("a"));
        assertFalse(ProcessingTest.isValidInput("aabb"));
        assertFalse(ProcessingTest.isValidInput("123"));
        assertFalse(ProcessingTest.isValidInput(null));
        assertFalse(ProcessingTest.isValidInput("a b c"));
    }

    /**
     * Testa a geração de anagramas para uma entrada válida.
     */
    @Test
    void testGenerateAnagrams() {
        List<String> anagrams = ProcessingTest.generateAnagrams("abc");
        assertEquals(6, anagrams.size());
        assertTrue(anagrams.contains("abc"));
        assertTrue(anagrams.contains("acb"));
        assertTrue(anagrams.contains("bac"));
        assertTrue(anagrams.contains("bca"));
        assertTrue(anagrams.contains("cab"));
        assertTrue(anagrams.contains("cba"));
    }

    /**
     * Testa a troca de caracteres em um array.
     */
    @Test
    void testSwap() {
        char[] chars = {'a', 'b', 'c'};
        ProcessingTest.swap(chars, 0, 2);
        assertArrayEquals(new char[]{'c', 'b', 'a'}, chars);
    }
}

