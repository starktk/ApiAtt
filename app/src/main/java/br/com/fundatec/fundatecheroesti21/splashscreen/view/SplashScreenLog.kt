package br.com.fundatec.fundatecheroesti21.splashscreen.view

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import br.com.fundatec.fundatecheroesti21.R
import br.com.fundatec.fundatecheroesti21.databinding.ActivitySplashscreenlogBinding
import br.com.fundatec.fundatecheroesti21.home.view.HomeActivity
import br.com.fundatec.fundatecheroesti21.login.view.LoginActivity
import br.com.fundatec.fundatecheroesti21.splashscreen.presentation.SplashScreenLogViewModel
import br.com.fundatec.fundatecheroesti21.splashscreen.presentation.model.SplashScreenViewState

class SplashScreenLog: AppCompatActivity() {

    private lateinit var binding: ActivitySplashscreenlogBinding

    private val viewModel: SplashScreenLogViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_log)

        viewModel.state.observe(this) { viewState ->
            when (viewState) {
                    SplashScreenViewState.ShowLoginScreen -> showLoginScreen()
                    SplashScreenViewState.isSucess -> isSucess()
                }
            }




    }




    private fun showLoginScreen() {
        startActivity(Intent(this@SplashScreenLog, LoginActivity::class.java))
        finish()
    }

    fun isSucess() {
        startActivity(Intent(this@SplashScreenLog, HomeActivity::class.java))
        finish()
    }
}