package br.com.fundatec.fundatecheroesti21.detail.view

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import br.com.fundatec.fundatecheroesti21.databinding.ActivityDetailBinding
import br.com.fundatec.fundatecheroesti21.profile.presentation.ProfileViewModel

class DetailActivity: AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
//        setContentView(binding.root)

//        initializeObserver()
//
//        binding.btRegister.setOnClickListener {
//            viewModel.validateInputs(
//                password = binding.pwd.text.toString(),
//                email = binding.email.text.toString(),
//                name = binding.nome.text.toString(),
//            )
//        }
    }

}