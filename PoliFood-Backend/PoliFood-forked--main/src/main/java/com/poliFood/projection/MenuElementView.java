package com.poliFood.projection;

public interface MenuElementView {
    Long getId();
    String getName();
    Float getUnitPrice();
    Float getUnitValue();
    String getUnitType();
    String getImageURL();
    MenuElementTypeView getType();
}
