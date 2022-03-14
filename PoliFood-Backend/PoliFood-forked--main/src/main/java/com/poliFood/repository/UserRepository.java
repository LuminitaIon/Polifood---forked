package com.poliFood.repository;

import com.poliFood.model.Role;
import com.poliFood.model.User;
import com.poliFood.projection.UserBarView;
import com.poliFood.projection.UserView;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
    UserBarView findAllByEmail(String email);
    List<User> findByRole(Role role);
    List<UserView> findAllBy();
    UserView findAllById(Long id);
}
