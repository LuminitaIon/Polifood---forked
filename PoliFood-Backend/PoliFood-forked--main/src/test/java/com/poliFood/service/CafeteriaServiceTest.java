package com.poliFood.service;

import com.poliFood.model.Cafeteria;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CafeteriaServiceTest {
    @Autowired
    CafeteriaService cafeteriaService;

    @Test
    void testCafeteriaAdd(){
        Cafeteria c = new Cafeteria();
        c.setName("testCafeteria");
        cafeteriaService.save(c);

        Assertions.assertEquals(cafeteriaService.findByName("testCafeteria").getName(),
                "testCafeteria","Cafeteria addition to repo");
    }

    @Test
    void testCafeteriaDelete(){
        cafeteriaService.delete(cafeteriaService.findByName("testCafeteria"));
        Assertions.assertNull(cafeteriaService.findByName("testCafeteria"),"Cafeteria delete from repo");
    }
}
