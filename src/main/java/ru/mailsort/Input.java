package ru.mailsort;

/**
 * input interface
 * @author mbardakov
 * @since 16.08.2020
 */
public interface Input {
    /**
     * gets string from input source
     * @param question string to display
     * @return string from input
     */
    String askString(String question);
}
