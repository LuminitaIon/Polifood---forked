package com.poliFood.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "menu_element_types")
public class MenuElementType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "menu_element_type_id")
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "type")
    private Set<MenuElement> menuElements = new HashSet<>();

    public MenuElementType() {
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

    public Set<MenuElement> getMenuElements() {
        return menuElements;
    }

    public void setMenuElements(Set<MenuElement> menuElements) {
        this.menuElements = menuElements;
    }
}
