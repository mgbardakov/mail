package ru.mailsort;

import java.util.Set;
import java.util.function.Consumer;

/**
 * simple implementation of output
 * @author mbardakov
 * @since 16.08.2020
 */
public class SimpleOutput implements Output {

    private Consumer<User> con;

    public SimpleOutput(Consumer<User> con) {
        this.con = con;
    }

    @Override
    public void executeOutput(Set<User> users) {
        users.forEach(con);
    }
}
