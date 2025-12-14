package org.duonapp.duonapp.pages.login

sealed interface LoginIntent {
    data class EmailChanged(val value: String) : LoginIntent
    data class PasswordChanged(val value: String) : LoginIntent
    object Submit : LoginIntent
}

data class LoginState(
    val email: String = "",
    val password: String = "",

    val emailError: String? = null,
    val passwordError: String? = null,

    val isLoading: Boolean = false,
    val isFormValid: Boolean = false
)

sealed interface LoginEffect {
    object NavigateHome : LoginEffect
    data class ShowError(val message: String) : LoginEffect
}
