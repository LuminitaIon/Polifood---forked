package com.poliFood.repository;

import com.poliFood.model.Cafeteria;
import com.poliFood.projection.CafeteriaAdminView;
import com.poliFood.projection.CafeteriaView;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CafeteriaRepository extends JpaRepository<Cafeteria, Long> {
    Cafeteria findByName(String name);
    CafeteriaView findAllByName(String name);
    List<CafeteriaAdminView> findAllById(Long id);
    Cafeteria findByLocation(String location);
    List<Cafeteria> findBySchedule(String schedule);
    List<CafeteriaView> findAllBy();
}
