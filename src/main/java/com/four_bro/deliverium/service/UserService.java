package com.four_bro.deliverium.service;

import java.util.List;
import java.util.Optional;

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

    public boolean login(String username, String password) {
        UserModel user = userRepo.findByUsernameAndPassword(username, password);
        if (user == null) {
            return false;
        }
        return user != null;
    }

    public List<UserModel> getAllUsersbyStatus() {
        return userRepo.findByRole(1);
    }

    public String banUsers(Integer id) {
        Optional<UserModel> optionalUser = userRepo.findById(id);
        if (optionalUser.isPresent()) {
            UserModel userModel = optionalUser.get();
            userModel.setStatus(0);
            userRepo.save(userModel);
            return "Ban user successfully";
        } else {
            return "User not found";
        }
    }
}
