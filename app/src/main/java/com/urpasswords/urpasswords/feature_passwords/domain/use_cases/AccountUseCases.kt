package com.urpasswords.urpasswords.feature_passwords.domain.use_cases

data class AccountUseCases(
    val getAccounts: GetAccounts,
    val insertAccount: InsertAccount,
    val deleteAccount: DeleteAccount
)
