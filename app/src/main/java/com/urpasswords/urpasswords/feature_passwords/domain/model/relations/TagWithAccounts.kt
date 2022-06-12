package com.urpasswords.urpasswords.feature_passwords.domain.model.relations

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.urpasswords.urpasswords.feature_passwords.domain.model.Account
import com.urpasswords.urpasswords.feature_passwords.domain.model.Tag

data class TagWithAccounts(
    @Embedded val tag: Tag,
    @Relation(
        parentColumn = "tagName",
        entityColumn = "accountId",
        associateBy = Junction(AccountTagCrossRef::class)
    )
    val accounts: List<Account>
)
