package com.urpasswords.urpasswords.feature_passwords.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Tag(
    @PrimaryKey(autoGenerate = false)
    val tagName: String,
)
