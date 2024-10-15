package com.sparta.restocknotificationsystem.notification.product_user_notification;

import com.sparta.restocknotificationsystem.entity.ProductUserNotificationHistory;
import org.hibernate.sql.ast.tree.expression.JdbcParameter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Product_user_Notification_history_repository extends JpaRepository<ProductUserNotificationHistory,Long> {
}
