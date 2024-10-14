package com.sparta.restocknotificationsystem.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "product_user_notification_history", indexes = {
        @Index(name = "idx_product_user_notification", columnList = "product_id, user_id, restock_count")
})
public class ProductUserNotificationHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Column(name = "restock_count", nullable = false)
    private Integer restockCount;

    @Column(name = "sent_at", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date sentAt = new Date();

    // Getters and Setters
}
