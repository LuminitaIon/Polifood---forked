package com.poliFood.controller;

import com.poliFood.model.Menu;
import com.poliFood.model.MenuElement;
import com.poliFood.projection.MenuElementView;
import com.poliFood.projection.MenuView;
import com.poliFood.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path="/menu")
public class MenuController {
    @Autowired
    private MenuService menuService;

    @PostMapping(path = "/add")
    public ResponseEntity<Menu> save(@RequestBody Menu menu){
        menuService.save(menu);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    public List<MenuView> getAllMenus(){
        return menuService.findAll();
    }

    @GetMapping(path = "/menuElementsFromMenu")
    public List<MenuElement> getMenuElementByMenuId(Long id){
        return (List<MenuElement>) menuService.findById(id).getMenuElements();
    }

}
