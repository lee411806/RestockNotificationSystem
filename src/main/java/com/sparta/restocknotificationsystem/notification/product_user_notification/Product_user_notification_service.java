package com.sparta.restocknotificationsystem.notification.product_user_notification;

import com.sparta.restocknotificationsystem.entity.Product;
import com.sparta.restocknotificationsystem.entity.ProductNotificationHistory;
import com.sparta.restocknotificationsystem.entity.ProductUserNotification;
import com.sparta.restocknotificationsystem.entity.ProductUserNotificationHistory;
import com.sparta.restocknotificationsystem.enums.NotificationStatus;
import com.sparta.restocknotificationsystem.enums.StockStatus;
import com.sparta.restocknotificationsystem.notification.product_notification.Product_Notification_Repository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class Product_user_notification_service {

    private Product_user_notification_repository product_user_notification_repository;

    private Product_Notification_Repository product_notification_repository;

    public String notifyUsers(Product product, ProductNotificationHistory notificationHistory) {
        // 1. 상품에 대해 알림 설정한 유저 목록 조회
        List<ProductUserNotification> notifications = product_user_notification_repository.findActiveByProductId(product.getProductId());

        // 2. 유저별로 알림을 순차적으로 전송
        for (ProductUserNotification notification : notifications) {
            // 3. 재고 소진 확인: 재고가 없으면 알림 중단
            if (product.getStockStatus() == StockStatus.OUT_OF_STOCK) {
                notificationHistory.setNotificationStatus(NotificationStatus.CANCELED_BY_SOLD_OUT);
                product_notification_repository.save(notificationHistory);
                return "Notification stopped: Out of stock";
            }

            // 4. 실제 알림 전송 로직 (가정)
            // 여기서 실제로 메시지를 보내는 코드가 들어갑니다.
            System.out.println("Sending notification to user " + notification.getUserId());

            // 5. 알림 발송 이력 기록
            ProductUserNotificationHistory userNotificationHistory = new ProductUserNotificationHistory(
                    product.getProductId(), notification.getUserId(), product.getRestockCount());
            product_user_notification_repository.saveHistory(userNotificationHistory);

        }


        // 6. 알림 발송 완료
        notificationHistory.setNotificationStatus(NotificationStatus.COMPLETED);
        product_notification_repository.save(notificationHistory);

        return "Notifications sent successfully.";
    }
}
