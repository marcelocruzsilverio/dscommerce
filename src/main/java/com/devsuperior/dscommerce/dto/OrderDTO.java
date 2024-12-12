package com.devsuperior.dscommerce.dto;

import com.devsuperior.dscommerce.entities.Order;
import com.devsuperior.dscommerce.entities.OrderItem;
import com.devsuperior.dscommerce.entities.OrderStatus;
import jakarta.validation.constraints.NotEmpty;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class OrderDTO {
    private Long id;
    private OrderStatus status;
    private Instant moment;

    private ClientDTO client;

    private PaymentDTO payment;

    @NotEmpty(message = "Deve ter pelo meno um item")
    private List<OrderItemDTO> items = new ArrayList<>();

    public OrderDTO(Long id, OrderStatus status, Instant moment, ClientDTO client, PaymentDTO payment) {
        this.id = id;
        this.status = status;
        this.moment = moment;
        this.client = client;
        this.payment = payment;
    }

    public OrderDTO(Order entity) {
        id = entity.getId();
        status = entity.getStatus();
        moment = entity.getMoment();
        client = new ClientDTO(entity.getClient());
        payment = (entity.getPayment() != null) ? new PaymentDTO(entity.getPayment()) : null;

        for (OrderItem item : entity.getItems()) {
            items.add(new OrderItemDTO(item));
        }
    }

    public Long getId() {
        return id;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public Instant getMoment() {
        return moment;
    }

    public ClientDTO getClient() {
        return client;
    }

    public PaymentDTO getPayment() {
        return payment;
    }

    public List<OrderItemDTO> getItems() {
        return items;
    }

    public double getTotal() {
        double sum = 0;
        for (OrderItemDTO item : items) {
            sum += item.getSubtotal();
        }
        return sum;
    }
}
