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
fun LoginScreen() {
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
                            value = "",
                            label = { Text(text = "Email") },
                            onValueChange = { },
                            modifier = Modifier.fillMaxWidth()
                        )
                        Column(Modifier.height(10.dp)) {}
                        OutlinedTextField(
                            value = "",
                            label = { Text(text = "Password") },
                            modifier = Modifier.fillMaxWidth(),
                            visualTransformation = PasswordVisualTransformation(),
                            onValueChange = { })
                    }
                    Column(Modifier.height(35.dp)) {}
                    Button(
                        onClick = {}, modifier = Modifier
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