package com.urpasswords.urpasswords.feature_passwords.domain.model.relations

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.urpasswords.urpasswords.feature_passwords.domain.model.Account
import com.urpasswords.urpasswords.feature_passwords.domain.model.Tag

data class AccountWithTags(
    @Embedded val account: Account,
    @Relation(
        parentColumn = "accountId",
        entityColumn = "tagName",
        associateBy = Junction(AccountTagCrossRef::class)
    )
    val tags: List<Tag>
)
