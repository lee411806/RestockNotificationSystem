package com.sparta.restocknotificationsystem.notification.product_notification;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class Product_Notification_Controller {


    private final Product_Notification_Service product_notification_service;

    @PostMapping("/products/{productId}/notifications/re-stock")
    public void reStock(@PathVariable("productId") Long productId) {
        product_notification_service.sendNotifications(productId);
    }


}
