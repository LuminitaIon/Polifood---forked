package com.poliFood.dto;

public class MenuElementDTO {
    private Long id;

    private String name;

    private Float unitPrice;

    private Float unitValue;

    private String unitType;

    private String imageURL;

    private Long menuElementTypeId;

    private String menuElementNameId;

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

    public Long getMenuElementTypeId() {
        return menuElementTypeId;
    }

    public void setMenuElementTypeId(Long menuElementTypeId) {
        this.menuElementTypeId = menuElementTypeId;
    }

    public String getMenuElementNameId() {
        return menuElementNameId;
    }

    public void setMenuElementNameId(String menuElementNameId) {
        this.menuElementNameId = menuElementNameId;
    }
}
