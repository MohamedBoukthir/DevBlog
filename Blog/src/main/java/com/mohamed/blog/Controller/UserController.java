package com.mohamed.blog.Controller;

import com.mohamed.blog.Model.User;
import com.mohamed.blog.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @Autowired
    private UserRepository userRepo;


    // get all users
    @GetMapping("/all-users")
    public List<User> getAllUser(){
        List<User> users = userRepo.findAll();
        return users;
    }

    // create user
    @PostMapping("/create-user")
    public User createUser(@RequestBody User user) throws Exception {
        // check if this email exist
        User isExist = userRepo.findUserByEmail(user.getEmail());
            if (isExist != null) {
                throw new Exception("Sorry The Email : " + user.getEmail() + " Already Exist.");
            }
        // else create a new user
        User newUser = userRepo.save(user);
        return newUser;
    }

    // delete user by id
    @DeleteMapping("delete-user/{id}")
    public String deleteUser(@PathVariable Long id){
        userRepo.deleteById(id);
        return "User Deleted Successfully.";
    }



}
