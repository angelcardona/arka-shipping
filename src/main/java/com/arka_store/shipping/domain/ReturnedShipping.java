package com.arka_store.shipping.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
public class ReturnedShipping {
    private UUID id=UUID.randomUUID();
    private String reason;
    private List<ShippingItem>items;
    private LocalDateTime returnedAt;

    public ReturnedShipping(String reason, List<ShippingItem> items) {
        this.reason = reason;
        this.items = items;
    }
}
