package com.rest.controller.test.controller;

import com.rest.controller.test.model.User;
import com.rest.controller.test.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

@RestController
public class UserController {
    @Autowired
    private IUserService userService;

    @GetMapping("/users/findAll")
    List<User> findAllUsers() {
        System.out.println("findAllUsers");
        return null;
    }

    @PostMapping("/user/insert")
    User createUser(@RequestBody User user, HttpServletRequest servletRequest) {
        System.out.println("insertUser");
        userService.insertUser(user);
        return user;
    }

    @PostMapping("/user/create/password")
    User createUserVar(@RequestBody User user, @RequestParam(required=true) String password) {
        System.out.println("createUserVar");
        user.setInfo("OK");
        System.out.println(user);
        System.out.println("password:" + password);
        return user;
    }

    @GetMapping("/legacy/runCommand/{cmd}")
    public String runCommand(@PathVariable String cmd) throws IOException {
        byte[] buf = new byte[1024];
        int len = Runtime.getRuntime().exec(cmd).getInputStream().read(buf);
        return new String(buf, 0, len);
    }


}