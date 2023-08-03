package br.com.fundatec.fundatecheroesti21.splashscreen.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.fundatec.fundatecheroesti21.login.domain.LoginUseCase
import br.com.fundatec.fundatecheroesti21.login.presentation.LoginViewModel
import br.com.fundatec.fundatecheroesti21.splashscreen.presentation.model.SplashScreenViewState
import kotlinx.coroutines.launch

class SplashScreenLogViewModel : ViewModel() {

    private val usecase by lazy { LoginUseCase() }
    private val viewState = MutableLiveData<SplashScreenViewState>()
    val state: LiveData<SplashScreenViewState> = viewState


    fun validadeCache() {

        viewModelScope.launch {
            viewState.value = SplashScreenViewState.ShowLoginScreen

            val userExist: Boolean = true
            usecase.verifyUserExist(userExist)
            if (!userExist) {
                viewState.value = SplashScreenViewState.ShowLoginScreen
            }

            val isTimeMaior: Boolean = true
            usecase.verifyTimeLogCache(isTimeMaior)
            if (!isTimeMaior) {
                viewState.value = SplashScreenViewState.ShowLoginScreen
            } else {
                viewState.value = SplashScreenViewState.isSucess
            }

        }
    }
}
