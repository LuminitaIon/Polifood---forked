package com.poliFood.repository;

import com.poliFood.model.Role;
import com.poliFood.projection.RoleView;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
    List<RoleView> findAllBy();
}
