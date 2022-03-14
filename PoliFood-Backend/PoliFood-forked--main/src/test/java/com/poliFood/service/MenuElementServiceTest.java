package com.poliFood.service;

import com.poliFood.model.MenuElement;
import com.poliFood.model.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MenuElementServiceTest {
    @Autowired
    MenuElementService menuElementService;

    @Test
    void testUserAdd(){
        MenuElement mu = new MenuElement();
        mu.setName("testMenuElement");
        menuElementService.save(mu);

        Assertions.assertEquals(menuElementService.findByName("testMenuElement").get(0).getName()
                ,"testMenuElement","menuElement addition to repo");
    }

    @Test
    void testUserDelete(){
        menuElementService.delete(menuElementService.findByName("testMenuElement").get(0));
        Assertions.assertEquals(menuElementService.findByName("testMenuElement").size(),0, "menuElement removal from repo");
    }
}
