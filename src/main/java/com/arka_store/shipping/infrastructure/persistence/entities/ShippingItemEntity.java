package com.arka_store.shipping.infrastructure.persistence.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class ShippingItemEntity {


    private Long itemId;
    private Long productId;
    private String productName;
    private Integer quantity;
}
