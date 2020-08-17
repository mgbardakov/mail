package ru.mailsort;

/**
 * mock input for unit testing
 * @author mbardakov
 * @since 16.08.2020
 */
public class StubInput implements Input {
    private String[] arr;
    private int counter;

    public StubInput(String[] arr) {
        this.arr = arr;
        counter = 0;
    }

    @Override
    public String askString(String question) {
        return arr[counter++];
    }
}
