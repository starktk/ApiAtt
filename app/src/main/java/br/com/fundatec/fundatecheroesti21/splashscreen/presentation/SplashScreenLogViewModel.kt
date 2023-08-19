package br.com.fundatec.fundatecheroesti21.splashscreen.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.fundatec.fundatecheroesti21.login.domain.LoginUseCase
import br.com.fundatec.fundatecheroesti21.login.presentation.LoginViewModel
import br.com.fundatec.fundatecheroesti21.splashscreen.domain.IsValidCacheUseCase
import br.com.fundatec.fundatecheroesti21.splashscreen.presentation.model.SplashScreenViewState
import com.bumptech.glide.Glide.init
import kotlinx.coroutines.launch

class SplashScreenLogViewModel : ViewModel() {

    private val useCase by lazy { IsValidCacheUseCase() }

    private val viewState = MutableLiveData<SplashScreenViewState>()
    val state: LiveData<SplashScreenViewState> = viewState

        init {
            viewModelScope.launch {
                if (useCase.isValidCache()) {
                    viewState.value = SplashScreenViewState.isSucess
                } else {
                    viewState.value = SplashScreenViewState.ShowLoginScreen
                }
            }
        }

}
