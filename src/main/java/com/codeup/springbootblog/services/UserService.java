package com.codeup.springbootblog.services;


import com.codeup.springbootblog.repositories.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService {
    private Users users;

    @Autowired
    public UserService(Users users){
        this.users = users;
    };

    public Users getUsers() {
        return users;
    }

}

//
