package com.urpasswords.urpasswords.feature_passwords.data.data_source

import androidx.room.*
import com.urpasswords.urpasswords.feature_passwords.domain.model.Account
import com.urpasswords.urpasswords.feature_passwords.domain.model.Category
import com.urpasswords.urpasswords.feature_passwords.domain.model.Tag
import com.urpasswords.urpasswords.feature_passwords.domain.model.relations.AccountTagCrossRef
import com.urpasswords.urpasswords.feature_passwords.domain.model.relations.AccountWithTags
import com.urpasswords.urpasswords.feature_passwords.domain.model.relations.CategoryWithAccounts
import com.urpasswords.urpasswords.feature_passwords.domain.model.relations.TagWithAccounts
import kotlinx.coroutines.flow.Flow

@Dao
interface UrPasswordsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCategory(category: Category)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAccount(account: Account)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTag(tag: Tag)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAccountTagCrossRef(accountTagCrossRef: AccountTagCrossRef)

    @Query("SELECT * FROM account")
    fun getAccounts(): Flow<List<Account>>

    @Query("SELECT * FROM account WHERE accountId = :accountId")
    fun getAccountById(accountId: Int): Account?

    @Transaction
    @Query("SELECT * FROM category WHERE categoryName = :categoryName")
    suspend fun getCategoryWithAccounts(categoryName: String): List<CategoryWithAccounts>

    @Transaction
    @Query("SELECT * FROM tag WHERE tagName = :tagName")
    suspend fun getAccountsWithTag(tagName: String): List<TagWithAccounts>

    @Transaction
    @Query("SELECT * FROM account WHERE accountId = :accountId")
    suspend fun getTagsWithAccount(accountId: String): List<AccountWithTags>
}