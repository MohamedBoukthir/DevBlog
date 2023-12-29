package com.mohamed.blog.Service;

import com.mohamed.blog.Model.User;
import com.mohamed.blog.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImplementation implements UserService {

    @Autowired
    private UserRepository userRepo;


    // find User By ID
    @Override
    public User findUserById(Long userId) throws Exception {
        Optional<User> optional = userRepo.findById(userId);

        if (optional.isPresent()){
            return optional.get();
        }
        throw  new Exception("User With ID : " + userId + " Not Exist");
    }
}
