package ru.mailsort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * simple implementation of Loader interface
 * @author mbardakov
 * @since 16.08.2020
 */
public class SimpleLoader implements Loader {
    private Input input;
    private static final String EXIT = "exit";

    public SimpleLoader(Input input) {
        this.input = input;
    }

    @Override
    public List<User> load() {
        var rslList = new ArrayList<User>();
        var name = input.askString("Enter user name: ");
        var run = !name.equals(EXIT);
            while (run) {
                var emails = input.askString("Enter emails: ");
                rslList.add(createUser(name, emails));
                name = input.askString("Enter user name: ");
                if (name.equals(EXIT)) {
                    run = false;
                }
            }

        return rslList;
    }

    private User createUser(String name, String emails) {
        var emailArr = emails.split(" ");
        var emailSet = new HashSet<>(Arrays.asList(emailArr));
        return new User(name, emailSet);
    }
}
