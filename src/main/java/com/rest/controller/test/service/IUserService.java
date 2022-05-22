package com.rest.controller.test.service;

import com.rest.controller.test.model.User;

public interface IUserService {
    boolean insertUser(User user);

    User getUserByEmail(String email);

    User getUserById(long id);

    void updateUser(User user);
}
