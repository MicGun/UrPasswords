package com.urpasswords.urpasswords.feature_passwords.domain.model.relations

import androidx.room.Entity

@Entity(primaryKeys = ["accountId", "tagName"])
data class AccountTagCrossRef(
    val accountId: String,
    val tagName: String
)
