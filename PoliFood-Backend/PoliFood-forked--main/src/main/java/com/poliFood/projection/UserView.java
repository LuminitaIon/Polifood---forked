package com.poliFood.projection;

import com.poliFood.model.Role;

import java.util.List;

public interface UserView {
    Long getId();
    String getFirstName();
    String getLastName();
    RoleView getRole();
    String getEmail();
    List<OrderView> getOrders();
}
