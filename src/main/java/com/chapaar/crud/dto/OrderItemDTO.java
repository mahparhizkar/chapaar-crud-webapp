package com.chapaar.crud.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderItemDTO {

    private long orderId;
    private String customerName;
    private String productName;
    private double price;
    private int productCount;
    private double totalPrice;
}
