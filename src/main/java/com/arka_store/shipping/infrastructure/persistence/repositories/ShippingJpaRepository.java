package com.arka_store.shipping.infrastructure.persistence.repositories;

import com.arka_store.shipping.domain.Shipping;
import com.arka_store.shipping.infrastructure.persistence.entities.ShippingEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ShippingJpaRepository extends JpaRepository<ShippingEntity, UUID> {
    List<ShippingEntity> findAllByUserId(String userId);
}
