package com.sparta.restocknotificationsystem.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "product_notification_history", indexes = {
        @Index(name = "idx_product_id_restock_count", columnList = "product_id, restock_count")
})
public class ProductNotificationHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @Column(name = "restock_count", nullable = false)
    private Integer restockCount;

    @Enumerated(EnumType.STRING)
    @Column(name = "notification_status", nullable = false)
    private NotificationStatus notificationStatus;

    @Column(name = "last_sent_user_id")
    private Long lastSentUserId;

    // Getters and Setters
}

enum NotificationStatus {
    IN_PROGRESS, CANCELED_BY_SOLD_OUT, CANCELED_BY_ERROR, COMPLETED
}
