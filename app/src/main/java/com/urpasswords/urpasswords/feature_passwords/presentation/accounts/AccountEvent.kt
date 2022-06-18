package com.urpasswords.urpasswords.feature_passwords.presentation.accounts

import com.urpasswords.urpasswords.feature_passwords.domain.model.Account
import com.urpasswords.urpasswords.feature_passwords.domain.util.AccountOrder

sealed class AccountEvent {
    data class Order(val accountOrder: AccountOrder): AccountEvent()
    data class DeleteAccount(val account: Account): AccountEvent()
}
