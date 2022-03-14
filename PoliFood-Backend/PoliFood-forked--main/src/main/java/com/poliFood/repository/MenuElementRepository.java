package com.poliFood.repository;

import com.poliFood.model.MenuElement;
import com.poliFood.model.MenuElementType;
import com.poliFood.projection.MenuElementView;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MenuElementRepository extends JpaRepository<MenuElement, Long> {
    List<MenuElement> findByName(String name);
    List<MenuElement> findByType(MenuElementType type);
    List<MenuElementView> findAllBy();
    Optional<MenuElement> findById(Long id);
}
