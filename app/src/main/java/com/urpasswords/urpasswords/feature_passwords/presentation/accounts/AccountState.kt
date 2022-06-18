package com.urpasswords.urpasswords.feature_passwords.presentation.accounts

import com.urpasswords.urpasswords.feature_passwords.domain.model.Account
import com.urpasswords.urpasswords.feature_passwords.domain.util.AccountOrder
import com.urpasswords.urpasswords.feature_passwords.domain.util.OrderType

data class AccountState(
    val accounts: List<Account> = emptyList(),
    val accountOrder: AccountOrder = AccountOrder.ModifyTime(OrderType.Descending)
)
