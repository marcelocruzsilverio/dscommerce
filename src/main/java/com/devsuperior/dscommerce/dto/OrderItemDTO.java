package com.devsuperior.dscommerce.dto;

import com.devsuperior.dscommerce.entities.OrderItem;

public class OrderItemDTO {
    private Long productId;
    private String name;
    private Integer quantity;
    private Double price;
    private String imageURL;

    public OrderItemDTO(Long productId, String name, Integer quantity, Double price, String imageURL) {
        this.productId = productId;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.imageURL = imageURL;
    }

    public OrderItemDTO(OrderItem entity) {
        productId = entity.getProduct().getId();
        name = entity.getProduct().getName();
        quantity = entity.getQuantity();
        price = entity.getPrice();
        imageURL = entity.getProduct().getImgUrl();
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
    public String getImageURL() {
        return imageURL;
    }
}
