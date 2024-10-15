package com.sparta.restocknotificationsystem.entity;

import com.sparta.restocknotificationsystem.enums.NotificationStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "product_notification_history", indexes = {
        @Index(name = "idx_product_id_restock_count", columnList = "product_id, restock_count")
})
@NoArgsConstructor
@Getter
@Setter
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

    public ProductNotificationHistory(Product product, Integer restockCount, NotificationStatus notificationStatus) {
        this.product = product;
        this.restockCount = restockCount;
        this.notificationStatus = notificationStatus;
    }

    // Getters and Setters
}

