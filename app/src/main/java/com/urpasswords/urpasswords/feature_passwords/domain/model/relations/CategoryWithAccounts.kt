package com.urpasswords.urpasswords.feature_passwords.domain.model.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.urpasswords.urpasswords.feature_passwords.domain.model.Account
import com.urpasswords.urpasswords.feature_passwords.domain.model.Category

data class CategoryWithAccounts(
    @Embedded val category: Category,
    @Relation(
        parentColumn = "categoryName",
        entityColumn = "categoryName"
    )
    val accounts: List<Account>
)
