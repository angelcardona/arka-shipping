package com.arka_store.shipping.infrastructure.web.controllers;

import com.arka_store.shipping.application.ShippingService;
import com.arka_store.shipping.domain.Shipping;
import com.arka_store.shipping.infrastructure.web.resources.ShippingRequest;
import com.arka_store.shipping.infrastructure.web.resources.ShippingResponse;
import com.arka_store.shipping.infrastructure.web.resources.ShippingReturnsReason;
import com.arka_store.shipping.infrastructure.web.resources.UserInfoForShipping;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping("/shipping")
@RequiredArgsConstructor

public class ShippingController {
    private final ShippingService service;

    @PostMapping
    public ResponseEntity<Shipping> createShipping(@RequestBody ShippingRequest request){
        Shipping shipping=service.createShipping(request);
        return ResponseEntity.ok(shipping);
    }
    @PostMapping("/send/{shippingId}")
    public ResponseEntity<ShippingResponse> sendShipping(
            @PathVariable("shippingId") UUID shippingId,
            @RequestBody UserInfoForShipping infoForShipping){
        StringBuilder message=service.sendShipping(shippingId,infoForShipping.address(),infoForShipping.userEmail());
        ShippingResponse response=new ShippingResponse(message);
        return ResponseEntity.ok(response);
    }
    @PutMapping("/arrived/{shippingId}")
    public ResponseEntity<ShippingResponse> arrivedShipping(@PathVariable("shippingId") UUID shippingId){
        service.arrivedShipping(shippingId);
        StringBuilder message=new StringBuilder("The User Received the Shipping Successfully");
        ShippingResponse response=new ShippingResponse(message);
        return ResponseEntity.ok(response);
    }
    @PostMapping("/return/{shippingId}")
    public ResponseEntity<ShippingResponse> returnShipping(
            @PathVariable("shippingId")UUID shippingId,
            @RequestBody ShippingReturnsReason shippingReturnsReason){
        service.returnShipping(shippingId,shippingReturnsReason.reason());
        StringBuilder message=new StringBuilder("The Shipping was Returned Successfully");
        ShippingResponse response=new ShippingResponse(message);
        return ResponseEntity.ok(response);
    }
    @GetMapping
    public ResponseEntity<List<Shipping>> getAll(){
        List<Shipping> shippingList=service.getAllShipping();
        return ResponseEntity.ok(shippingList);
    }





}
