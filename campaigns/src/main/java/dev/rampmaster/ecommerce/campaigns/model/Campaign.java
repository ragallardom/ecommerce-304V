package dev.rampmaster.ecommerce.campaigns.model;

public class Campaign {

    private Long id;
    private String code;
    private Integer discountPercent;
    private boolean active;

    public Campaign() {
    }

    public Campaign(Long id, String code, Integer discountPercent, boolean active) {
        this.id = id;
        this.code = code;
        this.discountPercent = discountPercent;
        this.active = active;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getDiscountPercent() {
        return discountPercent;
    }

    public void setDiscountPercent(Integer discountPercent) {
        this.discountPercent = discountPercent;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}

