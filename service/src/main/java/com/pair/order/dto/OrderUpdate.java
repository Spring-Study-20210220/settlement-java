package com.pair.order.dto;

import com.pair.order.OrderStatus;
import com.pair.order.OrderTable;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class OrderUpdate {

    private Long id;
    private Long ownerId;
    private int totalPrice;
    private String status;
    private LocalDateTime createdAt;
    private List<OrderDetailUpdate> details;

    @Builder
    public OrderUpdate(Long id, Long ownerId, int totalPrice, String status, LocalDateTime createdAt, List<OrderDetailUpdate> details) {
        this.id = id;
        this.ownerId = ownerId;
        this.totalPrice = totalPrice;
        this.status = status;
        this.createdAt = createdAt;
        this.details = details;
    }

    public OrderTable toOrderEntity() {
        return OrderTable.builder()
                .totalPrice(totalPrice)
                .status(OrderStatus.valueOf(status))
                .createdAt(createdAt)
                .id(id)
                .build();
    }
}
