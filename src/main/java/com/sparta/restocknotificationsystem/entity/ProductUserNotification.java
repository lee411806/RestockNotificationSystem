package com.sparta.restocknotificationsystem.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "product_user_notification", indexes = {
        @Index(name = "idx_product_id_user_id", columnList = "product_id, user_id")
})
public class ProductUserNotification extends Timestamp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Column(name = "is_active", nullable = false)
    private Boolean isActive = true;

}
