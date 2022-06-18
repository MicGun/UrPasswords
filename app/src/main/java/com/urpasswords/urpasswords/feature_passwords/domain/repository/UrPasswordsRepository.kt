package com.urpasswords.urpasswords.feature_passwords.domain.repository

import com.urpasswords.urpasswords.feature_passwords.domain.model.Account
import com.urpasswords.urpasswords.feature_passwords.domain.model.Category
import com.urpasswords.urpasswords.feature_passwords.domain.model.Tag
import com.urpasswords.urpasswords.feature_passwords.domain.model.relations.AccountWithTags
import com.urpasswords.urpasswords.feature_passwords.domain.model.relations.CategoryWithAccounts
import com.urpasswords.urpasswords.feature_passwords.domain.model.relations.TagWithAccounts
import kotlinx.coroutines.flow.Flow

interface UrPasswordsRepository {

    fun getAccounts(): Flow<List<Account>>

    suspend fun getAccountById(accountId: Int): Account?

    suspend fun insertAccount(account: Account)

    suspend fun deleteAccount(account: Account)

    fun getCategories(): Flow<List<Category>>

    suspend fun insertCategory(category: Category)

    suspend fun deleteCategory(category: Category)

    fun getTags(): Flow<List<Tag>>

    suspend fun insertTag(tag: Tag)

    suspend fun deleteTag(tag: Tag)

    suspend fun getAccountsWithCategory(categoryName: String): List<CategoryWithAccounts>

    suspend fun getAccountsWithTag(tagName: String): List<TagWithAccounts>

    suspend fun getTagsWithAccount(accountId: Int): List<AccountWithTags>
}