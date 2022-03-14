package com.poliFood.dto;

import com.poliFood.model.Cafeteria;

import java.util.List;

public class MenuDTO {
    private Long id;
    private Cafeteria cafeteria;
    private String day;
    private List<MenuElementDTO> menuElements;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cafeteria getCafeteria() {
        return cafeteria;
    }

    public void setCafeteria(Cafeteria cafeteria) {
        this.cafeteria = cafeteria;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public List<MenuElementDTO> getMenuElements() {
        return menuElements;
    }

    public void setMenuElements(List<MenuElementDTO> menuElements) {
        this.menuElements = menuElements;
    }
}
