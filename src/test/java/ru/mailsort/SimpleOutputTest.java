package ru.mailsort;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintWriter;
import java.util.Set;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class SimpleOutputTest {
    @Test
    public void whenOneUserInSet() {
        Set<String> emails = Set.of("email1");
        User user = new User("user1", emails);
        Set<User> users = Set.of(user);
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        PrintWriter pw = new PrintWriter(bos);
        String expected = user.toString();
        Output output = new SimpleOutput(pw::print);
        output.executeOutput(users);
        pw.close();
        assertThat(bos.toString(), is(expected));
    }

}