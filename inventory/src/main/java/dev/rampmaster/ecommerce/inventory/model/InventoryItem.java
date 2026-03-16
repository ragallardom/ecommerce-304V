package dev.rampmaster.ecommerce.inventory.model;

public class InventoryItem {

    private Long id;
    private Long productId;
    private Integer quantity;
    private String warehouseCode;

    public InventoryItem() {
    }

    public InventoryItem(Long id, Long productId, Integer quantity, String warehouseCode) {
        this.id = id;
        this.productId = productId;
        this.quantity = quantity;
        this.warehouseCode = warehouseCode;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getWarehouseCode() {
        return warehouseCode;
    }

    public void setWarehouseCode(String warehouseCode) {
        this.warehouseCode = warehouseCode;
    }
}

