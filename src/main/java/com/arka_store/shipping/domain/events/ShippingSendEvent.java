package com.arka_store.shipping.domain.events;

import lombok.Getter;

import java.util.UUID;

@Getter
public class ShippingSendEvent {
    private String id= UUID.randomUUID().toString();
    private String userId;
    private String userEmail;
    private String timeEstimateToArrive;

    public ShippingSendEvent(String userEmail, String userId,String timeEstimateToArrive) {
        this.userEmail = userEmail;
        this.userId = userId;
        this.timeEstimateToArrive=timeEstimateToArrive;
    }
}
