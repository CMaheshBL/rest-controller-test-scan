package com.rest.controller.test.service;

import com.rest.controller.test.dao.IUserDao;
import com.rest.controller.test.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {
    @Autowired
    private IUserDao userDao;

    @Override
    public boolean insertUser(User user) {
        return userDao.insertUser(user);
    }
}
