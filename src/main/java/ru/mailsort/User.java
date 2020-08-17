package ru.mailsort;


import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * data model class
 * @author mbardakov
 * @since 14.08.2020
 */
public class User {
    private String name;
    private Set<String> emails;

    public User(String name) {
        this.name = name;
        this.emails = new HashSet<>();
    }

    public User(String name, Set<String> emails) {
        this.name = name;
        this.emails = emails;
    }

    public String getName() {
        return name;
    }

    public Set<String> getEmails() {
        return emails;
    }

    public void addEmail(String email) {
        emails.add(email);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(name, user.name)
                && Objects.equals(emails, user.emails);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, emails);
    }

    @Override
    public String toString() {
        return "User{"
                + "name='" + name + '\''
                + ", emails=" + emails + '}';
    }
}
