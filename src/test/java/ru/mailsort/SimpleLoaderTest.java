package ru.mailsort;

import org.junit.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class SimpleLoaderTest {

    @Test
    public void whenLoadedOneUser() {
        Loader loader = new SimpleLoader(new StubInput(new String[]{"user1",
        "email1", "exit"}));
        Set<String> emailSet = new HashSet<>();
        emailSet.add("email1");
        List<User> expected = List.of(new User("user1", emailSet));
        assertThat(loader.load(), is(expected));
    }

}