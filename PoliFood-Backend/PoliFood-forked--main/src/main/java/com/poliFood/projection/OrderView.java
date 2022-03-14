package com.poliFood.projection;

import com.poliFood.model.MenuElementQuantity;

import java.time.LocalTime;
import java.util.Date;
import java.util.List;

public interface OrderView {
    Long getId();
    Date getDate();
    LocalTime getTime();
    MenuElementView getMenuElement();
    Integer getQuantity();
}
