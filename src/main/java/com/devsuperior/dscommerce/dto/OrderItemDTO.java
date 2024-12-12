package com.devsuperior.dscommerce.dto;

import com.devsuperior.dscommerce.entities.OrderItem;

public class OrderItemDTO {
    private Long productId;
    private String name;
    private Integer quantity;
    private Double price;

    public OrderItemDTO(Long productId, String name, Integer quantity, Double price) {
        this.productId = productId;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    public OrderItemDTO(OrderItem entity) {
        this.productId = entity.getProduct().getId();
        this.name = entity.getProduct().getName();
        this.quantity = entity.getQuantity();
        this.price = entity.getPrice();
    }

    public Long getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public Double getPrice() {
        return price;
    }

    public double getSubtotal() {
        return quantity * price;
    }
}
