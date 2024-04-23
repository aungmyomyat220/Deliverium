// package com.four_bro.deliverium.controller;

// import java.util.List;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;
// import com.four_bro.deliverium.model.UserModel;
// import com.four_bro.deliverium.service.UserService;
// import org.springframework.web.bind.annotation.RequestMethod;

// @RestController
// @RequestMapping("/api/v1")
// public class UserController {
//     @Autowired
//     private UserService userService;

//     @RequestMapping(value = "/all_users", method = RequestMethod.GET)
//     public List<UserModel> allUsers() {
//         List <UserModel> res=userService.getAllUsers();
//         return res;
//     } 
// }
