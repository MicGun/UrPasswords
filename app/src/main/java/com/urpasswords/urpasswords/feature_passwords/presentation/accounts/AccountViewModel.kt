package com.urpasswords.urpasswords.feature_passwords.presentation.accounts

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.urpasswords.urpasswords.feature_passwords.domain.use_cases.AccountUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AccountViewModel @Inject constructor(
    private val accountUseCases: AccountUseCases
): ViewModel() {

    private val _state = mutableStateOf(AccountState())
    val state: State<AccountState> = _state

    fun onEvent(event: AccountEvent) {
        when(event) {
            is AccountEvent.Order -> {

            }
            is AccountEvent.DeleteAccount -> {

                viewModelScope.launch {
                    accountUseCases.deleteAccount(event.account)
                }
            }
        }
    }
}