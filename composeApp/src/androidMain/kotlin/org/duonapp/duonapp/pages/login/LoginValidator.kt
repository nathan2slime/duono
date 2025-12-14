package org.duonapp.duonapp.pages.login

object LoginValidator {
    fun validateEmail(email: String): String? =
        when {
            email.isBlank() -> "Email is required"
            !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches() ->
                "Invalid email"

            else -> null
        }

    fun validatePassword(password: String): String? =
        when {
            password.isBlank() -> "Password is required"
            password.length < 6 -> "Password must be at least 6 characters"
            else -> null
        }
}
