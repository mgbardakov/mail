package ru.mailsort;

import java.util.*;

/**
 * class that merges users
 * @author mbardakov
 * @since 16.08.2020
 */
public class MapSorter implements Sorter {

    @Override
    public Set<User> getRelevantUsers(List<User> users) {
        var sourceMap = putEmailsToMap(users);
        var rslMap = new HashMap<String, User>();
        for (Map.Entry<String, String> pair : sourceMap.entrySet()) {
            var userName = pair.getValue();
            var email = pair.getKey();
            if (!rslMap.containsKey(userName)) {
                rslMap.put(userName, new User(userName));
            }
            rslMap.get(userName).addEmail(email);
        }
        return new HashSet<>(rslMap.values());
    }

    private Map<String, String> putEmailsToMap(List<User> users) {
        var rslMap = new HashMap<String, String>();
        for (User u : users) {
            var name = getRelevantUserName(rslMap, u);
            for (String email : u.getEmails()) {
                rslMap.put(email, name);
            }
        }
        return rslMap;
    }

    private String getRelevantUserName(Map<String, String> map,
                                           User user) {
      var name  =  user.getName();
      for (String mail : user.getEmails()) {
          if (map.containsKey(mail)) {
              name = map.get(mail);
          }
      }
      return name;
    }

    public static void main(String[] args) {
        Loader loader = new SimpleLoader(new ConsoleInput());
        Output output = new SimpleOutput(System.out::println);
        var userList = loader.load();
        Sorter sorter = new MapSorter();
        var actualUserSet = sorter.getRelevantUsers(userList);
        output.executeOutput(actualUserSet);
    }

}
