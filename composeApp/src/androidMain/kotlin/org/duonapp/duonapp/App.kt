package org.duonapp.duonapp

import androidx.compose.runtime.*
import org.jetbrains.compose.ui.tooling.preview.Preview

import org.duonapp.duonapp.global.AppTheme
import org.duonapp.duonapp.routes.AppRoute

@Composable
@Preview
fun App() {
    AppTheme() {
        AppRoute()
    }
}