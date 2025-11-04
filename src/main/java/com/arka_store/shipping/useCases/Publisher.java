package com.arka_store.shipping.useCases;

import com.arka_store.shipping.domain.events.ShippingSendEvent;

public interface Publisher {
    void ShippingSendEvent(ShippingSendEvent event);
}
