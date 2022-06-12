package com.urpasswords.urpasswords.feature_passwords.data.data_source

import androidx.room.Database
import androidx.room.RoomDatabase
import com.urpasswords.urpasswords.feature_passwords.domain.model.Account
import com.urpasswords.urpasswords.feature_passwords.domain.model.Category
import com.urpasswords.urpasswords.feature_passwords.domain.model.Tag
import com.urpasswords.urpasswords.feature_passwords.domain.model.relations.AccountTagCrossRef

@Database(
    entities = [
        Account::class,
        Category::class,
        Tag::class,
        AccountTagCrossRef::class
    ],
    version = 1
)
abstract class UrPasswordsDatabase : RoomDatabase() {

    abstract val dao: UrPasswordsDao
}