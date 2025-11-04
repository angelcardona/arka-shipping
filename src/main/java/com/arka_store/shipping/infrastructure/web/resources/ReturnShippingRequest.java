package com.arka_store.shipping.infrastructure.web.resources;

import com.arka_store.shipping.domain.ShippingItem;
import lombok.Builder;
import lombok.Data;

import java.util.List;
@Data
@Builder
public class ReturnShippingRequest{
    private String userId;
    private String orderId;
    private String userEmail;
    private String reason;
    private List<ShippingItem> items;

}
