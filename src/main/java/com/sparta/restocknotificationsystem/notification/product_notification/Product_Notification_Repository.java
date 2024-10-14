package com.sparta.restocknotificationsystem.notification.product_notification;

import com.sparta.restocknotificationsystem.entity.ProductNotificationHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Product_Notification_Repository extends JpaRepository<ProductNotificationHistory, Long> {
}
