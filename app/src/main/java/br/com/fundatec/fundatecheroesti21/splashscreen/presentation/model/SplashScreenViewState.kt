package br.com.fundatec.fundatecheroesti21.splashscreen.presentation.model

sealed class SplashScreenViewState {

    object isSucess: SplashScreenViewState()
    object ShowLoginScreen: SplashScreenViewState()
}