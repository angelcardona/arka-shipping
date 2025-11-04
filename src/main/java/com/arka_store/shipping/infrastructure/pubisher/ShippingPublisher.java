package com.arka_store.shipping.infrastructure.pubisher;

import com.arka_store.shipping.domain.events.ShippingSendEvent;
import com.arka_store.shipping.useCases.Publisher;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class ShippingPublisher implements Publisher {
    private final StreamBridge streamBridge;
    @Override
    public void ShippingSendEvent(ShippingSendEvent event) {
        final String BINDING_NAME = "shippingSendEventListener-out-0";
        boolean success = streamBridge.send(BINDING_NAME, event);

        if (success) {
            log.info(" Event Shipping Send Publisher: {}", event.getId());
        } else {
            log.error(" Critical Error publishing event: {}", event.getId());
            throw new RuntimeException("Fatal Error.");
        }

    }
}
