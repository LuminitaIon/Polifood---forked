package com.poliFood.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "cafeterias")
public class Cafeteria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name  = "cafeteria_id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "location")
    private String location;

    @Column(name = "schedule")
    private String schedule;

    @OneToMany(mappedBy = "cafeteria", cascade = CascadeType.PERSIST)
    private Set<Menu> menus = new HashSet<>();

    @OneToMany()
    private Set<User> users;


    public Cafeteria() {
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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

//    public Set<MenuElement> getMenuElements() {
//        return menuElements;
//    }
//
//    public void setMenuElements(Set<MenuElement> menuElements) {
//        this.menuElements = menuElements;
//    }

    public Set<Menu> getMenus() {
        return menus;
    }

    public void setMenus(Set<Menu> menus) {
        this.menus = menus;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }


}
