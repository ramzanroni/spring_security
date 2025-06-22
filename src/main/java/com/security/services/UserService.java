package com.security.services;

import com.security.models.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    List<User> list = new ArrayList<>();

    public UserService() {
        list.add(new User("ramzan", "1234", "ramzan@gmail.com"));
        list.add(new User("nafisa", "1234", "nafisa@gmail.com"));
        list.add(new User("jarifa", "1234", "jarifa@gmail.com"));
        list.add(new User("najiba", "1234", "najiba@gmail.com"));
    }

    // Get All Users
    public List<User> getUsers() {
        return list;
    }

    // Get Single User
    public User getUser(String username) {
        return list.stream().filter(user -> user.getUsername().equals(username)).findFirst().orElse(null);
    }

    // Add User
    public User addUser(User user) {
        list.add(user);
        return user;
    }

    // Update User
    public User updateUser(User user) {
        int index = list.indexOf(user);
        list.set(index, user);
        return user;
    }

    // Delete User
    public User deleteUser(String username) {
        User user = getUser(username);
        list.remove(user);
        return user;
    }
}
