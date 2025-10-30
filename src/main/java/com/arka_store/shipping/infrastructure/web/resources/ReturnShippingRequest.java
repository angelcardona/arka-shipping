package com.arka_store.shipping.infrastructure.web.resources;

import com.arka_store.shipping.domain.ShippingItem;

import java.util.List;

public record ReturnShippingRequest(
        String userId,
        String orderId,
        String userEmail,
        String reason,
        List<ShippingItem> items
) {
}
