package com.poliFood.projection;

import java.time.DayOfWeek;
import java.util.List;

public interface MenuView {
    Long getId();
    List<MenuElementView> getMenuElements();
    DayOfWeek getDay();
}
