package ru.mailsort;

import java.util.List;

/**
 * loader interface
 * @author mbardakov
 * @since 16.08.2020
 */
public interface Loader {
    /**
     * loads list of users from some input source
     * @return list og users
     */
    List<User> load();
}
