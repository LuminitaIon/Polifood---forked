package com.poliFood.model;

import javax.persistence.*;
import java.time.LocalTime;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column
    private Date date;

    @Column
    private LocalTime time;

//    @ManyToMany
//    @JoinTable(
//            name = "order_menu_element",
//            joinColumns = { @JoinColumn(name = "order_id") },
//            inverseJoinColumns = { @JoinColumn(name = "menu_element_id") }
//    )
//    private Set<MenuElement> menuElements;
//
    @ManyToOne
    @JoinColumn(name="menu_element_id")
    private MenuElement menuElement;

    @Column(name = "quantity")
    private Integer quantity;

//    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
//    private Set<MenuElementQuantity> menuElementsQuantity = new HashSet<>();

    public Order(){
    }
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

//    public Set<MenuElement> getMenuElements() {
//        return menuElements;
//    }
//
//    public void setMenuElements(Set<MenuElement> menuElements) {
//        this.menuElements = menuElements;
//    }

//    public Set<Integer> getQuantity() {
//        return quantity;
//    }
//
//    public void setQuantity(Set<Integer> quantity) {
//        this.quantity = quantity;
//    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

//    public Set<MenuElementQuantity> getMenuElementsQuantity() {
//        return menuElementsQuantity;
//    }
//
//    public void setMenuElementsQuantity(Set<MenuElementQuantity> menuElementsQuantity) {
//        this.menuElementsQuantity = menuElementsQuantity;
//    }

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
}
