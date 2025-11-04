package com.arka_store.shipping.infrastructure;

import com.arka_store.shipping.domain.Shipping;
import com.arka_store.shipping.domain.ShippingItem;
import com.arka_store.shipping.domain.ShippingStatus;
import com.arka_store.shipping.infrastructure.persistence.entities.ShippingEntity;
import com.arka_store.shipping.infrastructure.persistence.entities.ShippingItemEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ShippingMapper {

    public Shipping entityToDomain(ShippingEntity shippingEntity) {
        List<ShippingItem> items = shippingEntity.getItems().stream()
                .map(this::itemEntityToDomain).toList();
        Shipping shipping = new Shipping();
        shipping.setId(shippingEntity.getId());
        shipping.setOrderId(shippingEntity.getOrderId());
        shipping.setUserId(shippingEntity.getUserId());
        shipping.setUserEmail(shippingEntity.getUserEmail());
        shipping.setItems(items);
        shipping.setShippingAddress(shippingEntity.getShippingAddress());
        shipping.setCreateAt(shippingEntity.getCreateAt());
        shipping.setSendingAt(shippingEntity.getSendingAt());
        shipping.setReceivedAt(shippingEntity.getReceivedAt());
        shipping.setRejectedAt(shippingEntity.getRejectedAt());
        shipping.setTimeInferenceToArrived(shippingEntity.getTimeInferenceToArrived());
        shipping.setStatus(ShippingStatus.valueOf(shippingEntity.getStatus().toString()));


        return shipping;
    }

    public ShippingEntity domainToEntity(Shipping shipping) {
        List<ShippingItemEntity>items=shipping.getItems().stream()
                .map(this::itemToEntity).toList();
        ShippingEntity shippingEntity = new ShippingEntity();
        shippingEntity.setId(shipping.getId());
        shippingEntity.setOrderId(shipping.getOrderId());
        shippingEntity.setUserId(shipping.getUserId());
        shippingEntity.setUserEmail(shipping.getUserEmail());
        shippingEntity.setItems(items);
        shippingEntity.setShippingAddress(shipping.getShippingAddress());
        shippingEntity.setTimeInferenceToArrived(shipping.getTimeInferenceToArrived());
        shippingEntity.setCreateAt(shipping.getCreateAt());
        shippingEntity.setSendingAt(shipping.getSendingAt());
        shippingEntity.setReceivedAt(shipping.getReceivedAt());
        shippingEntity.setRejectedAt(shipping.getRejectedAt());
        shippingEntity.setStatus(shipping.getStatus());


        return shippingEntity;
    }

    private ShippingItem itemEntityToDomain(ShippingItemEntity item) {
        return new ShippingItem(
                item.getItemId(),
                item.getProductId(),
                item.getQuantity()
        );
    }

    private ShippingItemEntity itemToEntity(ShippingItem item) {
        return new ShippingItemEntity(
                item.getItemId(),
                item.getProductId(),
                item.getQuantity()
        );
    }
}
