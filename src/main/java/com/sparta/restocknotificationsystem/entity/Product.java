package com.sparta.restocknotificationsystem.entity;

import com.sparta.restocknotificationsystem.enums.StockStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "product")
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long productId;

    @Column(name = "restock_count", nullable = false)
    private Integer restockCount = 0;

    @Enumerated(EnumType.STRING)
    @Column(name = "stock_status", nullable = false)
    private StockStatus stockStatus = StockStatus.OUT_OF_STOCK;

    // ProductNotificationHistory와의 일대다 관계
    @OneToMany(mappedBy = "product")
    private List<ProductNotificationHistory> notificationHistories;


}


