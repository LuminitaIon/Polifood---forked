package com.poliFood.service;

import com.poliFood.model.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserServiceTest {
    @Autowired
    UserService userService;

    @Test
    void testUserAdd(){
        User u = new User();
        u.setEmail("testUserAdd");
        userService.save(u);

        Assertions.assertEquals(userService.findByEmail("testUserAdd").getEmail(),"testUserAdd","User addition to repo");
    }

    @Test
    void testUserDelete(){
        userService.delete(userService.findByEmail("testUserAdd"));
        Assertions.assertNull(userService.findByEmail("testUserAdd"), "User removal from repo");
    }
}
