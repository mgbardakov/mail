package ru.mailsort;

import org.junit.Test;

import java.util.*;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class MapSorterTest {

    @Test
    public void when5UsersAreActually2() {
        List<User> users = new ArrayList<>();
        users.add(new User("user1",
                new HashSet<>(Arrays.asList("xxx@ya.ru", "foo@gmail.com",
                        "lol@mail.ru"))));
        users.add(new User("user2",
                new HashSet<>(Arrays.asList("foo@gmail.com",
                        "ups@pisem.net"))));
        users.add(new User("user3",
                new HashSet<>(Arrays.asList("xyz@pisem.net",
                        "vasya@pupkin.com"))));
        users.add(new User("user4",
                new HashSet<>(Arrays.asList("ups@pisem.net", "aaa@bbb.ru"))));
        users.add(new User("user5",
                new HashSet<>(Arrays.asList("xyz@pisem.net"))));

        Set<User> expected = Set.of(new User("user1", new HashSet<>(
                Arrays.asList("xxx@ya.ru", "foo@gmail.com", "lol@mail.ru",
                        "ups@pisem.net", "aaa@bbb.ru"))), new User("user3",
                new HashSet<>(Arrays.asList("xyz@pisem.net", "vasya@pupkin.com"))));
        Sorter sorter = new MapSorter();
        assertThat(sorter.getRelevantUsers(users), is(expected));
    }

}