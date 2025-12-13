package org.duonapp.duonapp.pages.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import org.duonapp.duonapp.components.DuoPage
import org.duonapp.duonapp.routes.Routes

@Composable
fun HomeScreen(onNavigate: (pathname: String) -> Unit) {

    DuoPage {
        Column(
            Modifier
                .safeContentPadding()
        ) {
            Button(onClick = {
                onNavigate(Routes.Login)
            }) {
                Text("Log in")
            }
        }
    }
}