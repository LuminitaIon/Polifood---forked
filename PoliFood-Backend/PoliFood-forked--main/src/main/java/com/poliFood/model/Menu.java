package com.poliFood.model;

import javax.persistence.*;
import java.time.DayOfWeek;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "menus")
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "menu_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cafeteria_id")
    private Cafeteria cafeteria;

    @ManyToMany
    @JoinTable(
            name = "menu_menu_element",
            joinColumns = { @JoinColumn(name = "menu_id") },
            inverseJoinColumns = { @JoinColumn(name = "menu_element_id") }
    )
    private Set<MenuElement> menuElements = new HashSet<>();

//    @ManyToOne(cascade = CascadeType.PERSIST)
//    @JoinColumn(name = "day_id")
//    private Day day;
    @Column
    private DayOfWeek day;

    public Menu() {
    }

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

    public Set<MenuElement> getMenuElements() {
        return menuElements;
    }

    public void setMenuElements(Set<MenuElement> menuElements) {
        this.menuElements = menuElements;
    }

    public DayOfWeek getDay() {
        return day;
    }

    public void setDay(DayOfWeek day) {
        this.day = day;
    }
}
