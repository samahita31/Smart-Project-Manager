package com.udr.MyService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.udr.Entity.User;
import com.udr.Repo.UserRepo;

@Service
public class MyServiceClass {

    @Autowired
    private UserRepo userRepo;

    public void saveUser(User user) {
        userRepo.save(user);
    }

 // MyServiceClass.java
    public List<User> findByEmailAndPassword(String email, String password) {
        return userRepo.findByEmailAndPassword(email, password);
    }

}

