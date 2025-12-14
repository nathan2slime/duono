package org.duonapp.duonapp.pages.login

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.duonapp.duonapp.global.DuoFontFamily

@Composable
fun LoginScreen(
    state: LoginState,
    onIntent: (LoginIntent) -> Unit
) {
    Column(
        modifier = Modifier
            .background(
                Brush.horizontalGradient(
                    colors = listOf(
                        MaterialTheme.colorScheme.primary,
                        MaterialTheme.colorScheme.primary
                    )
                )
            )
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween,
    ) {
        Column(Modifier.fillMaxHeight(0.5f)) {}
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
        ) {
            Column(modifier = Modifier.padding(24.dp)) {
                Column {
                    Text(
                        style = MaterialTheme.typography.displaySmall,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.primary,
                        fontFamily = DuoFontFamily,
                        text = "Welcome"
                    )
                    Column(Modifier.height(35.dp)) {}
                    Column {
                        OutlinedTextField(
                            value = state.email,
                            onValueChange = {
                                onIntent(LoginIntent.EmailChanged(it))
                            },
                            label = { Text(text = "Email") },
                            isError = state.emailError != null,
                            modifier = Modifier.fillMaxWidth()
                        )
                        state.emailError?.let {
                            Text(
                                it,
                                color = MaterialTheme.colorScheme.error,
                                style = MaterialTheme.typography.bodyMedium
                            )
                        }
                        Column(Modifier.height(10.dp)) {}
                        OutlinedTextField(
                            value = state.password,
                            label = { Text(text = "Password") },
                            modifier = Modifier.fillMaxWidth(),
                            isError = state.passwordError != null,
                            visualTransformation = PasswordVisualTransformation(),
                            onValueChange = {
                                onIntent(LoginIntent.PasswordChanged(it))
                            })
                        state.passwordError?.let {
                            Text(
                                it,
                                color = MaterialTheme.colorScheme.error,
                                style = MaterialTheme.typography.bodyMedium
                            )
                        }
                    }

                    Column(Modifier.height(35.dp)) {}
                    Button(
                        onClick = { onIntent(LoginIntent.Submit) },
                        enabled = state.isFormValid && !state.isLoading,
                        modifier = Modifier
                            .fillMaxWidth()
                    ) {
                        Text(
                            text = "Continue".uppercase(),
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }

            }
        }
    }
}