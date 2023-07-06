package br.com.fundatec.fundatecheroesti21.splashscreen.view

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import br.com.fundatec.fundatecheroesti21.R
import br.com.fundatec.fundatecheroesti21.login.view.LoginActivity
import br.com.fundatec.fundatecheroesti21.splashscreen.presentation.SplashScreenLogViewModel

class SplashScreenLog: AppCompatActivity() {

    private val viewModel: SplashScreenLogViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_log)

        supportActionBar?.hide()

        Handler(Looper.getMainLooper()).postDelayed({
            viewModel.validadeCache()
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }, 3000)

    }
}