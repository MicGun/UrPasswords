package com.urpasswords.urpasswords.feature_passwords.domain.util

sealed class AccountOrder(val orderType: OrderType) {
    class Title(orderType: OrderType): AccountOrder(orderType)
    class CreateTime(orderType: OrderType): AccountOrder(orderType)
    class ModifyTime(orderType: OrderType): AccountOrder(orderType)
}
