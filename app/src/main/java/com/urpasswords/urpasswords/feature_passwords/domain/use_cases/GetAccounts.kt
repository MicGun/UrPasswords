package com.urpasswords.urpasswords.feature_passwords.domain.use_cases

import com.urpasswords.urpasswords.feature_passwords.domain.model.Account
import com.urpasswords.urpasswords.feature_passwords.domain.repository.UrPasswordsRepository
import com.urpasswords.urpasswords.feature_passwords.domain.util.AccountOrder
import com.urpasswords.urpasswords.feature_passwords.domain.util.OrderType
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetAccounts(
    private val repository: UrPasswordsRepository
) {

    operator fun invoke(
        accountOrder: AccountOrder = AccountOrder.ModifyTime(OrderType.Descending)
    ): Flow<List<Account>> {
        return repository.getAccounts().map { accounts ->
            when(accountOrder.orderType) {
                is OrderType.Ascending -> {
                    when(accountOrder) {
                        is AccountOrder.Title -> accounts.sortedBy { it.accountName.lowercase() }
                        is AccountOrder.CreateTime  -> accounts.sortedBy { it.createAt }
                        is AccountOrder.ModifyTime  -> accounts.sortedBy { it.modifyAt }
                    }
                }
                is OrderType.Descending -> {
                    when(accountOrder) {
                        is AccountOrder.Title -> accounts.sortedByDescending { it.accountName.lowercase() }
                        is AccountOrder.CreateTime  -> accounts.sortedByDescending { it.createAt }
                        is AccountOrder.ModifyTime  -> accounts.sortedByDescending { it.modifyAt }
                    }
                }
            }
        }
    }
}