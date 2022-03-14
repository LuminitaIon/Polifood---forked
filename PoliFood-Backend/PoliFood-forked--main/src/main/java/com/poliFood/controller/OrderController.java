package com.poliFood.controller;

import com.poliFood.model.MenuElement;
import com.poliFood.model.MenuElementQuantity;
import com.poliFood.model.Order;
import com.poliFood.projection.OrderView;
import com.poliFood.service.MenuElementQuantityService;
import com.poliFood.service.MenuElementService;
import com.poliFood.service.OrderService;
import com.poliFood.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

@RestController
@RequestMapping(path="/order")
public class OrderController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private UserService userService;
    @Autowired
    private MenuElementService menuElementService;
    @Autowired
    private MenuElementQuantityService menuElementQuantityService;

    @GetMapping(path = "getAll")
    public List<OrderView> getAll(){
        return orderService.getAllOrders();
    }

    @PostMapping(path = "newOrder/{id}/{time}")
    public void addNewOrder(@PathVariable Long id, @PathVariable String time){
        Order order = new Order();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        order.setDate(date);
        order.setTime(LocalTime.parse(time));
        order.setMenuElement(menuElementService.findById(id));
        order.setQuantity(1);
        order.setUser(userService.findByEmail(userService.getCurrentUserEmail()));
        orderService.save(order);
        userService.findByEmail(userService.getCurrentUserEmail()).getOrders().add(order);
    }
}
