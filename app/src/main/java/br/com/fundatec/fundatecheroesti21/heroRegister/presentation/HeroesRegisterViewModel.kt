package br.com.fundatec.fundatecheroesti21.heroRegister.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.fundatec.fundatecheroesti21.character.data.domain.CharacterUseCase
import br.com.fundatec.fundatecheroesti21.heroRegister.presentation.model.HeroRegisterViewState
import kotlinx.coroutines.launch
import java.util.*
import java.util.regex.Pattern

class HeroesRegisterViewModel : ViewModel() {
    private val viewState = MutableLiveData<HeroRegisterViewState>()
    val state: LiveData<HeroRegisterViewState> = viewState
    private val usecase by lazy { CharacterUseCase() }

    fun validateInputs(name: String?, description: String?, age: String?, birth_date: String?,
                       select_heroType: String?, select_univerType: String?, url_image: String) {
        var patternBirthDate = Pattern.compile("\\d{2}[-\\/\\.]\\d{2}[-\\/\\.]\\d{4}|\\d{8}")
        var matcherBirthDate = patternBirthDate.matcher(birth_date.toString())

        viewState.value = HeroRegisterViewState.ShowLoading

        if (name.isNullOrBlank() && description.isNullOrBlank() && age.toString()
                .isNullOrBlank() && birth_date.toString().isNullOrBlank()
        ) {
            viewState.value = HeroRegisterViewState.ShowMessageError
            return
        }

        if (name.isNullOrBlank()) {
            viewState.value = HeroRegisterViewState.ShowNameError
            return
        }
        if (description.isNullOrBlank()) {
            viewState.value = HeroRegisterViewState.ShowDescriptionError
            return
        }

        if (age.isNullOrBlank() || age.equals("0")) {
            viewState.value = HeroRegisterViewState.ShowAgeError
            return
        }

        if (!matcherBirthDate.matches()) {
            viewState.value = HeroRegisterViewState.ShowBirthDateError
            return
        }

        if (birth_date.isNullOrBlank()) {
            viewState.value = HeroRegisterViewState.ShowNameError
            return
        }

        if (select_heroType.isNullOrEmpty()) {
            viewState.value = HeroRegisterViewState.ShowSelectHeroTypeError
            return
        }

        if (select_univerType.isNullOrEmpty()) {
            viewState.value = HeroRegisterViewState.ShowSelectUniverseTypeError
            return
        }


        fetchLogin(name, description, age, birth_date, select_heroType, select_univerType, url_image)
    }

    private fun fetchLogin(name: String, description: String, age: String, birth_date: String,
                           select_heroType: String, select_univerType: String, url_image: String) {


        viewModelScope.launch {
            val isSucess = usecase.adicionarPersonagem(name, description, age.toInt(), birth_date,
                select_heroType.uppercase(), select_univerType.uppercase(), url_image.uppercase())
            if (!isSucess) {
                viewState.value = HeroRegisterViewState.ShowActionError
            } else {
                viewState.value = HeroRegisterViewState.ShowHomeScreen
            }
        }

    }
}