package jpabook.jpashop_ex.repository;

import jpabook.jpashop_ex.domain.Address;
import jpabook.jpashop_ex.domain.Order;
import jpabook.jpashop_ex.domain.OrderStatus;
import lombok.Data;

import java.time.LocalDateTime;
@Data

public class OrderSimpleQueryDto {
    private Long orderId;
    private String name;
    private LocalDateTime orderDate;
    private OrderStatus orderStatus;
    private Address address;

    public OrderSimpleQueryDto(Long orderId, String name, LocalDateTime orderDate, OrderStatus orderStatus, Address address) {
        this.orderId = orderId;
        this.name = name; // LAZY 초기화
        this.orderStatus = orderStatus;
        this.orderDate = orderDate;
        this.address = address; // LAZY 초기화
    }
}
