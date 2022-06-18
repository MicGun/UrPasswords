package com.urpasswords.urpasswords.feature_passwords.domain.util

sealed class OrderType {
    object Ascending: OrderType()
    object Descending: OrderType()
}
