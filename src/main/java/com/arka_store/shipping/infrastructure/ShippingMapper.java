package com.arka_store.shipping.infrastructure;

import com.arka_store.shipping.domain.Shipping;
import com.arka_store.shipping.domain.ShippingStatus;
import com.arka_store.shipping.infrastructure.persistence.entities.ShippingEntity;
import org.springframework.stereotype.Component;

@Component
public class ShippingMapper {

    public Shipping entityToDomain(ShippingEntity shippingEntity){
        Shipping  shipping= new Shipping();
        shipping.setId(shippingEntity.getId());
        shipping.setOrderId(shippingEntity.getOrderId());
        shipping.setUserId(shippingEntity.getUserId());
        shipping.setShippingAddress(shippingEntity.getShippingAddress());
        shipping.setCreateAt(shippingEntity.getCreateAt());
        shipping.setSendingAt(shippingEntity.getSendingAt());
        shipping.setReceivedAt(shippingEntity.getReceivedAt());
        shipping.setRejectedAt(shippingEntity.getRejectedAt());
        shipping.setTimeInferenceToArrived(shippingEntity.getTimeInferenceToArrived());
        shipping.setStatus(ShippingStatus.valueOf(shippingEntity.getStatus().toString()));

        return shipping;
    }
    public ShippingEntity domainToEntity(Shipping shipping){
        ShippingEntity shippingEntity=new ShippingEntity();
        shippingEntity.setId(shipping.getId());
        shippingEntity.setOrderId(shipping.getOrderId());
        shippingEntity.setUserId(shipping.getUserId());
        shippingEntity.setShippingAddress(shipping.getShippingAddress());
        shippingEntity.setTimeInferenceToArrived(shipping.getTimeInferenceToArrived());
        shippingEntity.setCreateAt(shipping.getCreateAt());
        shippingEntity.setSendingAt(shipping.getSendingAt());
        shippingEntity.setReceivedAt(shipping.getReceivedAt());
        shippingEntity.setRejectedAt(shipping.getRejectedAt());
        shippingEntity.setStatus(shipping.getStatus());

        return shippingEntity;
    }
}
