package com.poliFood.controller;

import com.poliFood.dto.CafeteriaDTO;
import com.poliFood.dto.convertor.CafeteriaConverter;
import com.poliFood.model.Cafeteria;
import com.poliFood.model.Menu;
import com.poliFood.model.MenuElement;
import com.poliFood.projection.CafeteriaAdminView;
import com.poliFood.projection.CafeteriaView;
import com.poliFood.projection.MenuElementView;
import com.poliFood.projection.MenuView;
import com.poliFood.service.CafeteriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path="/cafeteria")
public class CafeteriaController {
    @Autowired
    private CafeteriaService cafeteriaService;


    @PostMapping(path = "/add")
    public ResponseEntity<Cafeteria> save(@RequestBody Cafeteria cafeteria){
        cafeteriaService.save(cafeteria);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    public List<CafeteriaView> getAllCafeteria(){
        return cafeteriaService.findAll();
    }

    @GetMapping(path = "/getMenuFromCafeteria/{name}")
    public List<MenuElementView> getCafeteriaByName(@PathVariable String name){
        List<MenuElementView> menuElements = new ArrayList<>();
        if(name.equals("undefined")){
            for (MenuView m: cafeteriaService.findAll().get(0).getMenus()) {
                menuElements.addAll(m.getMenuElements());
            }
            return menuElements;
        }
        for (MenuView m: cafeteriaService.findCafeteriaViewByName(name).getMenus()) {
            menuElements.addAll(m.getMenuElements());
        }
        return menuElements;
    }

    @PutMapping(path = "/update")
    @ResponseStatus(HttpStatus.OK)
    public void updateCafeteria(CafeteriaDTO cafeteriaDTO) throws ParseException {
        Cafeteria cafeteria = CafeteriaConverter.convertToEntity(cafeteriaDTO);
        cafeteriaService.save(cafeteria);
    }

    @GetMapping(path = "menuElementsFromMenuDay/{day}/{cafeteria}")
    public List<MenuElementView> getMenuElementByMenuDay(@PathVariable String day, @PathVariable String cafeteria){
        DayOfWeek dayOfWeek = DayOfWeek.valueOf(day);
        List<MenuElementView> elementViews =  new ArrayList<>();
        for(MenuView m: cafeteriaService.findCafeteriaViewByName(cafeteria).getMenus()){
            if(m.getDay() == dayOfWeek){
                elementViews.addAll(m.getMenuElements());
            }
        }
        return elementViews;
    }

    @GetMapping(path = "cafeteriaAdmin")
    public List<CafeteriaAdminView> getAllCafeteriaAdmin(){
        List<CafeteriaAdminView> cafeteriaAdminViews = new ArrayList<>();
        for (CafeteriaView cafeteriaView: cafeteriaService.findAll()) {
            cafeteriaAdminViews.addAll(cafeteriaService.findAllCafeteriaAdmin(cafeteriaView.getId()));
        }
        return cafeteriaAdminViews;
    }
}
