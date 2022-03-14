package com.poliFood.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "menu_elements")
public class MenuElement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "menu_element_id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "unit_price")
    private Float unitPrice;

    @Column(name = "unit_value")
    private Float unitValue;

    @Column(name = "unit_type")
    private String unitType;

    @Column(name = "image_url")
    private String imageURL;

//    @ManyToOne
//    @JoinColumn(name = "cafeteria_id")
//    private Cafeteria cafeteria;

    @ManyToMany(mappedBy = "menuElements")
    private Set<Menu> menus = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "type_id")
    private MenuElementType type;

    @OneToMany(mappedBy = "menuElement")
    private Set<Order> orders = new HashSet<>();

    public MenuElement() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Float unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Float getUnitValue() {
        return unitValue;
    }

    public void setUnitValue(Float unitValue) {
        this.unitValue = unitValue;
    }

    public String getUnitType() {
        return unitType;
    }

    public void setUnitType(String unitType) {
        this.unitType = unitType;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

//    public Cafeteria getCafeteria() {
//        return cafeteria;
//    }
//
//    public void setCafeteria(Cafeteria cafeteria) {
//        this.cafeteria = cafeteria;
//    }

    public Set<Menu> getMenus() {
        return menus;
    }

    public void setMenus(Set<Menu> menus) {
        this.menus = menus;
    }

    public MenuElementType getType() {
        return type;
    }

    public void setType(MenuElementType type) {
        this.type = type;
    }

    public Set<Order> getOrders() {
        return orders;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }
}
