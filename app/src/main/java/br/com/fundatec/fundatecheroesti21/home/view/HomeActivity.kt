package br.com.fundatec.fundatecheroesti21.home.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import br.com.fundatec.core.hide
import br.com.fundatec.core.show
import br.com.fundatec.fundatecheroesti21.character.data.remote.CharacterModel
import br.com.fundatec.fundatecheroesti21.character.view.CharacterListAdapter
import br.com.fundatec.fundatecheroesti21.databinding.ActivityHomeBinding
import br.com.fundatec.fundatecheroesti21.heroRegister.view.HeroRegisterActivity
import br.com.fundatec.fundatecheroesti21.home.presentation.HomeViewModel
import br.com.fundatec.fundatecheroesti21.home.presentation.model.HomeViewState


class HomeActivity : AppCompatActivity() {


    private lateinit var binding: ActivityHomeBinding
    private val viewModel: HomeViewModel by viewModels()
    private val characterListAdapter by lazy {
        CharacterListAdapter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvList.adapter = characterListAdapter

        initializeObserver()
        navigateNewHeroRegister()
    }



    override fun onResume() {
        super.onResume()
        viewModel.listCharacter()
    }

    private fun initializeObserver() {
        viewModel.state.observe(this) { viewState ->
            when (viewState) {
                is HomeViewState.ShowHomeScreen -> showHomeScreen(viewState.list)
                HomeViewState.ShowEmptyList -> showEmptyList()
                HomeViewState.ShowLoading -> showLoading()
            }
        }
    }

    private fun showLoading() {
        binding.pbLoading.show()
    }

    private fun showHomeScreen(list: List<CharacterModel>) {
        binding.pbLoading.hide()
        characterListAdapter.add(list)
    }

    fun showEmptyList() {
        binding.pbLoading.hide()
    }

    private fun navigateNewHeroRegister() {
        binding.btAddHero.setOnClickListener {

            val intent = Intent(this@HomeActivity, HeroRegisterActivity::class.java)
            startActivity(intent)
        }
    }

}

