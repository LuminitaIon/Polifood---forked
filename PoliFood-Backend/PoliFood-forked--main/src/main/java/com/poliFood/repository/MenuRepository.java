package com.poliFood.repository;

import com.poliFood.model.Cafeteria;
import com.poliFood.model.Menu;
import com.poliFood.projection.MenuView;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.DayOfWeek;
import java.util.List;
import java.util.Optional;

public interface MenuRepository extends JpaRepository<Menu, Long> {
    List<Menu> findByCafeteria(Cafeteria cafeteria);
    List<MenuView> findAllBy();
    Optional<Menu> findById(Long id);
    List<MenuView> findByDay(DayOfWeek day);
}
