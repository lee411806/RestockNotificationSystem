package com.sparta.restocknotificationsystem.notification.product_user_notification;

import com.sparta.restocknotificationsystem.entity.ProductUserNotification;
import com.sparta.restocknotificationsystem.entity.ProductUserNotificationHistory;
import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Product_user_notification_repository extends JpaRepository<ProductUserNotification, Id> {

    @Query("SELECT p FROM ProductUserNotification p WHERE p.product.productId = :productId AND p.isActive = true ORDER BY p.createdAt ASC")
    List<ProductUserNotification> findActiveByProductId(Long productId);


}
