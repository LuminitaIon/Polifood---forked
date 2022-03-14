package com.poliFood.repository;

import com.poliFood.model.Order;
import com.poliFood.model.User;
import com.poliFood.projection.OrderView;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByUser(User user);
    List<OrderView> findAllBy();
}
