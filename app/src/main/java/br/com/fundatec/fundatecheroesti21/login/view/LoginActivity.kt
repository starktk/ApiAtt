package br.com.fundatec.fundatecheroesti21.login.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import br.com.fundatec.core.hide
import br.com.fundatec.core.show
import br.com.fundatec.fundatecheroesti21.home.view.HomeActivity
import br.com.fundatec.fundatecheroesti21.R
import br.com.fundatec.fundatecheroesti21.database.FHDatabase
import br.com.fundatec.fundatecheroesti21.databinding.ActivityLoginBinding
import br.com.fundatec.fundatecheroesti21.login.presentation.LoginViewModel
import br.com.fundatec.fundatecheroesti21.login.presentation.model.LoginViewState
import com.google.android.material.snackbar.Snackbar

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding

    private val viewModel: LoginViewModel by viewModels()

    private val database: FHDatabase by lazy {
        FHDatabase.getInstance()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Log.e("teste", database.userDao().getUser().toString())
        initializeObserver()

        binding.btLogin.setOnClickListener {
            viewModel.validateInputs(
                password = binding.pwd.text.toString(),
                email = binding.email.text.toString(),
            )
        }
    }

    private fun initializeObserver() {
        viewModel.state.observe(this) { viewState ->
            when (viewState) {
                LoginViewState.ShowHomeScreen -> showHome()
                LoginViewState.ShowErrorMessage -> showSnackError()
                LoginViewState.ShowEmailErrorMessage -> showEmailError()
                LoginViewState.ShowPasswordErrorMessage -> showPasswordError()
                LoginViewState.ShowLoading -> showLoading()
            }
        }
    }

    private fun showLoading() {
        binding.pbLoading.show()
    }

    private fun showEmailError() {
        binding.pbLoading.hide()
        binding.email.error = getString(R.string.login_email_error_message)
    }

    private fun showPasswordError() {
        binding.pbLoading.hide()
        binding.pwd.error = getString(R.string.login_password_error_message)
    }

    private fun showSnackError() {
        binding.pbLoading.hide()
        Snackbar.make(binding.root, R.string.login_error_message, Snackbar.LENGTH_LONG).show()
    }

    private fun showHome() {
        binding.pbLoading.hide()
        val intent = Intent(this@LoginActivity, HomeActivity::class.java)
        startActivity(intent)
        finish()
    }
}