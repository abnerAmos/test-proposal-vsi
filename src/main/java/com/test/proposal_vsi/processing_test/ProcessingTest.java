package com.test.proposal_vsi.processing_test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

/**
 * Programa que permite ao usuário inserir um grupo de letras distintas
 * e exibir todos os anagramas possíveis da string fornecida.
 */
public class ProcessingTest {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continueProgram = true;

        while (continueProgram) {
            System.out.println("Digite um grupo de letras distintas:");
            String input = scanner.nextLine();

            if (!isValidInput(input)) {
                System.out.println("Entrada inválida. " +
                        "Certifique-se de que a entrada não está vazia, " +
                        "contém apenas letras distintas, e possui mais de 1 caractere.");
                continueProgram = askToContinue(scanner);
                continue;
            }

            List<String> anagrams = generateAnagrams(input);

            System.out.println("Anagramas:");
            for (String anagram : anagrams) {
                System.out.println(anagram);
            }

            continueProgram = askToContinue(scanner);
        }

        scanner.close();
    }

    /**
     * Valida a entrada fornecida pelo usuário.
     * Verifica se a string é não nula, não vazia, contém apenas letras e não possui caracteres repetidos.
     *
     * @param input A string fornecida pelo usuário.
     * @return true se a entrada for válida, caso contrário, false.
     */
    public static boolean isValidInput(String input) {
        if (input == null || input.length() < 2) {
            return false;
        }

        HashSet<Character> seen = new HashSet<>();
        for (char c : input.toCharArray()) {
            if (!Character.isLetter(c) || !seen.add(c)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Pergunta ao usuário se ele deseja continuar utilizando o programa.
     *
     * @param scanner Scanner para capturar a entrada do usuário.
     * @return true se o usuário desejar continuar, false caso contrário.
     */
    private static boolean askToContinue(Scanner scanner) {
        System.out.println("Deseja tentar novamente? (s/n):");
        String response = scanner.nextLine().trim().toLowerCase();
        return response.equals("s") || response.equals("sim");
    }

    /**
     * Gera todos os anagramas possíveis de uma string fornecida.
     *
     * @param input A string de entrada.
     * @return Uma lista contendo todos os anagramas possíveis.
     */
    public static List<String> generateAnagrams(String input) {
        List<String> result = new ArrayList<>();
        permute(input.toCharArray(), 0, result);
        return result;
    }

    /**
     * Função recursiva para gerar todas as permutações de um array de caracteres.
     *
     * @param chars O array de caracteres.
     * @param index O índice atual para permutação.
     * @param result A lista onde os resultados serão armazenados.
     */
    private static void permute(char[] chars, int index, List<String> result) {
        if (index == chars.length - 1) {
            result.add(new String(chars));
            return;
        }

        for (int i = index; i < chars.length; i++) {
            swap(chars, index, i);
            permute(chars, index + 1, result);
            swap(chars, index, i); // Desfaz a troca para restaurar o estado original
        }
    }

    /**
     * Troca dois caracteres de posição em um array.
     *
     * @param chars O array de caracteres.
     * @param i O índice do primeiro caractere.
     * @param j O índice do segundo caractere.
     */
    public static void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }
}

