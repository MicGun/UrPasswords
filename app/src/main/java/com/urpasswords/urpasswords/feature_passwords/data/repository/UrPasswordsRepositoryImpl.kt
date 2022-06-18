package com.urpasswords.urpasswords.feature_passwords.data.repository

import com.urpasswords.urpasswords.feature_passwords.data.data_source.UrPasswordsDao
import com.urpasswords.urpasswords.feature_passwords.domain.model.Account
import com.urpasswords.urpasswords.feature_passwords.domain.model.Category
import com.urpasswords.urpasswords.feature_passwords.domain.model.Tag
import com.urpasswords.urpasswords.feature_passwords.domain.model.relations.AccountWithTags
import com.urpasswords.urpasswords.feature_passwords.domain.model.relations.CategoryWithAccounts
import com.urpasswords.urpasswords.feature_passwords.domain.model.relations.TagWithAccounts
import com.urpasswords.urpasswords.feature_passwords.domain.repository.UrPasswordsRepository
import kotlinx.coroutines.flow.Flow

class UrPasswordsRepositoryImpl(
    private val dao: UrPasswordsDao
): UrPasswordsRepository {
    override fun getAccounts(): Flow<List<Account>> {
        return dao.getAccounts()
    }

    override suspend fun getAccountById(accountId: Int): Account? {
        return dao.getAccountById(accountId)
    }

    override suspend fun insertAccount(account: Account) {
        dao.insertAccount(account)
    }

    override suspend fun deleteAccount(account: Account) {
        dao.deleteAccount(account)
    }

    override fun getCategories(): Flow<List<Category>> {
        return dao.getCategories()
    }

    override suspend fun insertCategory(category: Category) {
        dao.insertCategory(category)
    }

    override suspend fun deleteCategory(category: Category) {
        dao.deleteCategory(category)
    }

    override fun getTags(): Flow<List<Tag>> {
        return dao.getTags()
    }

    override suspend fun insertTag(tag: Tag) {
        dao.insertTag(tag)
    }

    override suspend fun deleteTag(tag: Tag) {
        dao.deleteTag(tag)
    }

    override suspend fun getAccountsWithCategory(categoryName: String): List<CategoryWithAccounts> {
        return dao.getAccountsWithCategory(categoryName)
    }

    override suspend fun getAccountsWithTag(tagName: String): List<TagWithAccounts> {
        return dao.getAccountsWithTag(tagName)
    }

    override suspend fun getTagsWithAccount(accountId: Int): List<AccountWithTags> {
        return dao.getTagsWithAccount(accountId)
    }
}