package com.in28minutes.restfulwebservices.service;

import com.in28minutes.restfulwebservices.entity.User;
import com.in28minutes.restfulwebservices.exception.UserNotFoundException;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class UserDaoService {

    private static int userCount =0;
    private static List<User> userList = new ArrayList<>();

    static {
        userList.add(new User(++userCount,"Javed", LocalDateTime.now().minusYears(20)));
        userList.add(new User(++userCount,"Adam", LocalDateTime.now().minusYears(22)));
        userList.add(new User(++userCount,"Zoe", LocalDateTime.now().minusYears(18)));
    }

    public List<User> getUserList(){
        return userList;
    }

    public User getUserById(int id){
        return userList.stream().filter(user->user.getId().equals(id)).findFirst().orElse(null);
    }

    public void deleteById(int id){
         userList.removeIf(user->user.getId().equals(id));
    }

    public User addUser(User user){
        user.setId(++userCount);
        userList.add(user);
        return user;
    }
}
