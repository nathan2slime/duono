package org.duonapp.duonapp.pages.login

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import androidx.lifecycle.viewModelScope

class LoginViewModel : ViewModel() {
    private val _state = MutableStateFlow(LoginState())
    val state = _state.asStateFlow()

    private val _effect = MutableSharedFlow<LoginEffect>()
    val effect = _effect.asSharedFlow()

    fun onIntent(intent: LoginIntent) {
        when (intent) {

            is LoginIntent.EmailChanged ->
                reduceEmail(intent.value)

            is LoginIntent.PasswordChanged ->
                reducePassword(intent.value)

            LoginIntent.Submit ->
                reduceSubmit()
        }
    }


    private fun reduceEmail(value: String) = reduce {
        val emailError = LoginValidator.validateEmail(value)

        copy(
            email = value,
            emailError = emailError,
            isFormValid = emailError == null && passwordError == null
        )
    }

    private fun reducePassword(value: String) = reduce {
        val passwordError = LoginValidator.validatePassword(value)

        copy(
            password = value,
            passwordError = passwordError,
            isFormValid = emailError == null && passwordError == null
        )
    }

    private fun reduceSubmit() = reduce {
        if (!isFormValid) return@reduce this

        emitEffect(LoginEffect.NavigateHome)

        copy(isLoading = true)
    }


    private fun reduce(block: LoginState.() -> LoginState) {
        _state.value = _state.value.block()
    }

    private fun emitEffect(effect: LoginEffect) {
        viewModelScope.launch {
            _effect.emit(effect)
        }
    }
}
