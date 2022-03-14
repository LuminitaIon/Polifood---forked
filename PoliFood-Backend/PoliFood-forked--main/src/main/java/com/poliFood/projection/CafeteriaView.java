package com.poliFood.projection;


import java.util.List;

public interface CafeteriaView {
    Long getId();
    String getName();
    String getLocation();
    String getSchedule();
    List<MenuView> getMenus();
}
