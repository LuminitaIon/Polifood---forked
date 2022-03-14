package com.poliFood.repository;

import com.poliFood.model.MenuElement;
import com.poliFood.model.MenuElementQuantity;
import com.poliFood.projection.MenuElementQuantityView;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MenuElementQuantityRepository extends JpaRepository<MenuElementQuantity, Long> {
    List<MenuElementQuantityView> findAllBy();
}
