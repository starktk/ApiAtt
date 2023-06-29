package br.com.fundatec.fundatecheroesti21.splashscreen.presentation.model

sealed class SplashScreenViewState {

    object ShowHomeScreen: SplashScreenViewState()
    object ShowLoginScreen: SplashScreenViewState()
}