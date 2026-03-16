package dev.rampmaster.ecommerce.shipping.model;

public class Shipment {

    private Long id;
    private Long orderId;
    private String carrier;
    private String status;

    public Shipment() {
    }

    public Shipment(Long id, Long orderId, String carrier, String status) {
        this.id = id;
        this.orderId = orderId;
        this.carrier = carrier;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getCarrier() {
        return carrier;
    }

    public void setCarrier(String carrier) {
        this.carrier = carrier;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

