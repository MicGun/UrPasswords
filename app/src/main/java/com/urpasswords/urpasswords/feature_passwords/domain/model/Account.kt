package com.urpasswords.urpasswords.feature_passwords.domain.model

import android.graphics.Bitmap
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Account(
    val accountName: String,
    val userAccount: String,
    val userPassword: String,
    val categoryName: String,
    val createAt: Long,
    val modifyAt: Long,
    val image: Bitmap,
    val key: String,
    @PrimaryKey val accountId: Int? = null
)
