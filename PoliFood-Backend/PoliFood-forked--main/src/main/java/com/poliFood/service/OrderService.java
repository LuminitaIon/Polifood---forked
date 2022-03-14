package com.poliFood.service;

import com.poliFood.model.Order;
import com.poliFood.projection.OrderView;
import com.poliFood.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    private OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public void save(Order order){
        orderRepository.save(order);
    }

    public List<OrderView> getAllOrders(){
        return orderRepository.findAllBy();
    }
}
