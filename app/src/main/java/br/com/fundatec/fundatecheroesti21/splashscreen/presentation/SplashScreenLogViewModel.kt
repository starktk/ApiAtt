package br.com.fundatec.fundatecheroesti21.splashscreen.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.fundatec.fundatecheroesti21.splashscreen.presentation.model.SplashScreenViewState

class SplashScreenLogViewModel: ViewModel() {

    private val viewState = MutableLiveData<SplashScreenViewState>()
    val state: LiveData<SplashScreenViewState> = viewState

    fun validadeCache () {

    }
}