package com.urpasswords.urpasswords.di

import android.app.Application
import androidx.room.Room
import com.urpasswords.urpasswords.feature_passwords.data.data_source.UrPasswordsDatabase
import com.urpasswords.urpasswords.feature_passwords.data.repository.UrPasswordsRepositoryImpl
import com.urpasswords.urpasswords.feature_passwords.domain.repository.UrPasswordsRepository
import com.urpasswords.urpasswords.feature_passwords.domain.use_cases.AccountUseCases
import com.urpasswords.urpasswords.feature_passwords.domain.use_cases.DeleteAccount
import com.urpasswords.urpasswords.feature_passwords.domain.use_cases.GetAccounts
import com.urpasswords.urpasswords.feature_passwords.domain.use_cases.InsertAccount
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideUrPasswordsDatabase(app: Application): UrPasswordsDatabase {
        return Room.databaseBuilder(
            app,
            UrPasswordsDatabase::class.java,
            UrPasswordsDatabase.DATABASE_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun provideUrPasswordsRepository(db: UrPasswordsDatabase): UrPasswordsRepository {
        return UrPasswordsRepositoryImpl(db.dao)
    }

    @Provides
    @Singleton
    fun provideAccountUseCases(repository: UrPasswordsRepository): AccountUseCases {
        return AccountUseCases(
            getAccounts = GetAccounts(repository),
            insertAccount = InsertAccount(repository),
            deleteAccount = DeleteAccount(repository)
        )
    }
}