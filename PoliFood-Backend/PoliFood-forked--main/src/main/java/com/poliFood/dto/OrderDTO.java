package com.poliFood.dto;

import com.poliFood.model.User;

import java.util.Date;
import java.util.List;

public class OrderDTO {
    private Long id;

    private User user;

    private Date date;

    private Integer quantity;

    private List<MenuElementDTO>  menuElements;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public List<MenuElementDTO> getMenuElements() {
        return menuElements;
    }

    public void setMenuElements(List<MenuElementDTO> menuElements) {
        this.menuElements = menuElements;
    }
}
