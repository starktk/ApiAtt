package br.com.fundatec.fundatecheroesti21.character.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.fundatec.fundatecheroesti21.character.data.domain.CharacterUseCase
import kotlinx.coroutines.launch

class CharacterViewModel : ViewModel() {

    private val usecase by lazy { CharacterUseCase() }

    fun ListarPersnagens() {

        viewModelScope.launch {

        }
    }
}