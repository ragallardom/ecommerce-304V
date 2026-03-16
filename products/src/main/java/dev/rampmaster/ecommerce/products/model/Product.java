package dev.rampmaster.ecommerce.products.model;

import java.math.BigDecimal;

public class Product {

    private Long id;
    private String name;
    private String category;
    private BigDecimal price;
    private boolean active;

    public Product() {
    }

    public Product(Long id, String name, String category, BigDecimal price, boolean active) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
        this.active = active;
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}

