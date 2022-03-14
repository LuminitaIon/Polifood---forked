package com.poliFood.service;

import com.poliFood.model.MenuElementQuantity;
import com.poliFood.projection.MenuElementQuantityView;
import com.poliFood.repository.MenuElementQuantityRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuElementQuantityService {
    private MenuElementQuantityRepository menuElementQuantityRepository;

    public MenuElementQuantityService(MenuElementQuantityRepository menuElementQuantityRepository) {
        this.menuElementQuantityRepository = menuElementQuantityRepository;
    }

    public void save(MenuElementQuantity menuElementQuantity){
        menuElementQuantityRepository.save(menuElementQuantity);
    }

    public List<MenuElementQuantityView> getAll(){
        return menuElementQuantityRepository.findAllBy();
    }
}
