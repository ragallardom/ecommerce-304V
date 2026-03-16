package dev.rampmaster.ecommerce.orders.model;

import java.math.BigDecimal;

public class SalesOrder {

    private Long id;
    private Long userId;
    private String status;
    private BigDecimal total;

    public SalesOrder() {
    }

    public SalesOrder(Long id, Long userId, String status, BigDecimal total) {
        this.id = id;
        this.userId = userId;
        this.status = status;
        this.total = total;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }
}

