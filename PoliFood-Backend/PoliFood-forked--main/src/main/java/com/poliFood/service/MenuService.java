package com.poliFood.service;

import com.poliFood.model.Menu;
import com.poliFood.projection.MenuView;
import com.poliFood.repository.MenuRepository;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.util.List;
import java.util.Optional;

@Service
public class MenuService {
    public MenuRepository menuRepository;

    public MenuService(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }

    public void save(Menu menu){
        menuRepository.save(menu);
    }

    public void delete(Menu menu){
        menuRepository.delete(menu);
    }

    public List<MenuView> findAll(){
        return menuRepository.findAllBy();
    }

    public Menu findById(Long id){
        Optional<Menu> menu = menuRepository.findById(id);
        return menu.orElse(null);
    }

    public List<MenuView> findByDay(DayOfWeek day){
        return menuRepository.findByDay(day);
    }
}
