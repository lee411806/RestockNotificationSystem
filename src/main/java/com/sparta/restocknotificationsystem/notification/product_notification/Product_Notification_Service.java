package com.sparta.restocknotificationsystem.notification.product_notification;

import com.sparta.restocknotificationsystem.enums.NotificationStatus;
import com.sparta.restocknotificationsystem.entity.Product;
import com.sparta.restocknotificationsystem.entity.ProductNotificationHistory;
import com.sparta.restocknotificationsystem.enums.StockStatus;
import com.sparta.restocknotificationsystem.notification.product_user_notification.Product_user_notification_service;
import com.sparta.restocknotificationsystem.product.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class Product_Notification_Service {


    private final ProductService productService;
    private final Product_user_notification_service product_user_notification_service;

    private final Product_Notification_Repository product_Notification_Repository;


    // 재입고 알림 전송 로직
    public String sendNotifications(Long productId) {

        // 로그 추가: productId가 null인지 확인
        if (productId == null) {
            System.out.println("Error: productId is null");
            throw new IllegalArgumentException("Product ID cannot be null");
        }


        // 1. 재입고 회차 증가
        Product product = productService.increaseRestockCount(productId);
        //product 잘들어옴
        System.out.println("product = " + product);



        // 2. 재고 확인: 재고가 없다면 알림 중단
        if (product.getStockStatus() == StockStatus.OUT_OF_STOCK) {
            return "Product is out of stock.";
        }

        // 3. 알림 상태 IN_PROGRESS로 설정 후 이력 저장
        // ProductNotificationHistory는 productId를 받는게 아니라 Product자체를 받음
        ProductNotificationHistory notificationHistory = new ProductNotificationHistory(product, product.getRestockCount(), NotificationStatus.IN_PROGRESS);
        product_Notification_Repository.save(notificationHistory);

        // 4. 유저 알림 전송
        String result = product_user_notification_service.notifyUsers(product, notificationHistory);

        return result;
    }
}
