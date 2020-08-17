package ru.mailsort;

import java.util.List;
import java.util.Set;

/**
 * interface for user sorting
 * @author mbardakov
 * @since 16.08.2020
 */
public interface Sorter {
    /**
     * merges same users
     * @param users source user list
     * @return relevant user list
     */
    Set<User> getRelevantUsers(List<User> users);
}
