package com.urpasswords.urpasswords.feature_passwords.domain.model

import android.graphics.Bitmap
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Category(
    @PrimaryKey val name:String,
    val image: Bitmap,
    val color: Int
)
