package ru.mailsort;

import java.util.Set;

/**
 * output interface
 * @author mbardakov
 * @since 16.08.2020
 */
public interface Output {
    /**
     * performs output action
     * @param users - set of users
     */
    void executeOutput(Set<User> users);
}
