package com.sparta.restocknotificationsystem.enums;

public enum NotificationStatus {
    IN_PROGRESS,         // 알림 발송 중
    CANCELED_BY_SOLD_OUT, // 재고 소진에 의한 알림 중단
    CANCELED_BY_ERROR,    // 오류로 인한 알림 중단
    COMPLETED             // 알림 발송 완료
}