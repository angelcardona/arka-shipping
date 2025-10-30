package com.arka_store.shipping.infrastructure.persistence.entities;

import com.arka_store.shipping.domain.ShippingItem;
import com.arka_store.shipping.domain.ShippingStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "shipping")
public class ShippingEntity {
    @Id
    private UUID id;
    private String orderId;
    private String userId;
    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(
            name = "shipping_items",
            joinColumns = @JoinColumn(name = "shipping_id")
    )
    private List<ShippingItem> items;
    private LocalDateTime createAt;
    @Enumerated(EnumType.STRING)
    private ShippingStatus status=ShippingStatus.PACKING;
    private String shippingAddress;
    private LocalDateTime sendingAt;
    private String timeInferenceToArrived;
    private LocalDateTime receivedAt;
    private LocalDateTime rejectedAt;
}
