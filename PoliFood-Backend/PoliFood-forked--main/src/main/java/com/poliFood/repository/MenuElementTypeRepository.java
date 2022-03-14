package com.poliFood.repository;

import com.poliFood.model.MenuElementType;
import com.poliFood.projection.MenuElementTypeView;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface MenuElementTypeRepository extends JpaRepository<MenuElementType, Long> {
    MenuElementType findByName(String name);
    List<MenuElementTypeView> findAllBy();
}
