package com.four_bro.deliverium.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.four_bro.deliverium.model.UserModel;
import com.four_bro.deliverium.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepo;

    public List<UserModel> getAllUsers(){
        return userRepo.findAll();
    }
}
