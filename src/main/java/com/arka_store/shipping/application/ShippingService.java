package com.arka_store.shipping.application;

import com.arka_store.shipping.domain.Shipping;
import com.arka_store.shipping.domain.utils.RandomShippingDateGenerator;
import com.arka_store.shipping.infrastructure.web.resources.ReturnShippingRequest;
import com.arka_store.shipping.infrastructure.web.resources.ShippingRequest;
import com.arka_store.shipping.useCases.ShippingUsesCases;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class ShippingService {
    private  final ShippingUsesCases usesCases;

    public Shipping createShipping(ShippingRequest request){

        Shipping shipping=new Shipping(request.orderId(), request.userId(),request.items());
        return usesCases.save(shipping);
    }
    public StringBuilder sendShipping(UUID id,String address){
        Shipping shipping=getById(id);
        LocalDateTime sendingAt=LocalDateTime.now();
        String estimateArrived= RandomShippingDateGenerator.generateAleatoryDate();
        shipping.setShippingAddress(address);
        shipping.setTimeInferenceToArrived(estimateArrived);
        shipping.setSendingAt(sendingAt);
        shipping.switchToSend();
        usesCases.save(shipping);
        StringBuilder response=new StringBuilder("Shipping was Sending for "+shipping.getUserId());
        response.append("Time calculated To arrived").append(shipping.getTimeInferenceToArrived());
        return response;
    }
    public Shipping getById(UUID id){
        return usesCases.findById(id);
    }
    public void arrivedShipping(UUID id){
        LocalDateTime arrivedAt=LocalDateTime.now();
        Shipping shipping=getById(id);
        shipping.switchToArrived();
        shipping.setReceivedAt(arrivedAt);
    }
    public void returnShipping(UUID id){
        Shipping shipping=getById(id);
        ReturnShippingRequest request=new ReturnShippingRequest()
    }
    private ReturnShippingRequest buildShippingRequest(Shipping shipping){
        return new ReturnShippingRequest(
                shipping.getUserId(),
                shipping.getOrderId(),
                shipping.get
        )
    }

}

void arrivedShipping(UUID id);
void returnShipping(UUID id);

Shipping getById(UUID id);
List<Shipping> getAllShippingByUserId(UUID userId);
List<Shipping> getAllShipping();