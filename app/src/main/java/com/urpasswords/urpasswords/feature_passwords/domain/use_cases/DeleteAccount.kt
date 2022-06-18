package com.urpasswords.urpasswords.feature_passwords.domain.use_cases

import com.urpasswords.urpasswords.feature_passwords.domain.model.Account
import com.urpasswords.urpasswords.feature_passwords.domain.repository.UrPasswordsRepository

class DeleteAccount(
    private val repository: UrPasswordsRepository
) {
    suspend operator fun invoke(account: Account) {
        repository.deleteAccount(account)
    }
}