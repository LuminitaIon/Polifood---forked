package com.poliFood.controller;

import com.poliFood.model.MenuElement;
import com.poliFood.projection.MenuElementView;
import com.poliFood.service.MenuElementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/menuElement")
public class MenuElementController {
    @Autowired
    private MenuElementService menuElementService;

    @PostMapping(path = "/add")
    public ResponseEntity<MenuElement> save(@RequestBody MenuElement menuElement){
        menuElementService.save(menuElement);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    public List<MenuElementView> getAllMenus(){
        return menuElementService.findAll();
    }
}
