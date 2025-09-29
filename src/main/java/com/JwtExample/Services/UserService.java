package com.JwtExample.Services;

import com.JwtExample.Models.User;
import lombok.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class UserService {

    private List<User> store = new ArrayList<>();

    public UserService(){
        store.add(new User(UUID.randomUUID().toString(),"Subhashree Barik", "Subhashree@gmail.com"));
        store.add(new User(UUID.randomUUID().toString(),"Jayaanti Barik", "Jayanti@gmail.com"));
        store.add(new User(UUID.randomUUID().toString(),"Sujit Barik", "Sujit@gmail.com"));
        store.add(new User(UUID.randomUUID().toString(),"Sunit Barik", "Sunit@gmail.com"));
    }

    public List<User> getUsers(){
        return this.store;
    }
}