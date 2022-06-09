package com.urpasswords.urpasswords.feature_passwords.data.data_source

import androidx.room.Dao
import androidx.room.Query
import com.urpasswords.urpasswords.feature_passwords.domain.model.Account
import kotlinx.coroutines.flow.Flow

@Dao
interface AccountDao {

    @Query("SELECT * FROM account")
    fun getAccounts(): Flow<List<Account>>

    @Query("SELECT * FROM account WHERE id = :id")
    fun getAccountById(id: Int): Account?
}