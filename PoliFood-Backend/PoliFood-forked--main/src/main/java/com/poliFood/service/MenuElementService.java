package com.poliFood.service;

import com.poliFood.model.MenuElement;
import com.poliFood.projection.MenuElementView;
import com.poliFood.repository.MenuElementRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuElementService {
    private MenuElementRepository menuElementRepository;

    public MenuElementService(MenuElementRepository menuElementRepository) {
        this.menuElementRepository = menuElementRepository;
    }

    public void save(MenuElement menuElement){
        menuElementRepository.save(menuElement);
    }

    public void delete(MenuElement menuElement){
        menuElementRepository.delete(menuElement);
    }

    public List<MenuElementView> findAll(){
        return menuElementRepository.findAllBy();
    }

    public List<MenuElement> findByName(String name) {return menuElementRepository.findByName(name);}

    public MenuElement findById(Long id){
        return menuElementRepository.findById(id).orElse(null);
    }
}
