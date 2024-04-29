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

    public String changeStatusOfUser(Integer id, Integer status) {
        Optional<UserModel> optionalUser = userRepo.findById(id);
        if (optionalUser.isPresent()) {
            UserModel userModel = optionalUser.get();
            userModel.setStatus(status);
            userRepo.save(userModel);
            return status == 0 ? "Ban user successfully" : "Activate user successfully";
        } else {
            return "User not found";
        }
    }
}
