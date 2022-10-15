package com.in28min.rest.webservices.restfulwebservices.dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;

import com.in28min.rest.webservices.restfulwebservices.entity.User;

@Component
public class UserDaoService {
    // use JPA/Hibernate -> DB
    
    private static List<User> users = new ArrayList<>();
    
    private static int usersCount = 0;
    
    static {
        users.add(new User(++usersCount, "John", LocalDate.now().minusYears(30)));
        users.add(new User(++usersCount, "James", LocalDate.now().minusYears(25)));
        users.add(new User(++usersCount, "Jill", LocalDate.now().minusYears(21)));
    }
    
    // get all users
    public List<User> findAll() {
        return users;
    }
    
    // get user by id
    public User findById(int id) {
        Predicate<? super User> predicate = user -> Integer.valueOf(user.getId()).equals(id);
        return users.stream()
                        .filter(predicate)
                        .findFirst() // throws an exception if null
                            .orElse(null); // if value is present return value, else return other
    }
    
    // save user
    public User save(User user) {
        user.setId(++usersCount);
        users.add(user);
        return user;
    }
    
    public void deleteById(int id) {
        Predicate<? super User> predicate = user -> Integer.valueOf(user.getId()).equals(id);
        
        users.removeIf(predicate);
    }
    

}
