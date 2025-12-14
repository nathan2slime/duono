package org.duonapp.duonapp.pages.login
import androidx.compose.runtime.*
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun LoginRoute(
    onNavigateHome: () -> Unit
) {
    val vm: LoginViewModel = viewModel()
    val state by vm.state.collectAsState()

    LoginScreen(
        state = state,
        onIntent = vm::onIntent
    )

    LaunchedEffect(Unit) {
        vm.effect.collect {
            when (it) {
                LoginEffect.NavigateHome -> onNavigateHome()
                is LoginEffect.ShowError -> {
                }
            }
        }
    }
}
