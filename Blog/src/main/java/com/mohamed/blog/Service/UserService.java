package com.mohamed.blog.Service;

import com.mohamed.blog.Model.User;

public interface UserService {

    public User findUserById (Long userId) throws Exception;

}
