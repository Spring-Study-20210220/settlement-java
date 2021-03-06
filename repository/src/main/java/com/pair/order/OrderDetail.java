package com.pair.order;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class OrderDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "orderTableId")
    private OrderTable orderTable;

    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod;

    private int price;

    @Builder
    public OrderDetail(Long id, OrderTable orderTable, PaymentMethod paymentMethod, int price) {
        this.orderTable = orderTable;
        this.paymentMethod = paymentMethod;
        this.price = price;
        this.id = id;
    }

    public void setOrder(OrderTable orderTable) {
        this.orderTable = orderTable;
    }
}

