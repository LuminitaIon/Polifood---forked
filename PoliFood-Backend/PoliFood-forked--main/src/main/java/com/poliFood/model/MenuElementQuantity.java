package com.poliFood.model;

import org.aspectj.weaver.ast.Or;

import javax.persistence.*;

@Entity
@Table
public class MenuElementQuantity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "menu_element_quntity_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "menu_element_id")
    private MenuElement menuElement;

    @Column
    private Integer quantity;

    @ManyToOne()
    @JoinColumn(name="order_id")
    private Order order;

    public MenuElementQuantity(){
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public MenuElement getMenuElement() {
        return menuElement;
    }

    public void setMenuElement(MenuElement menuElement) {
        this.menuElement = menuElement;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
