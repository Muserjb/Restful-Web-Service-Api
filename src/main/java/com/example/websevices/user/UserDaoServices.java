package com.example.websevices.user;


import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Component
public class UserDaoServices {
    //JPA / Hibernate  > Database
    private static int userCount = 0;
    private static List<User> users = new ArrayList<>();

    static {
        users.add(new User(++userCount, "Musa", LocalDate.now().minusYears(30)));
        users.add(new User(++userCount, "Usman", LocalDate.now().minusYears(31)));
        users.add(new User(++userCount, "Abubakar", LocalDate.now().minusYears(32)));
        users.add(new User(++userCount, "Mahmud", LocalDate.now().minusYears(33)));
    }
    public List<User> findAll(){
        return  users;
    }

    public User findOneUser(int id) {
        //Predicate<? super User> predicate = user -> user.getId().equals(id);
        Predicate<? super User> predicate = user -> user.getId().equals(id);
        User user = users.stream().filter(predicate).findFirst().orElse(null);
        return user;

        /*
        // Create a list of User objects
        List<User> userList = new ArrayList<>();
        // Iterate over the list of User objects
        for (User user : userList) {
            // Perform actions on each User object
            if (user.getId() == id) {
                return user;
            }
        }
         */
    }

    public void deleteById(int id) {
        Predicate<? super User> predicate = user -> user.getId().equals(id);
        users.removeIf(predicate);
    }

    public User saveUser(User user) {
        user.setId(++userCount);
        users.add(user);
        return user;
    }

    // public List<User> findAll()

    // public User saveUser(User user)
    // public User findOne(int id)





}
