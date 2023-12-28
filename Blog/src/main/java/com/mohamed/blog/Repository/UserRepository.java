package com.mohamed.blog.Repository;

import com.mohamed.blog.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    public User findUserByEmail(String email);

}
