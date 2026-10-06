package com.kiit.campusbites.data.model

data class Order(
    val id: String = "",
    val studentName: String = "",
    val items: List<String> = emptyList(),
    val totalAmount: Double = 0.0,
    val status: OrderStatus = OrderStatus.PENDING,
    val timestamp: Long = System.currentTimeMillis()
)

enum class OrderStatus {
    PENDING,
    ACCEPTED,
    REJECTED,
    PREPARING,
    READY,
    DELIVERED
}

