package br.com.fundatec.fundatecheroesti21.splashscreen.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.fundatec.fundatecheroesti21.login.domain.LoginUseCase
import br.com.fundatec.fundatecheroesti21.login.presentation.LoginViewModel
import br.com.fundatec.fundatecheroesti21.splashscreen.presentation.model.SplashScreenViewState

class SplashScreenLogViewModel : ViewModel() {

    private val usecase by lazy { LoginUseCase() }
    private val viewState = MutableLiveData<SplashScreenViewState>()
    val state: LiveData<SplashScreenViewState> = viewState


    suspend fun validadeCache(): Boolean {
        viewState.value = SplashScreenViewState.ShowLoginScreen

        val isTimeMaior: Boolean = true
        usecase.verifyTimeLogCache(isTimeMaior)
        if(!isTimeMaior) {

        }
        return isTimeMaior
    }
}
