package com.four_bro.deliverium.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.four_bro.deliverium.model.UserModel;
import com.four_bro.deliverium.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserService {
    @Autowired
    private UserRepository userRepo;

    public boolean login(String username,String password){
        UserModel user = userRepo.findByUsernameAndPassword(username, password);
        return user != null;
    }

    public List<UserModel> getAllUsers(){
        return userRepo.findAll();
    }
}
