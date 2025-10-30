package com.arka_store.shipping.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShippingItem {
    private Long itemId;
    private Long productId;
    private Integer quantity;
}
