package com.urpasswords.urpasswords.feature_passwords.domain.model

import android.graphics.Bitmap
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Account(
    val name: String,
    val userAccount: String,
    val userPasswords: String,
    val createAt: Long,
    val image: Bitmap,
    val key: String,
    @PrimaryKey val id: Int? = null
)
