package ru.mailsort;

import java.util.Scanner;

/**
 * basic console implementation of input
 * @author mbardakov
 * @since 16.08.2020
 */
public class ConsoleInput implements Input {
    private Scanner scan = new Scanner(System.in);
    @Override
    public String askString(String question) {
        System.out.print(question);
        return scan.nextLine();
    }
}
