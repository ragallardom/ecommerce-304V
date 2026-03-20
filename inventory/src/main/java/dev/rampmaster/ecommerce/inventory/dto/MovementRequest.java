package dev.rampmaster.ecommerce.inventory.dto;


import lombok.Data;

@Data
public class MovementRequest {
    private Integer quantity;
    private String reason;
}
