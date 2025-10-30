package com.arka_store.shipping.infrastructure.web.resources;

import com.arka_store.shipping.domain.ShippingItem;

import java.util.List;

public record ShippingRequest(String orderId,
                              String userId,
                              List<ShippingItem> items
                              ){
}
